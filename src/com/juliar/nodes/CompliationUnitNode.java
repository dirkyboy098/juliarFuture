package com.juliar.nodes;

/**
 * Created by donreamey on 10/21/16.
 */
@SuppressWarnings("serial")
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
