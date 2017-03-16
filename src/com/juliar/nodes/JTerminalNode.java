package com.juliar.nodes;

import com.juliar.pal.PrimitivesMap;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by donreamey on 10/28/16.
 */
public class JTerminalNode extends NodeImpl{
    private TerminalNode dataString;

    public JTerminalNode(TerminalNode data){
        dataString = data;
    }

    public String dataString(){
        return dataString.getText();
    }


    public Boolean isPrimitive(){
        return PrimitivesMap.isPrimitive( dataString.getText());
    }

}
