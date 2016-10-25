package com.juliar.nodes;

import java.util.List;

/**
 * Created by donreamey on 10/25/16.
 */


public class AggregateNode implements Node {

    private Operation op;
    private List<BinaryNode> objectData;

    public AggregateNode(Operation operation){
        op = operation;
    }

    public AggregateNode(){
    }

    public AggregateNode(Operation operation, List<BinaryNode> data){
        op = operation;
        objectData = data;
    }

    public AggregateNode MakeNode(Operation operation, List<BinaryNode> data){
        return new AggregateNode(operation, objectData = data);
    }

    public Operation Operation(){
        return op;
    }

    public List<BinaryNode> Data(){
        return objectData;
    }
}