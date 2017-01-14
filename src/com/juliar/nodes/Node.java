package com.juliar.nodes;

import java.util.List;
import java.util.Stack;

/**
 * Created by donreamey on 10/21/16.
 */
public interface Node {
    void AddInst(Node parent, Node instruction);

    void AddInst(Node instruction);

    void AddInst(Stack<Node> contextStack, Node instruction);

    List<Node> getInstructions();
}
