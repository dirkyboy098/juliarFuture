package com.juliar.nodes;

public class LiteralNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.LiteralType;
    }
}
