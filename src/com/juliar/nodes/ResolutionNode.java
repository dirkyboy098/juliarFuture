package com.juliar.nodes;

@SuppressWarnings("serial")
public class ResolutionNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.ResolutionType;
    }

    @Override
    public IntegralType getIntegralType() {
        return null;
    }
}
