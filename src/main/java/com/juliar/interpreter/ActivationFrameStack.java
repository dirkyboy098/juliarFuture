package com.juliar.interpreter;

import com.juliar.errors.Logger;

import java.util.Stack;

public class ActivationFrameStack {
    private Stack<ActivationFrame> activationFrameStack = new Stack<>();

    public void push( ActivationFrame frame){
        Logger.log ("push [" + frame.frameName + "]");

        if ( activationFrameStack.stream().filter( p -> p.frameName.equals( frame.frameName) ).count() == 1) {
            throw new RuntimeException( "possible recursion on main method" );
        }

        activationFrameStack.push( frame );
    }

    public ActivationFrame pop(){
        Logger.log ("pop [" + activationFrameStack.peek().frameName +"]");
        return activationFrameStack.pop();
    }

    public ActivationFrame peek(){
        Logger.log ("peek [" + activationFrameStack.peek().frameName +"]");
        return activationFrameStack.peek();
    }

    public int size() {
        if (activationFrameStack.size() > 0){
            return activationFrameStack.size();
        }

        return 0;
    }
}
