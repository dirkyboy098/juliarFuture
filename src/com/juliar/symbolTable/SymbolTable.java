package com.juliar.symbolTable;

import com.juliar.nodes.Node;
import com.juliar.nodes.NodeType;
import com.juliar.nodes.VariableNode;

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
    private static SymbolTable symbolTable;
    private static Stack<String> currentScope = new Stack<>();

    static public SymbolTable createSymbolTable() {
        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }
        return symbolTable;
    }

    static public void clearSymbolTable(){
        currentScope.empty();
        symbolTable = null;
        symbolTable = null;
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

    public void addChild(Node child) {
        if (child instanceof VariableNode) {
            SymbolTableNode node = scopeHash.get(currentScope.peek());
            if (node.children.stream().filter(f -> ((VariableNode) f).variableName.equals(((VariableNode) child).variableName)).count() > 0) {
                throw new RuntimeException("identifier " + ((VariableNode) child).variableName + " already exist");
            }
        }
        scopeHash.get(currentScope.peek()).children.add(child);
    }

    public boolean doesChildExistAtScope(Node child){
        boolean variableCount = scopeHash.get( currentScope.peek() )
                .children.stream()
                .filter( f -> f instanceof VariableNode)
                .filter( t -> ((VariableNode)t).variableName.equals( ((VariableNode)child).variableName)).count() == 1;

        return variableCount;
    }


    class SymbolTableNode {
        public String levelNode;
        public List<Node> children = new ArrayList<>();
    }
}
