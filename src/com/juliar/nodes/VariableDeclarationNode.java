package com.juliar.nodes;

/**
 * Created by donreamey on 1/18/17.
 */
public class VariableDeclarationNode extends NodeImpl {
    public String type;

    @Override
    public NodeType getType() {
        return NodeType.VariableDeclarationType;
    }

    @Override
    public IntegralType getIntegralType(){
        if (!this.getInstructions().isEmpty()) {
            if (this.getInstructions().get(0) instanceof  KeywordNode) {
                KeywordNode keywordNode = (KeywordNode) this.getInstructions().get(0);
                if (!keywordNode.getInstructions().isEmpty()) {
                    return keywordNode.getIntegralType();
                }
            }
            if (this.getInstructions().get(0) instanceof  UserDefinedTypeNode) {
                UserDefinedTypeNode keywordNode = (UserDefinedTypeNode) this.getInstructions().get(0);
                return keywordNode.getInstructions().get(2).getIntegralType();
            }
        }

        assert true;
        return null;
    }

    public UserDefinedTypeNode getUserDefinedNode(){
        assert !this.getInstructions().isEmpty();
        return ( UserDefinedTypeNode )this.getInstructions().get(0);
    }

    public VariableNode getVariableNode(){
        return (VariableNode) instructions.get(1);
    }


}
