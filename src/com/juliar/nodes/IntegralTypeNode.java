package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by donreamey on 10/28/16.
 */
public class IntegralTypeNode extends NodeImpl {
    private FinalNode objectData;
    private String integralName;

    public IntegralTypeNode(FinalNode terminalNode, String name){
        objectData = terminalNode;
        integralName = name;
    }

    public IntegralTypeNode(){

    }

    public IntegralType getIntegralType()
    {
        return objectData.getIntegralType();
    }

    public String getIntegralName(){
        return integralName;
    }

    public FinalNode getIntegralValue(){
        return null;
    }

    @Override
    public NodeType getType() {
        return NodeType.IntegralTypeType;
    }

    public void writeNode( ObjectOutputStream stream){
        try {
            int ordrinal = getType().ordinal();
            stream.writeInt( ordrinal );

            if (integralName != null) {
                stream.writeChars(integralName);
            }

            if (objectData != null) {
                stream.writeChars(objectData.dataString());
            }

            for (Node n : instructions) {
                n.writeNode( stream );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
