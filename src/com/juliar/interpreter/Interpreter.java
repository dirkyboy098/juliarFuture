package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.LogMessage;
import com.juliar.nodes.*;
import com.juliar.symbolTable.SymbolTable;
import com.juliar.symbolTable.SymbolTypeEnum;
import javafx.beans.binding.BooleanExpression;

import java.util.*;

/**
 * Created by donreamey on 1/8/17.
 */
public class Interpreter {
    private static Stack<ActivationFrame> activationFrameStack = new Stack<ActivationFrame>();
    private Stack<Node> returnValueStack = new Stack<>();
    private List<Node> inst;
    private HashMap<String, Node> functionNodeMap;
    private HashMap<NodeType, Evaluate> functionMap = new HashMap<NodeType, Evaluate>();

    public Interpreter(InstructionInvocation invocation){
        try {
            EvaluateAssignments.Create(this);
            inst = invocation.getInstructionList();
            functionNodeMap = invocation.getFunctionNodeMap();

            functionMap.put(NodeType.CompliationUnitType        , ((n, activationFrame ) -> evalCompliationUnit()  ));

            functionMap.put(NodeType.VariableReassignmentType   , ((n, activationFrame )-> EvaluateAssignments.evalReassignment(n, activationFrame ) ));
            functionMap.put(NodeType.AssignmentType             , ((n, activationFrame )-> EvaluateAssignments.evalAssignment(n, activationFrame )  ));
            functionMap.put(NodeType.PrimitiveType              , ((n, activationFrame )-> EvaluatePrimitives.evalPrimitives(n, activationFrame)  ));

            functionMap.put(NodeType.AddType                    , ((n, activationFrame )-> evalAdd(n)     ));
            functionMap.put(NodeType.AggregateType              , ((n, activationFrame )-> evaluateAggregate(n, activationFrame)      ));
            functionMap.put(NodeType.CommandType                , ((n, activationFrame )-> evalCommand(n)      ));
            functionMap.put(NodeType.SummationType              , ((n, activationFrame )-> evalSummation(n)     ));

            functionMap.put(NodeType.FunctionaCallType          , ((n, activationFrame )-> evalFunctionCall(n)      ));
            functionMap.put(NodeType.FunctionDeclType           , ((n, activationFrame )-> evalFunctionDecl(n)      ));
            functionMap.put(NodeType.VariableType               , ((n, activationFrame )-> evalActivationFrame(n)   ));
            functionMap.put(NodeType.BinaryType                 , ((n, activationFrame )-> evalBinaryNode(n)        ));
            functionMap.put(NodeType.StatementType              , ((n, activationFrame )-> evalStatement(n)         ));
            functionMap.put(NodeType.ExpressionType             , ((n, activationFrame )-> evalStatement(n)         ));
            functionMap.put(NodeType.FinalType                  , ((n, activationFrame )-> evalFinal(n)             ));
            functionMap.put(NodeType.ReturnValueType            , ((n, activationFrame )-> evalReturn(n, activationFrame)             ));
            functionMap.put(NodeType.BooleanType                , ((n, activationFrame )-> evalBooleanNode(n, activationFrame)    ));
            functionMap.put(NodeType.BooleanOperatorType        , ((n, activationFrame )-> evalBooleanOperator(n, activationFrame)    ));
            functionMap.put(NodeType.IfExprType                 , ((n, activationFrame )-> evalIfStatement(n, activationFrame)    ));
            functionMap.put(NodeType.WhileExpressionType        , ((n, activationFrame )-> evalWhileExpression(n, activationFrame)));

            //functionMap.put(NodeType.VariableDeclarationType, (n-> eval(n)));
            //functionMap.put(NodeType.ReturnValueType            , (n-> evalReassignment(n)      ));

            execute(inst);
        }
        catch( Exception ex){
            LogMessage.message( ex.getMessage() );
        }
    }

    public List<Node> execute( List<Node> instructions) {
        for (Node Node : instructions) {
            Evaluate evaluate = functionMap.get( Node.getType());
            if (evaluate!= null){
                List<Node>  ints = evaluate.evaluate( Node , activationFrameStack.empty() ? null :  activationFrameStack.peek());
                if (ints != null) {
                    execute(ints);
                }
            }
            else{
                evalNull( Node );
            }
            continue;
        }

        return null;
    }

    private List<Node> evalCompliationUnit() {
        for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()) {
            if (entry.getKey().toString().equals("main")) {

                ActivationFrame frame = new ActivationFrame();
                frame.frameName = "main";
                activationFrameStack.push( frame );
                execute( entry.getValue().getInstructions() );
                activationFrameStack.pop();

                break;
            }
        }

        return null;
    }

    private List<Node> evalStatement( Node node){
        execute( node.getInstructions() );
        return null;
    }

    private List<Node> evalActivationFrame(Node node) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.variableSet.put (((VariableNode)node).variableName, node);
        return null;
    }

    private List<Node> evalSummation(Node node){
        return null;
    }

    private List<Node> evalCommand(Node node) {
        List<Node> slotList = new ArrayList<>();
        slotList.add( node.getInstructions().get(0) );
        return slotList;
    }

    private List<Node> evalAdd(Node node){
        return null;
    }


    private List<Node> evalNull(Node Node){
        return null;
    }

    private List<Node> evalFinal( Node Node){
        return null;
    }

    private List<Node> evalReturn(Node Node, ActivationFrame frame) {
        ReturnValueNode node = (ReturnValueNode)Node;
        if ( node.getType() == NodeType.ReturnValueType && node.getInstructions().get(0) instanceof FinalNode) {

            assert ((FinalNode) node.getInstructions().get(0)).dataString().equals( "return" ) : "Node does not have a return statement";

            ActivationFrame currentFrame = activationFrameStack.pop();
            ActivationFrame caller = activationFrameStack.peek() != null ? activationFrameStack.pop() : null;

            Node rValue = node.getInstructions().get( 1 );
            if (caller != null) {
                if (rValue instanceof VariableNode && frame.variableSet.containsKey( ((VariableNode) rValue).variableName )) {
                    caller.returnNode = frame.variableSet.get( ((VariableNode) rValue).variableName);
                }
                if (rValue instanceof IntegralTypeNode ) {
                    caller.returnNode = rValue;
                }

                activationFrameStack.push(caller);
                activationFrameStack.push(currentFrame);

                return null;
            }

            if (frame.variableSet.containsKey(node.typeName())) {
                Node variableNode = frame.variableSet.get(node.typeName());
                returnValueStack.push( variableNode );
            }
        }
        return null;
    }

    private List<Node> evalWhileExpression(Node node, ActivationFrame frame) {
        List<Node> instructionList = node.getInstructions();
        int size = instructionList.size();

        BooleanNode booleanNode = null;
        List<Node> trueExpressions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Node current = instructionList.get(i);

            if (current instanceof BooleanNode) {
                booleanNode = (BooleanNode) current;
                continue;
            }

            if (current instanceof StatementNode) {
                trueExpressions.add(current);
                continue;
            }
        }

        evalBooleanNode(booleanNode, frame);

        Node boolEvalResult = null;
        if (frame.returnNode != null) {
            boolEvalResult = frame.returnNode;

            FinalNode finalNode = (FinalNode) boolEvalResult.getInstructions().get(0);
            Boolean executeTrue = Boolean.parseBoolean(finalNode.dataString());

            if (executeTrue) {
                for (; ; ) {
                    for (int expressionCount = 0; expressionCount < trueExpressions.size(); expressionCount++) {
                        List<Node> currentExpressionInWhileBody = new ArrayList<>();
                        currentExpressionInWhileBody.add(trueExpressions.get(expressionCount));
                        execute(currentExpressionInWhileBody);
                    }

                    //NEED to revaluate the expression here!

                    boolEvalResult = frame.returnNode;
                    finalNode = (FinalNode) boolEvalResult.getInstructions().get(0);
                    executeTrue = Boolean.parseBoolean(finalNode.dataString());

                    if (executeTrue) {
                        continue;
                    }
                    break;
                }
            }
        }

        return null;
    }

    private List<Node> evalIfStatement(Node node, ActivationFrame frame){
        List<Node> instructionList = node.getInstructions();
        int size = instructionList.size();

        BooleanNode booleanNode = null;
        List<Node> trueExpressions = new ArrayList<>();

        for(int i=0; i<size; i++){
            Node current = instructionList.get(i);

            if (current instanceof BooleanNode){
                booleanNode = (BooleanNode)current;
                continue;
            }

            if(current instanceof StatementNode){
                trueExpressions.add( current );
                continue;
            }
        }

        if (booleanNode != null && booleanNode.getInstructions().size() == 1){
            FinalNode finalNode = (FinalNode)booleanNode.getInstructions().get(0);
            if (finalNode.getIntegralType() == IntegralType.jboolean){
                Boolean bool = Boolean.parseBoolean(finalNode.dataString());
                if (bool){
                    return trueExpressions;
                }
            }
        }

        return null;
    }

    private List<Node> evalFunctionDecl(Node Node){
        if (((FunctionDeclNode)Node).getFunctionName().toLowerCase() == "import"){
        }
        return null;
    }

    private List<Node> evalBooleanNode(Node node, ActivationFrame frame){
        String variableName = ((VariableNode)node.getInstructions().get(0)).variableName;
        Node lvalue =  frame.variableSet.get( variableName );

        BooleanOperatorNode booleanOperatorNode = (BooleanOperatorNode)node.getInstructions().get(1);

        Node rvalue = node.getInstructions().get(2);

        if (booleanOperatorNode.getInstructions().get(0) instanceof EqualEqualSignNode){
            boolean isEqualEqual =  ((FinalNode)lvalue.getInstructions().get(0)).dataString().equals( ((FinalNode)rvalue.getInstructions().get(0)).dataString() );
            FinalNode finalNode = new FinalNode();
            finalNode.setDataString( isEqualEqual );

            BooleanNode booleanNode = new BooleanNode();
            booleanNode.AddInst(finalNode);

            frame.returnNode = booleanNode;
        }
        return null;
    }

    private boolean isEqual(Node left, Node right){
        return left == right;
    }

    private boolean isLessThan(Node left, Node right){
        return false; //left < right;
    }

    private boolean isGreaterThan(Node left, Node right){
        return false;
    }

    private List<Node> evalBooleanOperator(Node node, ActivationFrame frame){

        return null;
    }

    private List<Node> evalFunctionCall(Node Node) {
        FunctionCallNode functionCallNode = (FunctionCallNode)Node;
        String functionToCall = functionCallNode.functionName();

        // main should only be called from the compliationUnit
        if (functionCallNode.equals( "main")){
            return null;
        }

        for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()){
            if (entry.getKey().toString().equals( functionToCall )) {
                ActivationFrame frame = new ActivationFrame();
                frame.frameName = functionToCall;
                activationFrameStack.push( frame );
                execute(entry.getValue().getInstructions());
                activationFrameStack.pop();
                break;
            }
        }

        return null;
    }


    private List<Node> AggregateNode(Node Node){
        List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)Node).data();
        int addCount = integralTypeNodes.size() - 1;
        //TODO Different Primitive Types //add
        for(IntegralTypeNode integralTypeNode : integralTypeNodes) {
            integralTypeNode( integralTypeNode);
        }
        for(int i =0;i<addCount;i++){
            binaryOperation( (a,b) -> a+b); //check
        }
        return null;
    }

    private List<Node> binaryNode( String variableName, Node Node){
        evalBinaryNode( Node );
        ActivationFrame frame = activationFrameStack.peek();
        VariableNode v = (VariableNode) frame.variableSet.get( variableName );

        v.setIntegralTypeNode( (IntegralTypeNode)frame.operandStack.pop() );
        return null;
    }

    private List<Node> evaluateAggregate(Node node, ActivationFrame frame){
        SummationType summationType = (SummationType)node.getInstructions().get(0);
        List<Node> list = node.getInstructions();

        int size = list.size();
        int sum = 0;

        for (int i = 1; i < size; i ++){
            String value = ((FinalNode)list.get(i).getInstructions().get(0)).dataString();
            sum += Integer.parseInt( value );
        }

        FinalNode returnNode = new FinalNode();
        returnNode.setDataString( sum );
        frame.returnNode = returnNode;

        return null;
    }


    private List<Node> evalBinaryNode(Node Node) {
        BinaryNode bn = (BinaryNode) Node;
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
        return null;
    }

    private List<Node> binaryOperation( IntegerMath integerMath) {
        ActivationFrame frame = activationFrameStack.peek();
     //   String data1 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
      //  int v1 = Integer.decode(data1).intValue();


     //   String data2 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
     //   int v2 = Integer.decode(data2).intValue();

     //   String sum = new Integer(integerMath.operation(v2, v1)).toString();

        //TODO - NEED to FIX THIS.
        //frame.operandStack.push(new IntegralTypeNode(sum, IntegralType.jinteger));
        return null;
    }

    private void integralTypeNode(IntegralTypeNode itn) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.operandStack.push(itn);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

    interface Evaluate {
        List<Node> evaluate(Node Node, ActivationFrame frame);
    }
}
