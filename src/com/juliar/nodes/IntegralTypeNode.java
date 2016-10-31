package com.juliar.nodes;

import com.juliar.parser.juliarParser;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by donreamey on 10/28/16.
 */
public class IntegralTypeNode implements Node {
    private String objectData;
    private IntegralType integralType;

    public IntegralTypeNode(){
    }

    public IntegralTypeNode(juliarParser.TypesContext value, JTerminalNode jTerminalNode) {
        if (value.FLOAT() != null) {
            objectData = value.FLOAT().getText();
            integralType =  IntegralType.jfloat;
        }else if (value.INT() != null) {
            objectData = value.INT().getText();
            integralType =  IntegralType.jinteger;
        }else if (value.DOUBLE() != null) {
            objectData = value.DOUBLE().getText();
            integralType =  IntegralType.jdouble;
        }else if (value.LONG() != null) {
            objectData = value.LONG().getText();
            integralType =  IntegralType.jlong;
        }
    }

    public String data(){
        return objectData;
    }

    public IntegralType getIntegralType() { return integralType; }

}
