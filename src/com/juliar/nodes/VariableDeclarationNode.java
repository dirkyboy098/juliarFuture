package com.juliar.nodes;

/**
 * Created by donreamey on 1/18/17.
 */
public class VariableDeclarationNode extends NodeImpl {
    public String type;

    public VariableDeclarationNode(){
    }

    @Override
    public NodeType getType() {
        return NodeType.VariableDeclarationType;
    }

    @Override
    public IntegralType getIntegralType(){
        if (this.getInstructions().size() > 0) {
            KeywordNode keywordNode = (KeywordNode) this.getInstructions().get(0);
            if (keywordNode.getInstructions().size() > 0 ) {
                return keywordNode.getIntegralType();
            }
        }

        assert true;
        return null;
    }
}
