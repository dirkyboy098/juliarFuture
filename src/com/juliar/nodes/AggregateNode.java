package com.juliar.nodes;

import java.util.List;

/**
 * Created by donreamey on 10/25/16.
 */


public class AggregateNode implements Node {

    private Operation op;
    private List<IntegralTypeNode> objectData;

    public AggregateNode(Operation operation){
        op = operation;
    }

    public AggregateNode(){
    }

    public AggregateNode(Operation operation, List<IntegralTypeNode> data){
        op = operation;
        objectData = data;
    }

    public AggregateNode MakeNode(Operation operation, List<IntegralTypeNode> data){
        return new AggregateNode(operation, objectData = data);
    }

    public Operation Operation(){
        return op;
    }

    public List<IntegralTypeNode> Data(){
        return objectData;
    }
}