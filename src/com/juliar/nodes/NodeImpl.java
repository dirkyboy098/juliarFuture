package com.juliar.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Don on 1/13/2017.
 */
public abstract class NodeImpl implements Node {
    protected List<Node> instructions = new ArrayList<>();

    @Override
    public void AddInst(Node parent, Node instruction) {
    /*add instruction given parent*/
    }

    @Override
    public void AddInst(Node instruction) {
        instructions.add( instruction );
    }

    @Override
    public void AddInst(Stack<Node> contextStack, Node instruction) {
        Node n = contextStack.peek();
        n.AddInst(instruction);
    }

    @Override
    public List<Node> getInstructions(){
        return instructions;
    }
}
