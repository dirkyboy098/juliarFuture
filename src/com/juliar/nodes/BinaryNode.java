package com.juliar.nodes;

/**
 * Created by donreamey on 10/21/16.
 */
public class BinaryNode implements Node {
    private Operation op;
    private BinaryNode lv;
    private BinaryNode rv;
    private Object objectData;

    public BinaryNode(Operation operation){
        op = operation;
    }

    public BinaryNode(){
    }

    public BinaryNode(Operation operation, Object data){
        op = operation;
        objectData = data;
    }

    public BinaryNode MakeNode(Operation operation, BinaryNode lvalue, BinaryNode rvalue){
        BinaryNode binaryNode = new BinaryNode(operation);
        binaryNode.lv = lvalue;
        binaryNode.rv = rvalue;

        return binaryNode;
    }

    public Operation Operation(){
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

