package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.*;

/**
 * Created by donreamey on 1/18/17.
 */
public class ActivationFrame {
    public String frameName;
    public Map<String, Node> variableSet = new HashMap<>();
    public Deque<Node> parameterStack = new ArrayDeque<>();
    public Deque<Node> operandStack = new ArrayDeque<>();
    public Node returnNode;
}
