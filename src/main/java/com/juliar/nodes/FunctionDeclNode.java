package com.juliar.nodes;

import java.util.List;
import java.util.Stack;

/**
 * Created by Don on 1/12/2017.
 */
@SuppressWarnings("serial")
public class FunctionDeclNode extends NodeImpl implements IContextInfo {
    private String functionName;

    public FunctionDeclNode(){
    }


    public FunctionDeclNode(String funcName, List<Node> inst){
        super();
        functionName = funcName;
        instructions = inst;
    }
    public String getFunctionName(){
        return functionName;
    }

    @Override
    public NodeType getType() {
        return NodeType.FunctionDeclType;
    }

}
