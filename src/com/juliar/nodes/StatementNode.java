package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by donreamey on 10/21/16.
 */
public class StatementNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.StatementType;
    }

}
