package com.juliar.nodes;

/**
 * Created by Don on 1/15/2017.
 */
public class VariableNode extends NodeImpl {
    public String type;
    public String variableName;
    public IntegralTypeNode integralTypeNode;


    public VariableNode(String t, String v){
        type = t;
        variableName = v;
    }

    public void SetIntegralTypeNode( IntegralTypeNode typeNode){
        integralTypeNode = typeNode;
    }
}
