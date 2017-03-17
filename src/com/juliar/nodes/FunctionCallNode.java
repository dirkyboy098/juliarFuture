package com.juliar.nodes;

/**
 * Created by Don on 1/12/2017.
 */
public class FunctionCallNode extends NodeImpl {
    private String functionNameString;

    public String functionName(){
        return functionNameString;
    }

    public FunctionCallNode(String funcName){
        functionNameString = funcName;
    }
}
