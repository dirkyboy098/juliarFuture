package com.juliar.nodes;

/**
 * Created by donreamey on 1/18/17.
 */
public class VariableDeclarationNode extends NodeImpl {
    public String type;

    public VariableDeclarationNode(){
    }

    @Override
    public NodeType getType() {
        return NodeType.VariableDeclarationType;
    }
}
