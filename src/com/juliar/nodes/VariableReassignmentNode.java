package com.juliar.nodes;

/**
 * Created by don on 3/25/17.
 */
@SuppressWarnings("serial")
public class VariableReassignmentNode extends NodeImpl {

    public Node getRvalueType(){
        return instructions.get(2).getInstructions().get(0);
    }

    @Override
    public NodeType getType() {
        return NodeType.VariableReassignmentType;
    }
}
