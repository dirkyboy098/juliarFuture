package com.juliar.nodes;

import java.util.List;
import java.util.Stack;

/**
 * Created by Don on 1/12/2017.
 */
public class FunctionDeclNode extends NodeImpl implements IContextInfo {
    private String functionName;

    public FunctionDeclNode(){
    }


    public FunctionDeclNode(String funcName, List<Node> inst){
        super();
        functionName = funcName;
        instructions = inst;
    }


    @Override
    public void addInst(Node parent, Node instruction) {
        super.addInst(parent, instruction);
    }

    @Override
    public void addInst(Node instruction) {
        super.addInst(instruction);
    }

    @Override
    public void addInst(Stack<Node> contextStack, Node instruction) {
        super.addInst(contextStack, instruction);
    }

    public String getFunctionName(){
        return functionName;
    }

    @Override
    public NodeType getType() {
        return NodeType.FunctionDeclType;
    }

}
