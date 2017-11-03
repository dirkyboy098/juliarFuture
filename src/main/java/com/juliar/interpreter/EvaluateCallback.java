package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.List;

interface Evaluate {
    List<Node> evaluate(Node node, ActivationFrame frame, Interpreter callback);
}