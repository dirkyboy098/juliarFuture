package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectOutputStream;
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

    @Override
    public NodeType getType() {
        return NodeType.AggregateType;
    }

    public void writeNode( ObjectOutputStream stream){
        try {
            int ordrinal = getType().ordinal();
            stream.writeInt( ordrinal );

            if (op != null) {
                stream.writeInt( op.ordinal() );
            }
            if ( objectData != null ) {
                for (IntegralTypeNode itn : objectData) {
                    itn.writeNode(stream);
                }
            }

            for (Node n : instructions) {
                n.writeNode( stream );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}