package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.List;

/**
 * Created by don on 3/30/17.
 */
public interface InterpreterCallback {
    public List<Node> execute(List<Node> instructions);
}
