package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.LogMessage;
import com.juliar.nodes.*;
import com.juliar.symbolTable.SymbolTypeEnum;

import java.util.*;

/**
 * Created by donreamey on 1/8/17.
 */
public class Interpreter {
    private Stack<ActivationFrame> activationFrameStack = new Stack<ActivationFrame>();
    private Stack<Node> returnValueStack = new Stack<>();
    private List<Node> inst;
    private InstructionInvocation invocationList;
    private HashMap<String, Node> functionNodeMap;
    private HashMap<Node, HashMap<String, Node>> functionMap = new HashMap<Node, HashMap<String, Node>>();

    public Interpreter(List<Node> instructions) {
        inst = instructions;
    }

    public Interpreter(InstructionInvocation invocation){
        try {
            invocationList = invocation;
            inst = invocation.getInstructionList();
            functionNodeMap = invocation.getFunctionNodeMap();

            execute(inst);
        }
        catch( Exception ex){
            LogMessage.message( ex.getMessage() );
        }
    }

    public void execute( List<Node> instructions) {
        for (Node n : instructions) {
            if (n instanceof CompliationUnitNode){
                evalCompliationUnit();
                continue;
            }
            if (n instanceof FunctionCallNode){
                evalFunctionCall((FunctionCallNode) n);
                continue;
            }
            if (n instanceof FunctionDeclNode){
                evalFunctionDecl((FunctionDeclNode) n);
            }
            if ( n instanceof ReturnValueNode){
                evalReturn((ReturnValueNode) n);
                continue;
            }
            if (n instanceof PrimitiveNode) {
                evalPrimitives((PrimitiveNode) n);
                continue;
            }
            if (n instanceof VariableNode){
                evalActivationFrame(n);
                continue;
            }
            if (n instanceof VariableDeclarationNode){
                continue;
            }
            if (n instanceof AssignmentNode) {
                evalAssignment((AssignmentNode) n);
            }
            if (n instanceof BinaryNode) {
                evalBinaryNode( n );
                continue;
            }
        }
    }

    private void evalActivationFrame(Node n) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.variableSet.put (((VariableNode)n).variableName, n);
    }

    private void evalCompliationUnit() {
        for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()) {
            if (entry.getKey().toString().equals("main")) {

                activationFrameStack.push( new ActivationFrame() );
                execute( entry.getValue().getInstructions() );
                activationFrameStack.pop();

                break;
            }
        }
    }

    private void evalReturn(ReturnValueNode n) {
        ReturnValueNode node = n;
        if (node.getSymbolTypeEnum() == SymbolTypeEnum.variableRef) {
            ActivationFrame frame =  activationFrameStack.peek();
            if (frame.variableSet.containsKey(node.typeName())) {
                Node variableNode = frame.variableSet.get(node.typeName());
                returnValueStack.push( variableNode );
            }
        }
    }

    private void evalFunctionDecl(FunctionDeclNode n){
        if (n.getFunctionName().toLowerCase() == "import"){

        }
    }

    private void evalFunctionCall(FunctionCallNode n) {
        FunctionCallNode functionCallNode = n;
        String functionToCall = functionCallNode.functionName();

        // main should only be called from the compliationUnit
        if (functionCallNode.equals( "main")){
            return;
        }

        for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()){
            if (entry.getKey().toString().equals( functionToCall )) {
                activationFrameStack.push( new ActivationFrame());
                execute(entry.getValue().getInstructions());
                activationFrameStack.pop();
                break;
            }
            else{
                // Should throw runtime exception if function can't be found
            }
        }

        return;
    }

    private void evalPrimitives(PrimitiveNode n) {
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
            if ( frame.variableSet.containsKey(argument)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argument);
                String variableValue = variableNode.integralTypeNode.data();
                float floatValue = Float.parseFloat(variableValue);
                com.juliar.pal.Primitives.sys_print_float(floatValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
        if (functionName.equals("printDouble")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argument)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argument);
                String variableValue = variableNode.integralTypeNode.data();
                double doubleValue = Double.parseDouble(variableValue);
                com.juliar.pal.Primitives.sys_print_double(doubleValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
        if (functionName.equals("printLong")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argument)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argument);
                String variableValue = variableNode.integralTypeNode.data();
                long longValue = Long.parseLong(variableValue);
                com.juliar.pal.Primitives.sys_print_long(longValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
    }

    private void evalAssignment(AssignmentNode n) {
        List<Node> instructions = n.getInstructions();

        // cache the variable that is going to get stuff assigned to it.
        VariableNode variableToAssignTo =  (VariableNode)instructions.get(0);

        // execute all of the instructions
        execute( instructions );

        // assign to cached variable for return.
        ActivationFrame frame = activationFrameStack.peek();
        if ( returnValueStack != null && !returnValueStack.empty()) {
            VariableNode v = (VariableNode)frame.variableSet.get( variableToAssignTo.variableName);
            frame.variableSet.remove( variableToAssignTo.variableName );
            frame.variableSet.put( variableToAssignTo.variableName, returnValueStack.pop());
        }
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
        evalBinaryNode( n );
        ActivationFrame frame = activationFrameStack.peek();
        VariableNode v = (VariableNode) frame.variableSet.get( variableName );

        v.setIntegralTypeNode( (IntegralTypeNode)frame.operandStack.pop() );
    }

    private void evalBinaryNode(Node n) {
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
