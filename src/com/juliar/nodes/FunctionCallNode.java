package com.juliar.nodes;

/**
 * Created by Don on 1/12/2017.
 */
public class FunctionCallNode extends NodeImpl {
    private String functionName;

    public String FunctionName(){
        return functionName;
    }

    public FunctionCallNode(String funcName){
        functionName = funcName;
    }
}
