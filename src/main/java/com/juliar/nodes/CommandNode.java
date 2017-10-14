package com.juliar.nodes;

/**
 * Created by donre on 4/5/2017.
 */
@SuppressWarnings("serial")
public class CommandNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.CommandType;
    }
}
