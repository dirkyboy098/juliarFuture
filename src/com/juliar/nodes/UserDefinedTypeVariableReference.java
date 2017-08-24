package com.juliar.nodes;

/**
 * Created by dreamey on 6/27/17.
 */
@SuppressWarnings("serial")
public class UserDefinedTypeVariableReference extends NodeImpl {
    public String getObjectName(){
        FinalNode finalNode =  (FinalNode)instructions.get(0).getInstructions().get(0);
        return finalNode.dataString();
    }

    public String getObjectTypeName() {
        //instructions.get
        return "";
    }

    @Override
    public NodeType getType() {
        return NodeType.UserDefinedVariableRefrenceType;
    }
}
