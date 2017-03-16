package com.juliar.nodes;

import com.juliar.parser.juliarParser;

/**
 * Created by donreamey on 10/28/16.
 */
public class IntegralTypeNode extends NodeImpl {
    private String objectData;
    private IntegralType integralType;

    public IntegralTypeNode(){
    }

    public IntegralTypeNode(String data, IntegralType it){
        objectData = data;
        integralType = it;
    }

    public IntegralTypeNode(juliarParser.TypesContext value) {
        objectData = value.getText();
        integralType = IntegralType.jinteger;
        /*
                break;
            case "int":
                objectData = value.getText();
                integralType = IntegralType.jinteger;
                break;
            case "double":
                objectData = value.getText();
                integralType = IntegralType.jdouble;
                break;
            case "long":
                objectData = value.getText();
                integralType = IntegralType.jlong;
                break;
            default:
                assert false;
        }
        */
    }

    public String data(){
        return objectData;
    }

    public IntegralType getIntegralType() { return integralType; }

}
