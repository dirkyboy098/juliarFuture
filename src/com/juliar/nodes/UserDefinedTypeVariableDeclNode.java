package com.juliar.nodes;

/**
 * Created by dreamey on 6/26/17.
 */
@SuppressWarnings("serial")
public class UserDefinedTypeVariableDeclNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.UserDefinedVariableDeclarationType;
    }

    public String getUserDefinedVariableTypeName(){
        UserDefinedTypeNameNode name = (UserDefinedTypeNameNode) instructions.get ( 0 );
        return name.getTypeName();
    }
}
