package com.juliar.nodes;

import org.omg.CORBA.NO_IMPLEMENT;

/**
 * Created by donre on 4/5/2017.
 */
public class AddNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.AddType;
    }
}
