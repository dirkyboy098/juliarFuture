package com.juliar.nodes;


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
    public void addInst(Node instruction) {
        super.addInst( instruction );
    }

    @Override
    public NodeType getType() {
        return NodeType.AssignmentType;
    }
}
