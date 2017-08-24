package com.juliar.nodes;

/**
 * Created by Don on 1/15/2017.
 */
@SuppressWarnings("serial")
public class VariableNode extends NodeImpl {
    private static final long serialVersionUID = 321323217;
    private Node parent;
    public String variableName;
    public IntegralTypeNode integralTypeNode;


    public Node getParent(){
        return parent;
    }

    public void setParent( Node parentNode){
        parent = parentNode;
    }


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
        return (FinalNode) this.getInstructions().get(0);
    }

}
