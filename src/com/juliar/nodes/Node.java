package com.juliar.nodes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    NodeType getType();

    void setNodeName();

    String getNodeName();


    IntegralType getIntegralType();

    void setVariableTypeByIntegralType( IntegralType type);

    void setVariableType(String variableType);

    void writeNode( ObjectOutputStream stream);

    NodeType readType( ObjectInputStream stream);

    }
