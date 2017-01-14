package com.juliar.nodes;

/**
 * Created by Don on 12/24/2016.
 */
public class PrimitiveNode extends NodeImpl {
    private String primitiveName;
    private String primitiveArgument;

    public PrimitiveNode(String name, String argument){
        primitiveName = name;
        primitiveArgument = argument;
    }

    public String getPrimitiveName(){
        return primitiveName;
    }

    public String getGetPrimitiveArgument(){
        return primitiveArgument;
    }
}
