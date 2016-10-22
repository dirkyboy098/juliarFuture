package com.juliar.nodes;

/**
 * Created by donreamey on 10/21/16.
 */
public class BinaryNode implements Node {
    private BinaryOperation op;
    private BinaryNode lv;
    private BinaryNode rv;
    private Object objectData;

    public BinaryNode(BinaryOperation operation){
        op = operation;
    }

    public BinaryNode(){
    }

    public BinaryNode(BinaryOperation operation, Object data){
        op = operation;
        objectData = data;
    }

    public BinaryNode MakeNode(BinaryOperation operation, BinaryNode lvalue, BinaryNode rvalue){
        BinaryNode binaryNode = new BinaryNode(operation);
        binaryNode.lv = lvalue;
        binaryNode.rv = rvalue;

        return binaryNode;
    }

    public BinaryOperation Operation(){
        return op;
    }

    public BinaryNode Left(){
        return lv;
    }

    public BinaryNode Right(){
        return rv;
    }

    public Object Data(){
        return objectData;
    }
}

