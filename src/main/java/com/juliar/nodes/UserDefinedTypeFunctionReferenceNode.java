package com.juliar.nodes;

public class UserDefinedTypeFunctionReferenceNode extends NodeImpl {

    public String getClassName(){
        UserDefinedTypeNameNode userDefinedTypeNameNode =  (UserDefinedTypeNameNode) instructions.get(0);
        return userDefinedTypeNameNode.getTypeName();
    }

    public FunctionCallNode getFuncCallNode() {
        return (FunctionCallNode)instructions.get(2);
    }

    @Override
    public NodeType getType() {
        return NodeType.UserDefinedFunctionReferenceType;
    }
}
