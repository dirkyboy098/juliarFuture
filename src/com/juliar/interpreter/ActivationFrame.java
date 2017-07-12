package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by donreamey on 1/18/17.
 */
public class ActivationFrame {
    public String frameName;
    public Map<String, Node> variableSet = new HashMap<>();
    public Stack<Node> parameterStack = new Stack<>();
    public Stack<Node> operandStack = new Stack<>();
    public Node returnNode;
}
