package com.juliar.nodes;

/**
 * Created by donreamey on 1/18/17.
 */
public class VariableDeclarationNode extends NodeImpl {
    public String type;
    public VariableNode variableNode;

    public VariableDeclarationNode ( String type, VariableNode variableNode){
        this.type = type;
        this.variableNode = variableNode;
    }

    public VariableDeclarationNode(){
    }
}
