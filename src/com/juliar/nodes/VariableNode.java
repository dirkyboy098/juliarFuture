package com.juliar.nodes;

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


}
