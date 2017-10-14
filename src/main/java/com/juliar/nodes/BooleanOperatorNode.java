package com.juliar.nodes;

/**
 * Created by don on 4/1/17.
 */
@SuppressWarnings("serial")
public class BooleanOperatorNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.BooleanOperatorType;
    }
}
