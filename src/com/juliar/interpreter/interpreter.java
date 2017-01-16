package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.nodes.*;

import java.util.*;

/**
 * Created by donreamey on 1/8/17.
 */
public class interpreter {
    private Stack<Node> parameterStack = new Stack<Node>();
    private Stack<Node> operatorStack = new Stack<Node>();
    private Stack<Node> operandStack = new Stack<Node>();
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
                      execute(entry.getValue().getInstructions());
                      break;
                  }
              }
            }

            if (n instanceof FunctionCallNode){
                FunctionCallNode functionCallNode = (FunctionCallNode)n;
                String functionToCall = functionCallNode.FunctionName();

                // main should only be called from the compliationUnit
                if (functionCallNode.equals( "main ")){
                    continue;
                }

                for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()){
                    if (entry.getKey().toString().equals( functionToCall )) {
                        execute(entry.getValue().getInstructions());
                        break;
                    }
                }
            }

            if (n instanceof PrimitiveNode) {
                primitives((PrimitiveNode) n);
            }

            if (n instanceof AssignmentNode) {
                assignment((AssignmentNode) n);
            }

            if (n instanceof BinaryNode) {

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
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            int intValue = Integer.decode(argument).intValue();
            com.juliar.pal.Primitives.sys_print_int(intValue);
        }
        if (functionName.equals("printFloat")) {
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            float floatValue = Integer.decode(argument).floatValue();
            com.juliar.pal.Primitives.sys_print_float(floatValue);
        }
        if (functionName.equals("printDouble")) {
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            double doubleValue = Integer.decode(argument).doubleValue();
            com.juliar.pal.Primitives.sys_print_double(doubleValue);
        }
    }

    private void assignment(AssignmentNode n) {
        String variableName = n.getVariableNode().variableName;

        // only supports one command for now
        Node command = n.getInstructions().get(0);

        if (command instanceof BinaryNode) {
            binaryNode(command);
        }
        if (command instanceof AggregateNode){
            AggregateNode(command);
        }
        String type = n.getVariableNode().type;
    }

    private void AggregateNode(Node n){
        List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)n).data();
        int addCount = integralTypeNodes.size() - 1;
        //TODO Different Primitive Types //add
        for(IntegralTypeNode mintegralTypeNode : integralTypeNodes) {
            integralTypeNode((IntegralTypeNode) mintegralTypeNode);
        }
        for(int i =0;i<addCount;i++){
            binaryOperation( (a,b) -> a+b); //check
        }
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
        String data1 = ((IntegralTypeNode) operandStack.pop()).data();
        int v1 = Integer.decode(data1).intValue();


        String data2 = ((IntegralTypeNode) operandStack.pop()).data();
        int v2 = Integer.decode(data2).intValue();

        String sum = new Integer(integerMath.operation(v2, v1)).toString();

        operandStack.push(new IntegralTypeNode(sum, IntegralType.jinteger));
    }



    private void integralTypeNode(IntegralTypeNode itn) {
        operandStack.push(itn);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

}
