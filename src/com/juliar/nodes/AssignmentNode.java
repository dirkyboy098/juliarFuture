package com.juliar.nodes;


import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by donreamey on 1/7/17.
 */
public class AssignmentNode extends NodeImpl implements IContextInfo {
    private VariableNode variableNode;

    public AssignmentNode(VariableNode v){
        variableNode = v;
    }

    public VariableNode getVariableNode(){
        return variableNode;
    }

    @Override
    public void AddInst(Node instruction) {
        super.AddInst( instruction );
    }

    @Override
    public NodeType getType() {
        return NodeType.AssignmentType;
    }
}
