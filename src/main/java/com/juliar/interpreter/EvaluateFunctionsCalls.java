package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EvaluateFunctionsCalls {

    public static List<Node> evalUserDefinedFunctionCall (Node n){
        UserDefinedTypeFunctionReferenceNode userDefinedTypeFunctionReferenceNode = (UserDefinedTypeFunctionReferenceNode)n;
        //return evalFunctionCall( userDefinedTypeFunctionReferenceNode.getFuncCallNode() );
        return new ArrayList<>();
    }

    public static List<Node> evalFunctionCall(Node node , ActivationFrameStack activationFrame, String mainFunctionName, Map<String, Node> functionNodeMap) {
        FunctionCallNode functionCallNode = (FunctionCallNode)node;
        String functionToCall = functionCallNode.functionName();

        //ActivationFrame evalFrame = activationFrameStack.pop();
        boolean isPrimitive = EvaluatePrimitives.evalIfPrimitive( node, activationFrame.peek() );
        //activationFrameStack.push( evalFrame );
        if ( isPrimitive ){
            return new ArrayList<>();
        }

        // main should only be called from the compliationUnit
        if (functionCallNode.equals(  mainFunctionName )){
            return new ArrayList<>();
        }

        FunctionDeclNode functionDeclNode = (FunctionDeclNode)functionNodeMap.get( functionToCall );
        if (functionDeclNode != null) {
            ActivationFrame frame = new ActivationFrame();
            frame.frameName = functionToCall;

            List<VariableNode> sourceVariables = new ArrayList<>();
            List<VariableDeclarationNode> targetVariables = new ArrayList<>();

            for (Node v : node.getInstructions()) {
                if (v instanceof VariableNode) {
                    sourceVariables.add( (VariableNode)v );
                }
            }

            for(Node v : functionDeclNode.getInstructions()){
                if (v instanceof VariableDeclarationNode){
                    targetVariables.add( (VariableDeclarationNode)v );
                }
            }

            if (sourceVariables.size() != targetVariables.size()){
                throw new RuntimeException("Source and target variable count do not match");
            }

            // since the function that is getting called can reference the variable using the
            // formal parameters of the function this code will match the calling functions data
            // with the target calling functions variable name.
            for (int i = 0; i < sourceVariables.size(); i++){
                VariableNode variableNode = (VariableNode)targetVariables.get(0).getInstructions().get(1);
                if (variableNode.integralTypeNode == sourceVariables.get(i).integralTypeNode) {
                    frame.variableSet.put(variableNode.variableName, activationFrame.peek().variableSet.get(sourceVariables.get(i).variableName));
                }
                else {
                    throw new RuntimeException( "data types are not the same");
                }
            }

            activationFrame.push( frame );



            return getFunctionStatements( functionDeclNode.getInstructions() );

            //activationFrame.push(frame);
            //execute(functionDeclNode.getInstructions());
            //activationFrame.pop();
        }
        else {
            FinalNode primitiveArg = new FinalNode();
            primitiveArg.setDataString( functionToCall );
            PrimitiveNode primitiveNode = new PrimitiveNode();
            primitiveNode.addInst(primitiveArg);

            for(Node primArgs : node.getInstructions()){
                if (primArgs instanceof VariableNode || primArgs instanceof IntegralTypeNode){
                    primitiveNode.addInst( primArgs );
                }
            }

            return EvaluatePrimitives.evalPrimitives(primitiveNode, activationFrame.peek());
        }
    }

    private static List<Node> getFunctionStatements( List<Node> nodes){
        List<Node> statements = new ArrayList<>();
        for (Node n : nodes) {
            if (n instanceof StatementNode){
                statements.add( n );
            }
        }

        return statements;
    }

}
