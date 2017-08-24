package com.juliar.nodes;

/**
 * Created by donreamey on 10/31/16.
 */
@SuppressWarnings("serial")
public class IfExprNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.IfExprType;
    }
}
