package com.juliar.nodes;

import com.juliar.errors.Logger;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by donreamey on 10/28/16.
 */
@SuppressWarnings("serial")
public class FinalNode extends NodeImpl{
    private String dataString;
    private transient Object object;

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

        return dataString;

    }

    public Object dataObject(){
        if (object != null){
            return object;
        }

        return null;
    }

    @Override
    public IntegralType getIntegralType() {
        if (dataString.startsWith("\"") && dataString.endsWith("\"")) {
            return IntegralType.jstring;
        }

        try {
            return IntegralType.jinteger;
        } catch (Exception e) {
            Logger.log(e);
        }

        try {
            if (dataString.equalsIgnoreCase("true") || dataString.toLowerCase().endsWith("false")) {
                return IntegralType.jboolean;
            }
        } catch (Exception e) {
            Logger.log(e);
        }

        try {
            return IntegralType.jdouble;
        } catch (Exception e) {
            Logger.log(e);
        }

        try {
            return IntegralType.jfloat;
        } catch (Exception e) {
            Logger.log(e);
        }

        try {
            return IntegralType.jlong;
        } catch (Exception e) {
            Logger.log(e);
        }

        return IntegralType.jobject;
    }

    @Override
    public NodeType getType() {
        return NodeType.FinalType;
    }

}
