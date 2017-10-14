package com.juliar.nodes;

/**
 * Created by donreamey on 10/21/16.
 */
@SuppressWarnings("serial")
public class LineNode extends NodeImpl {
    public String lastersik;
    public BinaryNode binaryNode;
    public String rastersisk;

    @Override
    public NodeType getType() {
        return NodeType.LineNodeType;
    }
}
