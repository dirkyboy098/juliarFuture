package com.juliar.nodes;

/**
 * Created by donreamey on 3/22/17.
 */
@SuppressWarnings("serial")
public class KeywordNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.KeywordType;
    }

    @Override
    public IntegralType getIntegralType() {
        FinalNode finalNode = (FinalNode) this.getInstructions().get(0);

        switch (finalNode.dataString()) {
            case "int":
                return IntegralType.jinteger;
            case "string":
                return IntegralType.jstring;
            case "double":
                return IntegralType.jdouble;
            case "float":
                return IntegralType.jfloat;
            case "long":
                return IntegralType.jlong;
            case "class":
                return IntegralType.juserDefined;
            default:
                throw new RuntimeException("no type found");
        }
    }
}
