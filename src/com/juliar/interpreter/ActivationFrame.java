package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by donreamey on 1/18/17.
 */
public class ActivationFrame {
    private HashMap<String, Node> variableSet = new HashMap<String , Node>();
    private Stack<Node> parameterStack = new Stack<Node>();
}
