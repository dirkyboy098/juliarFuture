package com.juliar.symbolTable;

import com.juliar.nodes.Node;

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
    private List<SymbolTableNode> scopeList = new ArrayList<>();
    private static SymbolTable symbolTable;

    static public SymbolTable CreateSymbolTable() {
        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }
        return symbolTable;
    }

    public void AddLevel(Node level) {
        SymbolTableNode node = new SymbolTableNode();
        node.levelNode = level;
        scopeList.add(node);
    }

    public void AddChildToLevel(Node parent, Node child) {

        /*
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
        */
    }

    class SymbolTableNode {
        public Node levelNode;
        public List<Node> children = new ArrayList<>();
    }
}
