package com.juliar.nodes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    public void AddInst(Node parent, Node instruction) {
        super.AddInst(parent, instruction);
    }

    @Override
    public void AddInst(Node instruction) {
        super.AddInst(instruction);
    }

    @Override
    public void AddInst(Stack<Node> contextStack, Node instruction) {
        super.AddInst(contextStack, instruction);
    }

    public String getFunctionName(){
        return functionName;
    }

    @Override
    public NodeType getType() {
        return NodeType.FunctionDeclType;
    }

}
