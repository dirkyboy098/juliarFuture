package com.juliar.nodes;

import com.juliar.parser.juliarParser;

/**
 * Created by donreamey on 10/28/16.
 */
public class IntegralTypeNode extends NodeImpl {
    private JTerminalNode objectData;

    public IntegralTypeNode(JTerminalNode terminalNode){
        objectData = terminalNode;
    }

    public IntegralType getIntegralType()
    {
        return objectData.getIntegralType();
    }

    public String data(){
        return null;
    }

}
