package com.juliar.nodes;

/**
 * Created by don on 6/10/17.
 */
@SuppressWarnings("serial")
public class UserDefinedTypeDeclNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.UserDefinedDeclarationType;
    }
}
