package com.juliar.nodes;

/**
 * Created by don on 4/10/17.
 */
@SuppressWarnings("serial")
public class WhileExprNode extends NodeImpl{
    @Override
    public NodeType getType() {
        return NodeType.WhileExpressionType;
    }
}
