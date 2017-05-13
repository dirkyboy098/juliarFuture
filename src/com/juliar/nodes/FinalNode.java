package com.juliar.nodes;

import com.juliar.pal.PrimitivesMap;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.Integer.getInteger;

/**
 * Created by donreamey on 10/28/16.
 */
public class FinalNode extends NodeImpl{
    private String dataString;
    private Object object;

    public FinalNode(TerminalNode data){
        if (data.getText() != null ) {
            dataString = data.getText();
        } else if (data.getSymbol().getText() != null ){
            dataString = data.getSymbol().getText();
        }
    }

    public FinalNode(){

    }

    public void setDataString(Object data){
        object = data;
    }

    public String dataString() {
        if ( object == null && dataString == null){
            return "";
        }

        if ( object != null && dataString == null){
            return object.toString();
        }

        if (dataString != null) {
            return dataString;//.getText();
        }

        return null;
    }

    public Object dataObject(){
        if (object != null){
            return object;
        }

        return null;
    }


    public Boolean isPrimitive(){
        return PrimitivesMap.isPrimitive( dataString) ;//.getText());
    }

    public IntegralType getIntegralType() {
        if (dataString.startsWith("\"") && dataString.endsWith("\"")) {
            return IntegralType.jstring;
        }

        Object value = null;
        try {
            value = Integer.parseInt(dataString);
            if (value != null) {
                return IntegralType.jinteger;
            }
        } catch (Exception e) {
        }

        try {
            if (dataString.toLowerCase().equals("true") || dataString.toLowerCase().endsWith("false")) {
                value = Boolean.parseBoolean(dataString);
                if (value != null) {
                    return IntegralType.jboolean;
                }
            }
        } catch (Exception e) {
        }

        try {
            value = Double.parseDouble(dataString);
            if (value != null) {
                return IntegralType.jdouble;
            }
        } catch (Exception e) {
        }

        try {
            value = Float.parseFloat(dataString);
            if (value != null) {
                return IntegralType.jfloat;
            }
        } catch (Exception e) {
        }

        try {
            value = Long.parseLong(dataString);
            if (value != null) {
                return IntegralType.jlong;
            }
        } catch (Exception e) {
        }

        return IntegralType.jobject;
    }

    @Override
    public NodeType getType() {
        return NodeType.FinalType;
    }

}
