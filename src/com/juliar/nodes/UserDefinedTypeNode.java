package com.juliar.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by don on 5/18/17.
 */
public class UserDefinedTypeNode extends NodeImpl {

    public List< String > variableList = new ArrayList<String>();

    public List<String> functionList = new ArrayList<String>();

    @Override
    public NodeType getType() {
        return null;
    }
}
