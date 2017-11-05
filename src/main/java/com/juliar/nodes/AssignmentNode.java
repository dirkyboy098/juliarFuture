package com.juliar.nodes;


/**
 * Created by donreamey on 1/7/17.
 */
@SuppressWarnings("serial")
public class AssignmentNode extends NodeImpl implements IContextInfo {
    private VariableNode variableNode;

    public AssignmentNode(VariableNode v){
        variableNode = v;
    }

    public VariableNode getVariableNode(){
        return variableNode;
    }

    @Override
    public NodeType getType() {
        return NodeType.AssignmentType;
    }
}
