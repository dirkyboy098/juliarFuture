package com.juliar.nodes;

/**
 * Created by don on 4/1/17.
 */
public class BooleanNode extends NodeImpl {
    private static final long serialVersionUID = 321323215;
    private Node booleanOperatorNode = null;

    private VariableNode variableNodeLvalue = null;
    private FinalNode finalNodeRvalue = null;

    public void determineBooleanComparisionType() {
        if (instructions.size() == 3) {
            if (instructions.get(0) instanceof VariableNode) {
                variableNodeLvalue = (VariableNode) instructions.get( 0 );
            }

            booleanOperatorNode = instructions.get(1);


            Node rvalue = instructions.get( 2 );
            if ( instructions.get(2) instanceof PrimitiveNode) {
                finalNodeRvalue =  (FinalNode) instructions.get(2).getInstructions().get(0);
            }

            if ( rvalue instanceof FinalNode ){
                finalNodeRvalue = finalNodeRvalue;
            }

        }
    }

    public NodeType getLvalue(){
        return NodeType.VariableType;
    }

    public NodeType getComparisionType(){
       if ( booleanOperatorNode != null && booleanOperatorNode instanceof EqualEqualSignNode){
            return NodeType.EqualEqualType;
       }

        throw new RuntimeException("invaild comparision type");
    }

    public NodeType getRvalue(){
        return NodeType.FinalType;
    }

    @Override
    public NodeType getType() {
        return NodeType.BooleanType;
    }
}
