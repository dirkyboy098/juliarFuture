package com.juliar.nodes;

import static com.juliar.nodes.NodeType.UserDefinedNameType;

/**
 * Created by dreamey on 6/27/17.
 */
public class UserDefinedTypeNameNode extends NodeImpl{
    @Override
    public NodeType getType() {
        return UserDefinedNameType;
    }

    public String getTypeName(){
        FinalNode finalNode = (FinalNode)instructions.get ( 0 );
        return finalNode.dataString();
    }
}
