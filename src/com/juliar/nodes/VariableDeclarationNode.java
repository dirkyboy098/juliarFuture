package com.juliar.nodes;

/**
 * Created by donreamey on 1/18/17.
 */
@SuppressWarnings("serial")
public class VariableDeclarationNode extends NodeImpl {
    private static int ASSIGNMENT_SIZE = 4;
    private static int OPERATOR_SLOT = 3;
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

    public boolean isDeclarationWithAssignment(){
        return this.getInstructions().size() >= ASSIGNMENT_SIZE;
    }

    public KeywordNode getKeyWordNode(){
        return (KeywordNode) this.getInstructions().get ( 0 );
    }

    public boolean isOperatorEqualSign(){
        if ( this.getInstructions().size() >= OPERATOR_SLOT ){
            return this.getInstructions().get ( OPERATOR_SLOT - 1 ) instanceof EqualSignNode;
        }

        return false;
    }

    public Node getRightValue(){
        if ( this.getInstructions().size() == ASSIGNMENT_SIZE ){
            return this.getInstructions().get ( OPERATOR_SLOT );
        }

        return new NodeImpl() {
            @Override
            public NodeType getType() {
                return NodeType.Nul;
            }
        };
    }

    public VariableNode getVariableNode(){
        return (VariableNode) instructions.get(1);
    }


}
