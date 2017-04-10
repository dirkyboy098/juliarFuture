package com.juliar.symbolTable;

import com.juliar.nodes.Node;
import com.juliar.nodes.NodeType;

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
    private HashMap< String, SymbolTableNode> scopeHash = new HashMap<>();
    private List<SymbolTableNode> scopeList = new ArrayList<>();
    private int scopeIndex = 0;
    private static SymbolTable symbolTable;
    private static Stack<String> currentScope = new Stack<>();


    static public SymbolTable CreateSymbolTable() {
        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }
        return symbolTable;
    }

    public void addLevel(String level) {
        SymbolTableNode node = new SymbolTableNode();
        node.levelNode = level;

        if (scopeHash.containsKey(level)) {
            throw new RuntimeException("identifier " + level + " already exist");
        } else {
            currentScope.push(level);
            scopeHash.put(level, node);
        }
    }

    public void popScope(){
        currentScope.pop();
    }


    public void addChild(Node child){
        scopeHash.get( currentScope.peek() ).children.add( child );
    }

   /*  public void AddChildToLevel(Node parent, Node child) {
        if( parent != null){

        }


        Optional<SymbolTableNode> parentLevelNode = scopeList.stream().filter(f -> f.levelNode.getNodeName().equals(parent.getNodeName())).findFirst();

        if (parentLevelNode.get() == Optional.empty()){

        }

        if (parentLevelNode != null) {
            SymbolTableNode parentLevel = parentLevelNode.get();
            if ( parentLevel.children.stream().filter( c -> c.getNodeName().equals( child.getNodeName() )).count() == 0){
                parentLevel.children.add( child );
            }
            else {
                throw new RuntimeException("identifier " + child.getNodeName() + " already exist");
            }
        }

    }*/

    class SymbolTableNode {
        public String levelNode;
        public List<Node> children = new ArrayList<>();
    }
}
