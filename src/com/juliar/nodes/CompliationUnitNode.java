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


    @Override
    public void writeNode(ObjectOutputStream stream) {
        super.writeNode(stream);
        //stream.write
    }

    @Override
    public Node readObject (ObjectInputStream stream) {
        try {
            int type = stream.readInt();
            NodeType t[] = NodeType.values();

            int nextType = stream.readInt();

            if ( nextType == FunctionDeclType.ordinal()) {
                FunctionDeclNode functionDeclNode = new FunctionDeclNode();
                functionDeclNode.readObject(stream);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
