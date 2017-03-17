package com.juliar.nodes;

import java.util.List;

/**
 * Created by donreamey on 10/25/16.
 */


public class AggregateNode extends NodeImpl {

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

    public AggregateNode makeNode(Operation operation, List<IntegralTypeNode> data){
        return new AggregateNode(operation, objectData = data);
    }

    public Operation operation(){
        return op;
    }

    public List<IntegralTypeNode> data(){
        return objectData;
    }


}