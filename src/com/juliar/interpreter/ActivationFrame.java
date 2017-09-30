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

    public void pushReturnNode( Node node){
        if ( returnNode != null){
            parameterStack.push( returnNode );
        }

        returnNode = node;
    }

    public Node peekReturnNode(){
        if ( !parameterStack.empty() ){
            return parameterStack.peek();
        }

        return returnNode;
    }

    public Node popNode() {
        if (!parameterStack.empty()) {
            return parameterStack.pop();
        }

        return returnNode;
    }

    public void onPushRecurse(){
        if ( returnNode != null && returnNode.getInstructions().size() > 0){
            parameterStack.push( returnNode );
        }
    }

    public void onPopRecurse(){
        if (parameterStack.empty()){
            return;
        }
        returnNode = parameterStack.pop();
    }
}