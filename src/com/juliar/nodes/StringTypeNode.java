package com.juliar.nodes;

/**
 * Created by dreamey on 6/20/17.
 */
public class StringTypeNode extends NodeImpl {

    public String getStringData(){
        return ((FinalNode)instructions.get ( 0 )).dataString();
    }

    @Override
    public NodeType getType() {
        return NodeType.StringType;
    }
}
