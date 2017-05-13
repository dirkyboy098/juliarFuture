package com.juliar.nodes;

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
