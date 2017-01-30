package com.juliar.symbolTable;

import com.juliar.nodes.IContextInfo;
import sun.jvm.hotspot.debugger.cdbg.Sym;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
    private static SymbolTable symbolTable;
    private SymbolTableNode root;

    static public SymbolTable CreateSymbolTable(){
        if (symbolTable == null){
            symbolTable = new SymbolTable();
            symbolTable.AddLevel("global");
        }
        return symbolTable;
    }

    private void AddLevel(String current){
        if (root == null){
            root = new SymbolTableNode();
        }
        root.levelName = current;
    }

    public void AddLevel(String parent, String current){
        SymbolTableNode parentNode = findLevel(parent);
        SymbolTableNode childNode = findLevel( current );

        if (parentNode.levelName != childNode.levelName){

            if (!doesSymbolExistAtScope(parentNode, childNode)) {
                childNode.parent = parentNode;
                parentNode.children.add(childNode);
            }

        } else {
            if (!doesSymbolExistAtScope(root, childNode)) {
                root.children.add(childNode);
            }
        }
    }

    private boolean doesSymbolExistAtScope(SymbolTableNode parent, SymbolTableNode childNode) {
        long count = parent.children
                .stream()
                .filter( f -> f.levelName.equals( childNode.levelName )).count();

        if ( count > 0){
            throw new RuntimeException("identifier " + childNode.levelName + " already exist");
        }

        if (count > 0){
            return true;
        }

        return false;
    }

    public SymbolTableNode findLevel(String levelName){
        return findLevel(root, levelName);
    }

    private SymbolTableNode findLevel(SymbolTableNode node, String levelName){
        if (node.levelName == levelName){
            return node;
        }
        for(SymbolTableNode n : node.children){
            return findLevel( n, levelName);
        }

        SymbolTableNode newNode = new SymbolTableNode();
        newNode.levelName = levelName;
        return newNode;
    }

}

class SymbolTableNode{
    public String levelName;
    public SymbolTableNode parent;
    public List<SymbolTableNode> children = new ArrayList<>();
}