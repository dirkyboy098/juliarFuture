package com.juliar.nodes;

/**
 * Created by dreamey on 6/26/17.
 */
public class UserDefinedTypeVariableDeclNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.UserDefinedVariableDeclarationType;
    }
}
