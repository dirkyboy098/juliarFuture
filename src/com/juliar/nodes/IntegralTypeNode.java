package com.juliar.nodes;

/**
 * Created by donreamey on 10/28/16.
 */
public class IntegralTypeNode extends NodeImpl {
    private static final long serialVersionUID = 321323218;
    private FinalNode objectData;
    private String integralName;

    public IntegralTypeNode(FinalNode terminalNode, String name){
        objectData = terminalNode;
        integralName = name;
    }

    public IntegralTypeNode(){

    }

    @Override
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

}
