package com.juliar.nodes;

/**
 * Created by don on 4/17/17.
 */
@SuppressWarnings("serial")
public class BreakExprNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.BreakType;
    }
}
