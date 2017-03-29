package com.juliar.symbolTable;

import java.util.ArrayList;
import java.util.List;

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

    static public void DeleteSymbolTable(){
        symbolTable = null;
    }

    public void AddLevel(String parent, String current, SymbolTypeEnum symbolType){
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

    public SymbolTableNode findLevel(String levelName){
        return findLevel(root, levelName);
    }

    private void AddLevel(String current){
        if (root == null){
            root = new SymbolTableNode();
        }
        root.levelName = current;
    }

    private boolean doesSymbolExistAtScope(SymbolTableNode parent, SymbolTableNode childNode) {
        long count = parent.children
                .stream()
                .filter( f -> f.levelName.equals( childNode.levelName )).count();

        if ( count > 0){
            throw new RuntimeException("identifier " + childNode.levelName + " already exist");
        }

        return false;
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

    public void dumpSymbolTable(){
        dumpSymbolTable(root , "");
    }

    private void dumpSymbolTable(SymbolTableNode node, String space){
        if (node != null) {
            //System.out.print( space + node.levelName );
            for( SymbolTableNode n : node.children){
                space += "\t";
                dumpSymbolTable( n ,space);
            }

            space = "";
            System.err.println();
        }
    }

}

class SymbolTableNode{
    public String levelName;
    public SymbolTypeEnum symbolTypeEnum;
    public SymbolTableNode parent;
    public List<SymbolTableNode> children = new ArrayList<>();
}