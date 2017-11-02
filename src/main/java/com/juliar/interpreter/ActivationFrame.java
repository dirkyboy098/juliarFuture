package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by donreamey on 1/18/17.
 */
public class ActivationFrame {
    public String frameName;
    public HashMap<String, Node> variableSet = new HashMap<>();
    public Stack<Node> parameterStack = new Stack<>();
    public Stack<Node> operandStack = new Stack<>();
    private Node returnNode;

    public ActivationFrame(){
    }

    public ActivationFrame( String frameName){
        this.frameName = frameName;
    }

    public void pushReturnNode( Node node){
      parameterStack.push( node );
    }

    public Node peekReturnNode(){
        if ( parameterStack.empty() ){
            assert true : "return node stack is empty";
        }

        return parameterStack.peek();
    }

    public Node popNode() {
        if (parameterStack.empty()) {
            assert true : "return node stack is empty";
        }

        return parameterStack.pop();
    }
}