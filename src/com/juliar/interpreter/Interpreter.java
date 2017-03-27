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
    private HashMap<String, Node> functionNodeMap;
    private HashMap<NodeType, Evaluate> functionMap = new HashMap<NodeType, Evaluate>();

    public Interpreter(InstructionInvocation invocation){
        try {
            inst = invocation.getInstructionList();
            functionNodeMap = invocation.getFunctionNodeMap();

            functionMap.put(NodeType.CompliationUnitType        , (n -> evalCompliationUnit()   ));
            functionMap.put(NodeType.VariableReassignmentType   , (n -> evalReassignment(n)     ));
            functionMap.put(NodeType.FunctionaCallType          , (n -> evalFunctionCall(n)     ));
            functionMap.put(NodeType.FunctionDeclType           , (n -> evalFunctionDecl(n)     ));
            functionMap.put(NodeType.ReturnValueType            , (n-> evalReassignment(n)      ));
            functionMap.put(NodeType.PrimitiveType              , (n-> evalPrimitives(n, null)  ));
            //functionMap.put(NodeType.VariableDeclarationType, (n-> eval(n)));
            functionMap.put(NodeType.VariableType               , (n-> evalActivationFrame(n)   ));
            functionMap.put(NodeType.AssignmentType             , (n-> evalActivationFrame(n)   ));
            functionMap.put(NodeType.BinaryType                 , (n-> evalBinaryNode(n)        ));
            functionMap.put(NodeType.StatementType              , (n-> evalStatement(n)         ));
            functionMap.put(NodeType.AssignmentType             , (n-> evalAssignment(n)        ));

            execute(inst);
        }
        catch( Exception ex){
            LogMessage.message( ex.getMessage() );
        }
    }

    public void execute( List<Node> instructions) {
        for (Node n : instructions) {
            functionMap.get( n.getType()).evaluate(n);

            if (n instanceof VariableDeclarationNode){
                continue;
            }
        }
    }

    private void evalStatement( Node n){
        execute( n.getInstructions() );
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
    private void evalFunctionDecl(Node n){
        if (((FunctionDeclNode)n).getFunctionName().toLowerCase() == "import"){
        }
    }

    private void evalFunctionCall(Node n) {
        FunctionCallNode functionCallNode = (FunctionCallNode)n;
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

    private void evalPrimitives(Node n, PrimitiveNode argument) {
        String functionName = ((PrimitiveNode)n).getPrimitiveName();
        String argumentName = argument.getPrimitiveName();

        if (functionName.equals("printLine")) {
            com.juliar.pal.Primitives.sys_print_line(argumentName);
        }
        /*
        if (functionName.equals("printInt")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argument)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argumentName);
                String variableValue = variableNode.integralTypeNode.getIntegralValue();
                int intValue = Integer.decode(variableValue).intValue();
                com.juliar.pal.Primitives.sys_print_int(intValue);
            }
            else {
                throw new RuntimeException("variable not found");
            }

        }
        if (functionName.equals("printFloat")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argumentName)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argumentName);
                String variableValue = variableNode.integralTypeNode.getIntegralValue();
                float floatValue = Float.parseFloat(variableValue);
                com.juliar.pal.Primitives.sys_print_float(floatValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
        if (functionName.equals("printDouble")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argumentName)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argumentName);
                String variableValue = variableNode.integralTypeNode.getIntegralValue();
                double doubleValue = Double.parseDouble(variableValue);
                com.juliar.pal.Primitives.sys_print_double(doubleValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
        if (functionName.equals("printLong")) {
            ActivationFrame frame = activationFrameStack.peek();
            if ( frame.variableSet.containsKey(argumentName)) {
                VariableNode variableNode = (VariableNode) frame.variableSet.get(argumentName);
                String variableValue = variableNode.integralTypeNode.getIntegralValue();
                long longValue = Long.parseLong(variableValue);
                com.juliar.pal.Primitives.sys_print_long(longValue);
            }
            else{
                throw new RuntimeException("variable not found");
            }
        }
        */
    }

    private void evalReassignment( Node n){
        Reas

    }

    private void evalAssignment(Node n) {
        AssignmentNode assignmentNode = (AssignmentNode)n;
        List<Node> instructions = assignmentNode.getInstructions();

        final int varDeclIndex = 0;
        final int equalSignIndex = 1;
        final int primtiveIndex = 2;
        VariableDeclarationNode variableToAssignTo =  (VariableDeclarationNode)instructions.get(  varDeclIndex );

        // | zero             | one       | two
        // | variableDecl     | EqualSign | Primitive
        // | int variableName | =         | 3

        if (instructions.get(equalSignIndex ) instanceof EqualSignNode ){
            Object rvalue = instructions.get( primtiveIndex );
            if (rvalue instanceof PrimitiveNode){
                PrimitiveNode p = (PrimitiveNode)rvalue;
                if (p != null && canPrimitiveValueBeAssignedToVar(variableToAssignTo, p)){
                    ActivationFrame frame = activationFrameStack.peek();
                    FinalNode variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);
                    String variableName = variableNameTerminalNode.dataString();

                    if (frame.variableSet.containsKey( variableName )) {
                        frame.variableSet.remove(variableName);
                    }

                    frame.variableSet.put( variableName, variableNameTerminalNode );
                }
            }
        }
    }


    private boolean canPrimitiveValueBeAssignedToVar(VariableDeclarationNode lvalue, PrimitiveNode rvalue){
        FinalNode lvalueTerminal =  (FinalNode)lvalue.getInstructions().get(0).getInstructions().get(0);
        FinalNode rvalueTerminal =  (FinalNode)rvalue.getInstructions().get(0);

        if (lvalueTerminal.dataString().equals( "int" )){
            int integerValue = Integer.parseInt(rvalueTerminal.dataString());
            return true;
        }

        return false;
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
     //   String data1 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
      //  int v1 = Integer.decode(data1).intValue();


     //   String data2 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
     //   int v2 = Integer.decode(data2).intValue();

     //   String sum = new Integer(integerMath.operation(v2, v1)).toString();

        //TODO - NEED to FIX THIS.
        //frame.operandStack.push(new IntegralTypeNode(sum, IntegralType.jinteger));
    }

    private void integralTypeNode(IntegralTypeNode itn) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.operandStack.push(itn);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

    interface Evaluate {
        void evaluate(Node n);
    }
}
