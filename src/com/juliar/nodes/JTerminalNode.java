package com.juliar.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by donreamey on 10/28/16.
 */
public class JTerminalNode implements Node{
    private TerminalNode dataString;

    public JTerminalNode(TerminalNode data){
        dataString = data;
    }

    public String dataString(){
        return dataString.getText();
    }

}
