package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.nodes.*;
import java.util.*;

/**
 * Created by donreamey on 1/8/17.
 */
public class interpreter {
    private Stack<ActivationFrame> activationFrameStack = new Stack<ActivationFrame>();
    private List<Node> inst;
    private InstructionInvocation invocationList;
    private HashMap<String, Node> functionNodeMap;

    public interpreter(List<Node> instructions) {
        inst = instructions;
    }

    public interpreter(InstructionInvocation invocation){
        invocationList = invocation;
        inst = invocation.getInstructionList();
        functionNodeMap = invocation.getFunctionNodeMap();

        execute(inst);
    }

    public void execute( List<Node> instructions) {
        for (Node n : instructions) {
            if (n instanceof CompliationUnitNode){
              for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()) {
                  if (entry.getKey().toString().equals("main")) {

                      activationFrameStack.push( new ActivationFrame() );
                      execute(entry.getValue().getInstructions());
                      activationFrameStack.pop();
                      break;
                  }
              }
            }

            if (n instanceof FunctionCallNode){
                FunctionCallNode functionCallNode = (FunctionCallNode)n;
                String functionToCall = functionCallNode.FunctionName();

                // main should only be called from the compliationUnit
                if (functionCallNode.equals( "main")){
                    continue;
                }

                for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()){
                    if (entry.getKey().toString().equals( functionToCall )) {
                        activationFrameStack.push( new ActivationFrame());
                        execute(entry.getValue().getInstructions());
                        activationFrameStack.peek();
                        break;
                    }
                    else{
                        // Should throw runtime exception if function can't be found
                    }
                }
            }

            if (n instanceof PrimitiveNode) {
                primitives((PrimitiveNode) n);
            }

            if (n instanceof VariableDeclarationNode){
                int i =3;
            }


            if (n instanceof VariableNode){
                ActivationFrame frame = activationFrameStack.peek();
                frame.variableSet.put (((VariableNode)n).variableName, n);
            }

            if (n instanceof AssignmentNode) {
                assignment((AssignmentNode) n);
            }

            if (n instanceof BinaryNode) {
                binaryNode( n );
            }
        }
    }

    private void primitives(PrimitiveNode n) {
        String functionName = n.getPrimitiveName();
        String argument = n.getGetPrimitiveArgument();

        if (functionName.equals("printLine")) {
            com.juliar.pal.Primitives.sys_print_line(argument);
        }
        if (functionName.equals("printInt")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argument)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argument);
                String variableValue = variableNode.integralTypeNode.data();
                int intValue = Integer.decode(variableValue).intValue();
                com.juliar.pal.Primitives.sys_print_int(intValue);
            }
            else {
                throw new RuntimeException("variable not found");
            }

        }
        if (functionName.equals("printFloat")) {
            ActivationFrame frame = activationFrameStack.peek();
            argument = ((IntegralTypeNode) frame.operandStack.pop()).data();
            float floatValue = Integer.decode(argument).floatValue();
            com.juliar.pal.Primitives.sys_print_float(floatValue);
        }
        if (functionName.equals("printDouble")) {
            ActivationFrame frame = activationFrameStack.peek();
            argument = ((IntegralTypeNode) frame.operandStack.pop()).data();
            double doubleValue = Integer.decode(argument).doubleValue();
            com.juliar.pal.Primitives.sys_print_double(doubleValue);
        }
    }

    private void assignment(AssignmentNode n) {

        String variableName = null;

        List<Node> instructions = n.getInstructions();
        if (instructions.size() >= 2 ){
            for( Node node: instructions) {
                if (node instanceof VariableDeclarationNode) {
                    // get the type and insure the value on stack matches
                    // if not runtime exception
                }

                if (node instanceof VariableNode) {
                    variableName = ((VariableNode) node).variableName;
                }
            }
        }

        execute(instructions);

        ActivationFrame frame = activationFrameStack.peek();
        VariableNode integral = (VariableNode)frame.variableSet.get ( variableName );
        IntegralTypeNode value = (IntegralTypeNode) frame.operandStack.pop();
        integral.SetIntegralTypeNode( value );

        /*
        for( Node node : instructions) {
            if (node instanceof VariableDeclarationNode) {
                //String type = n.getVariableNode().type;
            }

            if (node instanceof VariableNode){
                variableName = ((VariableNode)node).variableName;
                variableSet.put (variableName, node);
            }

            if (node instanceof BinaryNode) {
                binaryNode(variableName, node);
            }

            if (node instanceof AggregateNode) {
                AggregateNode(node);
            }
        }
        */
    }

    private void AggregateNode(Node n){
        List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)n).data();
        int addCount = integralTypeNodes.size() - 1;
        //TODO Different Primitive Types //add
        for(IntegralTypeNode integralTypeNode : integralTypeNodes) {
            integralTypeNode( integralTypeNode);
        }
        for(int i =0;i<addCount;i++){
            binaryOperation( (a,b) -> a+b); //check
        }
    }

    private void binaryNode( String variableName, Node n){
        binaryNode( n );
        ActivationFrame frame = activationFrameStack.peek();
        VariableNode v = (VariableNode) frame.variableSet.get( variableName );

        v.SetIntegralTypeNode( (IntegralTypeNode)frame.operandStack.pop() );
    }

    private void binaryNode(Node n) {
        BinaryNode bn = (BinaryNode) n;
        String operation = bn.operation().name();

        Object ol = bn.left();
        Object or = bn.right();

        if (ol instanceof IntegralTypeNode) {
            integralTypeNode((IntegralTypeNode) ol);
        }

        if (or instanceof IntegralTypeNode) {
            integralTypeNode((IntegralTypeNode) or);
        }

        switch (operation.toLowerCase()) {
            case "+":
            case "add":
                binaryOperation( (a, b) -> a + b );
                break;
            case "-":
            case "subtract":
                binaryOperation( (a, b) -> a - b );
                break;
            case "*":
            case "multiply":
                binaryOperation( (a, b) -> a * b );
                break;
            case "/":
            case "divide":
                binaryOperation( (a, b) -> a / b );
                break;
            case "%":
            case "modulo":
                binaryOperation( (a,b) -> a % b);
                break;
            default:
                assert true;
        }
    }

    private void binaryOperation( IntegerMath integerMath) {
        ActivationFrame frame = activationFrameStack.peek();
        String data1 = ((IntegralTypeNode) frame.operandStack.pop()).data();
        int v1 = Integer.decode(data1).intValue();


        String data2 = ((IntegralTypeNode) frame.operandStack.pop()).data();
        int v2 = Integer.decode(data2).intValue();

        String sum = new Integer(integerMath.operation(v2, v1)).toString();

        frame.operandStack.push(new IntegralTypeNode(sum, IntegralType.jinteger));
    }



    private void integralTypeNode(IntegralTypeNode itn) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.operandStack.push(itn);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

}
