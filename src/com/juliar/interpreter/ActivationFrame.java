package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by donreamey on 1/18/17.
 */
public class ActivationFrame {
    public String frameName;
    public HashMap<String, Node> variableSet = new HashMap<String , Node>();
    public Stack<Node> parameterStack = new Stack<Node>();
    public Stack<Node> operandStack = new Stack<Node>();
    public Node returnNode;
}
