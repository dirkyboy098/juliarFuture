package com.juliar.nodes;

/**
 * Created by Don on 12/24/2016.
 */
public class PrimitiveNode extends NodeImpl {
    private String primitiveName;
    private IntegralTypeNode primitiveArgument;

    public PrimitiveNode(String name){
        primitiveName = name;
    }

    public PrimitiveNode(){

    }

    public void setPrimitiveName(String name){
        primitiveName = name;
    }

    public String getPrimitiveName(){
        return primitiveName;
    }

    public IntegralTypeNode getGetPrimitiveArgument(){
        return primitiveArgument;
    }

    public IntegralType getArgumentType(){
        return primitiveArgument.getIntegralType();
    }
}
