package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Don on 1/15/2017.
 */
public class VariableNode extends NodeImpl {
    public String variableName;
    public IntegralTypeNode integralTypeNode;


    public VariableNode(String vName){
        variableName = vName;
    }

    public void setIntegralTypeNode(IntegralTypeNode typeNode){
        integralTypeNode = typeNode;
    }

    @Override
    public NodeType getType() {
        return NodeType.VariableType;
    }

    public void writeNode( ObjectOutputStream stream){
        try {
            int ordrinal = getType().ordinal();
            stream.writeInt( ordrinal );
            stream.writeChars( variableName );

            for (Node n : instructions) {
                n.writeNode( stream );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
