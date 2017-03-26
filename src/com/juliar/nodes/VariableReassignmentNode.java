package com.juliar.nodes;

/**
 * Created by don on 3/25/17.
 */
public class VariableReassignmentNode extends NodeImpl {

    @Override
    public NodeType getType() {
        return NodeType.VariableReassignmentType;
    }
}
