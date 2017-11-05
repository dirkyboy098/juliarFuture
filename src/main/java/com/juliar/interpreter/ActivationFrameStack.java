package com.juliar.interpreter;

import com.juliar.errors.Logger;
import com.juliar.nodes.IntegralTypeNode;
import com.juliar.nodes.Node;
import com.juliar.nodes.VariableNode;

import java.util.ArrayList;
import java.util.Stack;

public class ActivationFrameStack {
    private Stack<ActivationFrame> activationFrameStack = new Stack<>();

    public void push( ActivationFrame frame){
        Logger.log ("push [" + frame.frameName + "]");
        /*
        if ( activationFrameStack.stream().filter( p -> p.frameName.equals( "main" ) ).count() == 1) {
            throw new RuntimeException( "possible recursion on main method" );
        }*/

        activationFrameStack.push( frame );
    }

    public ActivationFrame pop(){
        Logger.log ("pop [" + activationFrameStack.peek().frameName +"]");
        return activationFrameStack.pop();
    }

    public ActivationFrame peek(){
        //Logger.log ("peek [" + activationFrameStack.peek().frameName +"]");
        return activationFrameStack.peek();
    }

    public int size() {
        if (activationFrameStack.size() > 0){
            return activationFrameStack.size();
        }

        return 0;
    }

    public Stack<Node> setupReturnStack( Node rValue ){

        int size = activationFrameStack.size();

        ActivationFrame currentFrame = activationFrameStack.get(size);
        ActivationFrame caller = activationFrameStack.get( size - 1 );

        if (caller != null) {
            if (rValue instanceof VariableNode && currentFrame.variableSet.containsKey( ((VariableNode) rValue).variableName )) {
                caller.pushReturnNode( currentFrame.variableSet.get( ((VariableNode) rValue).variableName ));
            }
            if (rValue instanceof IntegralTypeNode) {
                caller.pushReturnNode( rValue );
            }

            activationFrameStack.push(caller);
            activationFrameStack.push(currentFrame);

        }

        /*

        if (frame.variableSet.containsKey(node.typeName())) {
            Node variableNode = frame.variableSet.get(node.typeName());
            returnValueStack.push( variableNode );
        }
        */

        return new Stack<>();
    }
}
