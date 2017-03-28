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

            functionMap.put(NodeType.CompliationUnitType        , ((n, activationFrame ) -> evalCompliationUnit()   ));

            functionMap.put(NodeType.VariableReassignmentType   , ( (n, activationFrame )-> EvaluateAssignments.evalReassignment(n, activationFrame ) ));
            functionMap.put(NodeType.AssignmentType             , ( (n, activationFrame )-> EvaluateAssignments.evalAssignment(n, activationFrame )  ));

            functionMap.put(NodeType.FunctionaCallType          , ((n, activationFrame ) -> evalFunctionCall(n)     ));
            functionMap.put(NodeType.FunctionDeclType           , ((n, activationFrame ) -> evalFunctionDecl(n)     ));

            functionMap.put(NodeType.PrimitiveType              , ((n, activationFrame )-> EvaluatePrimitives.evalPrimitives(n, activationFrame)  ));
            functionMap.put(NodeType.VariableType               , ((n, activationFrame )-> evalActivationFrame(n)   ));
            functionMap.put(NodeType.BinaryType                 , ((n, activationFrame )-> evalBinaryNode(n)        ));
            functionMap.put(NodeType.StatementType              , ((n, activationFrame )-> evalStatement(n)         ));

            functionMap.put(NodeType.ExpressionType             , ((n, activationFrame )-> evalStatement(n)        ));
            functionMap.put(NodeType.FinalType                  , ((n, activationFrame )-> evalFinal(n)             ));

            //functionMap.put(NodeType.VariableDeclarationType, (n-> eval(n)));
            //functionMap.put(NodeType.ReturnValueType            , (n-> evalReassignment(n)      ));

            execute(inst);
        }
        catch( Exception ex){
            LogMessage.message( ex.getMessage() );
        }
    }

    public void execute( List<Node> instructions) {
        for (Node n : instructions) {
            Evaluate evaluate = functionMap.get( n.getType());
            if (evaluate!= null){
                evaluate.evaluate( n , activationFrameStack.empty() ? null :  activationFrameStack.peek());
            }
            else{
                evalNull( n );
            }
            continue;
        }
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

    private void evalStatement( Node n){
        execute( n.getInstructions() );
    }

    private void evalActivationFrame(Node n) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.variableSet.put (((VariableNode)n).variableName, n);
    }

    private void evalNull(Node n){
        System.out.println( "Node is null");
    }

    private void evalFinal( Node n){

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
        void evaluate(Node n, ActivationFrame frame);
    }
}
