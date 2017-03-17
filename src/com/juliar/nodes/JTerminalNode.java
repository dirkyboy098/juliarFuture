package com.juliar.nodes;

import com.juliar.pal.PrimitivesMap;
import org.antlr.v4.runtime.tree.TerminalNode;

import static java.lang.Integer.getInteger;

/**
 * Created by donreamey on 10/28/16.
 */
public class JTerminalNode extends NodeImpl{
    private TerminalNode dataString;
    private Object object;

    public JTerminalNode(TerminalNode data){
        dataString = data;
        object = data;

    }

    public String dataString(){
        return dataString.getText();
    }


    public Boolean isPrimitive(){
        return PrimitivesMap.isPrimitive( dataString.getText());
    }

    public IntegralType getIntegralType() {
        if (dataString.getText().startsWith("\"") && dataString.getText().endsWith("\"")) {
            return IntegralType.jstring;
        }

        Object value = null;
        try {
            value = Integer.parseInt(dataString.getText());
            if (value != null) {
                return IntegralType.jinteger;
            }
        } catch (Exception e) {
        }

        try {
            if (dataString.getText().toLowerCase().equals("true") || dataString.getText().toLowerCase().endsWith("false")) {
                value = Boolean.parseBoolean(dataString.getText());
                if (value != null) {
                    return IntegralType.jboolean;
                }
            }
        } catch (Exception e) {
        }

        try {
            value = Double.parseDouble(dataString.getText());
            if (value != null) {
                return IntegralType.jdouble;
            }
        } catch (Exception e) {
        }

        try {
            value = Float.parseFloat(dataString.getText());
            if (value != null) {
                return IntegralType.jfloat;
            }
        } catch (Exception e) {
        }

        try {
            value = Long.parseLong(dataString.getText());
            if (value != null) {
                return IntegralType.jlong;
            }
        } catch (Exception e) {
        }

        return IntegralType.jobject;
    }
}
