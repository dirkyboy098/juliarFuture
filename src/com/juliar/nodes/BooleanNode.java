package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by don on 4/1/17.
 */
public class BooleanNode extends NodeImpl {
    private Node booleanOperatorNode = null;

    VariableNode variableNodeLvalue = null;
    FinalNode finalNodeRvalue = null;

    public BooleanNode(){
        super();
    }

    public void determineBooleanComparisionType() {
        boolean variableComparision = false;

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
                finalNodeRvalue = (FinalNode) finalNodeRvalue;
            }

        }
    }

    public NodeType getLvalue(Node lvalue){
        lvalue = variableNodeLvalue;
        return NodeType.VariableType;
    }

    public NodeType getComparisionType(){
       if ( booleanOperatorNode != null && booleanOperatorNode instanceof EqualEqualSignNode){
            return NodeType.EqualEqualType;
       }

        throw new RuntimeException("invaild comparision type");
    }

    public NodeType getRvalue(Node rvalue){
        rvalue = finalNodeRvalue;
        return NodeType.FinalType;
    }

    @Override
    public NodeType getType() {
        return NodeType.BooleanType;
    }
}
