package com.juliar.nodes;

/**
 * Created by donreamey on 3/28/17.
 */
@SuppressWarnings("serial")
public class ExpressionNode extends NodeImpl{
    @Override
    public NodeType getType() {
        return NodeType.ExpressionType;
    }

    public String getVariableName(){
        if ( instructions.size() >= 2 && instructions.get(0) instanceof VariableDeclarationNode){
            VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode)instructions.get(0);
            return variableDeclarationNode.getVariableNode().variableName;
        }

        throw new RuntimeException( "variable does not have a name");
    }
}
