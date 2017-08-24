package com.juliar.symboltable;

import com.juliar.nodes.Node;
import com.juliar.nodes.UserDefinedTypeNode;
import com.juliar.nodes.VariableNode;
import com.juliar.vistor.Visitor;

import java.util.*;

/**
 * Created by donreamey on 1/9/17.
 *
 * root
 *   |
 *    - main
 *   |  |
 *   |  |- z1
 *   |  |
 *   |  |- X1
 *   |
 *    - test1
 *   |  |
 *   |  |- s
 *   |
 *    - foo1
 *   |
 *    - foo2
 */
public class SymbolTable {
    private static final String IDENTIFIERTXT = "identifier";
    private static final String EXISTTXT = " already exist";
    private HashMap< String, SymbolTableNode> scopeHash = new HashMap<>();
    private static SymbolTable symbolTable;
    private static Deque<String> currentScope = new ArrayDeque<>();
    private Visitor visitor;

    public static SymbolTable createSymbolTable(Visitor v) {
        if (symbolTable == null) {
            symbolTable = new SymbolTable( v );
        }
        return symbolTable;
    }

    public static void clearSymbolTable(){
        currentScope.isEmpty();
        symbolTable = null;
        symbolTable = null;
    }

    private SymbolTable(){
    }

    private SymbolTable( Visitor v){
        this();
        visitor = v;
    }

    public void addLevel(String level) {
        SymbolTableNode node = new SymbolTableNode();
        node.levelNode = level;

        if (scopeHash.containsKey(level)) {
            visitor.addError( IDENTIFIERTXT + " " + level + " " + EXISTTXT );
        } else {
            currentScope.push(level);
            scopeHash.put(level, node);
        }
    }

    public void popScope(){
        currentScope.pop();
    }

    public void addChild(Node child) {
        SymbolTableNode node = scopeHash.get(currentScope.peek());

        if (child instanceof VariableNode) {

            if (node.children.stream()
                    .filter(f -> f instanceof VariableNode && ((VariableNode) f)
                            .variableName.equals(((VariableNode) child)
                                    .variableName))
                    .count() > 0) {
                visitor
                        .addError(IDENTIFIERTXT + " " + ((VariableNode) child)
                                .variableName + " " + EXISTTXT);
            }
        } else if (child instanceof UserDefinedTypeNode &&  node.children.stream()
                .filter( f -> f instanceof UserDefinedTypeNode)
                .filter(f -> ((UserDefinedTypeNode) f)
                        .getTypeName()
                        .equals(((UserDefinedTypeNode) child)
                                .getTypeName()))
                .count() > 0){
                visitor.addError(IDENTIFIERTXT + ((UserDefinedTypeNode) child).getTypeName() + EXISTTXT);
        }

        node.children.add ( child );
    }


    public Node getNode(Node child){
        Node returnNode = null;

        if (child instanceof VariableNode){

            Deque<String> tempScope = new ArrayDeque<>();
            tempScope.push( currentScope.pop() );

            while ( !currentScope.isEmpty() ) {

                if (child instanceof VariableNode) {

                    SymbolTableNode node = scopeHash.get(currentScope.peek());
                    Optional<Node> nodeS = node.children.stream()
                            .filter(f -> f instanceof VariableNode)
                            .filter(f -> ((VariableNode) f).variableName.equals(((VariableNode) child).variableName)).findFirst();

                    returnNode = nodeS.orElse(null);
                }
                else if (child instanceof UserDefinedTypeNode){
                    SymbolTableNode node = scopeHash.get(currentScope.peek());

                    Optional<Node> nodeS2 = node.children.stream()
                            .filter(f -> f instanceof UserDefinedTypeNode)
                            .filter(f -> ((UserDefinedTypeNode) f).getTypeName().equals(((UserDefinedTypeNode) child).getTypeName())).findFirst();

                    returnNode =  nodeS2.orElse(null);
                }

                if (returnNode != null) {
                    break;
                }

               while (!tempScope.isEmpty()){
                    currentScope.push (tempScope.pop());
               }
            }
        }

        if (returnNode == null){
            throw new IllegalStateException( "unable to find variable -" + ((VariableNode)child).variableName + "in scope for reassignment");
        }

        return returnNode;
    }

    public boolean doesChildExistAtScope(Node child){
        Deque<String> tempScope = new ArrayDeque<>();
        tempScope.push ( currentScope.pop() );
        boolean doesExist = false;

        while ( !currentScope.isEmpty() ) {
            if (child instanceof  VariableNode) {
                doesExist = scopeHash.get(tempScope.peek())
                        .children.stream()
                        .filter(f -> f instanceof VariableNode)
                        .filter(t -> ((VariableNode) t).variableName.equals(((VariableNode) child).variableName)).count() == 1;
            } else if (child instanceof UserDefinedTypeNode){
                doesExist = scopeHash.get(tempScope.peek())
                        .children.stream()
                        .filter(f -> f instanceof UserDefinedTypeNode)
                        .filter(t -> ((VariableNode) t).variableName.equals(((UserDefinedTypeNode) child).getTypeName())).count() == 1;

            }
            if (doesExist) {
                break;
            }

            tempScope.push ( currentScope.pop() );
        }


        while(!tempScope.isEmpty()){
            currentScope.push ( tempScope.pop());
        }

        return doesExist;
    }


    class SymbolTableNode {
        private String levelNode;
        private List<Node> children = new ArrayList<>();

        public String getLevelNode() {
            return levelNode;
        }

        public void setLevelNode(String levelNode) {
            this.levelNode = levelNode;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
