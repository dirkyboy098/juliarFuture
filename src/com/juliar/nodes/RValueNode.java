package com.juliar.nodes;

import java.io.ObjectOutputStream;

/**
 * Created by donreamey on 3/22/17.
 */
public class RValueNode extends NodeImpl {

    @Override
    public NodeType getType() {
        return NodeType.RvalueType;
    }

}


