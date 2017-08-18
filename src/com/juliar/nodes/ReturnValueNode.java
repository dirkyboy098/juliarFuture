package com.juliar.nodes;

/**
 * Created by donreamey on 2/10/17.
 */
public class ReturnValueNode extends NodeImpl {
    private String typeName;

    public String typeName(){
        return typeName;
    }

    @Override
    public NodeType getType() {
        return NodeType.ReturnValueType;
    }

}
