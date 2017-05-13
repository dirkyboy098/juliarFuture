package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.juliar.nodes.NodeType.FunctionDeclType;

/**
 * Created by donreamey on 10/21/16.
 */
public class CompliationUnitNode extends NodeImpl  {

    @Override
    public NodeType getType() {
        return NodeType.CompliationUnitType;
    }

    @Override
    public String getNodeName() {
        return "CompliationUnitNode";
    }
}
