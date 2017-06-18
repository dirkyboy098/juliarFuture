package com.juliar.nodes;

/**
 * Created by Don on 1/15/2017.
 */
public class VariableNode extends NodeImpl {
    private static final long serialVersionUID = 321323217;
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


    public FinalNode getFinalNode(){
        FinalNode finalNode = (FinalNode)this.getInstructions().get(0);
        return finalNode;
    }

}
