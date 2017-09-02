package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.Logger;
import com.juliar.nodes.*;

import java.util.*;

/**
 * Created by donreamey on 1/8/17.
 */
public class Interpreter {
    private final static String mainFunctionName = "main";
    private static Stack<ActivationFrame> activationFrameStack = new Stack<>();
    private Stack<Node> returnValueStack = new Stack<>();
    private Map<String, Node> functionNodeMap;
    private Map<NodeType, Evaluate> functionMap = new HashMap<>();


    public Interpreter(InstructionInvocation invocation){
        try {
            EvaluateAssignments.create(this);
            List<Node> inst = invocation.getInstructionList();

            functionNodeMap = invocation.getFunctionNodeMap();

            functionMap.put( NodeType.CompliationUnitType        , ((n, activationFrame ) -> evalCompliationUnit()  ));

            functionMap.put( NodeType.VariableReassignmentType   , ( EvaluateAssignments::evalReassignment ));
            functionMap.put( NodeType.AssignmentType             , ( EvaluateAssignments::evalAssignment ));
            functionMap.put( NodeType.PrimitiveType              , ( EvaluatePrimitives::evalPrimitives ));
            functionMap.put( NodeType.BreakType                  , (this::evaluateBreak));

            functionMap.put( NodeType.AddType                    , ((n, activationFrame )-> evalAdd()     ));
            functionMap.put( NodeType.AggregateType              , (this::evaluateAggregate));
            functionMap.put( NodeType.CommandType                , ((n, activationFrame )-> evalCommand(n)      ));
            functionMap.put( NodeType.SummationType              , ((n, activationFrame )-> evalSummation()     ));

            functionMap.put( NodeType.FunctionaCallType          , ((n, activationFrame )-> evalFunctionCall(n)      ));
            functionMap.put( NodeType.FunctionDeclType           , ((n, activationFrame )-> evalFunctionDecl(n)      ));
            functionMap.put( NodeType.VariableType               , ((n, activationFrame )-> evalActivationFrame(n)   ));
            functionMap.put( NodeType.BinaryType                 , ((n, activationFrame )-> evalBinaryNode(n)        ));
            functionMap.put( NodeType.StatementType              , ((n, activationFrame )-> evalStatement(n)         ));
            functionMap.put( NodeType.ExpressionType             , ((n, activationFrame )-> evalStatement(n)         ));
            functionMap.put( NodeType.FinalType                  , ((n, activationFrame )-> evalFinal()             ));
            functionMap.put( NodeType.ReturnValueType            , (this::evalReturn));
            functionMap.put( NodeType.BooleanType                , (this::evalBooleanNode));
            functionMap.put( NodeType.BooleanOperatorType        , (this::evalBooleanOperator));
            functionMap.put( NodeType.IfExprType                 , (this::evalIfStatement));
            functionMap.put( NodeType.WhileExpressionType        , (this::evalWhileExpression));
            functionMap.put( NodeType.VariableDeclarationType    , (this::evalVariableDeclration));

            functionMap.put ( NodeType.UserDefinedFunctionReferenceType, ((n, activationFrameStack )-> evalUserDefinedFunctionCall(n)));

            //functionMap.put(NodeType.VariableDeclarationType, (n-> eval(n)));
            //functionMap.put(NodeType.ReturnValueType            , (n-> evalReassignment(n)      ));

            execute(inst);
        }
        catch( Exception ex){
            Logger.log(ex);
            //LogMessage.message( ex.printStackTrace() );
        }
    }

    public List<Node> execute( List<Node> instructions) {
        for (Node Node : instructions) {
            Evaluate evaluate = functionMap.get( Node.getType());
            if (evaluate!= null){
                List<Node>  ints = evaluate.evaluate( Node , activationFrameStack.empty() ? null :  activationFrameStack.peek());
                if (ints != null && !ints.isEmpty()) {
                    execute(ints);
                }
            }
            else{
                evalNull();
            }
        }

        return new ArrayList<>();
    }

    private List<Node> evalCompliationUnit() {
        for(Map.Entry<String, Node> entry : functionNodeMap.entrySet()) {
            if (entry.getKey().equals( mainFunctionName )) {

                ActivationFrame frame = new ActivationFrame();
                frame.frameName = mainFunctionName;
                activationFrameStack.push( frame );
                execute( entry.getValue().getInstructions() );
                activationFrameStack.pop();

                break;
            }
        }

        return new ArrayList<>();
    }

    private List<Node> evalStatement( Node node){
        execute( node.getInstructions() );
        return new ArrayList<>();
    }

    private List<Node> evalActivationFrame(Node node) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.variableSet.put (((VariableNode)node).variableName, node);
        return new ArrayList<>();
    }

    private List<Node> evalSummation(){
        return new ArrayList<>();
    }

    private List<Node> evalCommand(Node node) {
        List<Node> slotList = new ArrayList<>();
        slotList.add( node.getInstructions().get(0) );
        return slotList;
    }

    private List<Node> evaluateBreak(Node node, ActivationFrame frame){
        frame.returnNode = node;
        return new ArrayList<>();
    }

    private List<Node> evalAdd(){
        return new ArrayList<>();
    }

    private List<Node> evalNull(){
        assert true : "called evalNull";
        return new ArrayList<>();
    }

    private List<Node> evalFinal(){
        return new ArrayList<>();
    }

    private List<Node> evalReturn(Node oldnode, ActivationFrame frame) {
        ReturnValueNode node = (ReturnValueNode)oldnode;
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

                return new ArrayList<>();
            }

            if (frame.variableSet.containsKey(node.typeName())) {
                Node variableNode = frame.variableSet.get(node.typeName());
                returnValueStack.push( variableNode );
            }
        }
        return new ArrayList<>();
    }

    private List<Node> evalWhileExpression(Node node, ActivationFrame frame) {
        List<Node> instructionList = node.getInstructions();
        int size = instructionList.size();

        List<Node> trueExpressions = new ArrayList<>();
        BooleanNode booleanNode = getBooleanExpressionNode(instructionList, size, trueExpressions);

        evalBooleanNode(booleanNode, frame);

        Node boolEvalResult = null;
        if (frame.returnNode != null) {
            boolEvalResult = frame.returnNode;

            FinalNode finalNode = (FinalNode) boolEvalResult.getInstructions().get(0);
            Boolean executeTrue = Boolean.parseBoolean(finalNode.dataString());

            if (executeTrue) {
                Boolean breakStatement = false;
                while(true) {
                    for (int expressionCount = 0; expressionCount < trueExpressions.size(); expressionCount++) {
                        List<Node> currentExpressionInWhileBody = new ArrayList<>();
                        Node currentNode = trueExpressions.get( expressionCount );
                        currentExpressionInWhileBody.add( currentNode );

                        if (currentNode instanceof StatementNode && currentNode.getInstructions().get(0).getInstructions().get(0) instanceof BreakExprNode){
                            breakStatement = true;
                            break;
                        }

                        execute(currentExpressionInWhileBody);

                        if (frame.returnNode instanceof BreakExprNode){
                            breakStatement = true;
                            break;
                        }
                    }

                    if (breakStatement) {
                        frame.returnNode = null;
                        break;
                    }

                    // re-evaluate the loop condtion
                    evalBooleanNode(booleanNode, frame);
                    boolEvalResult = frame.returnNode;
                    finalNode = (FinalNode) boolEvalResult.getInstructions().get(0);

                    //assert finalNode.dataString().equalsIgnoreCase( "true ") || finalNode.dataString().equalsIgnoreCase( "false" ) : "A boolean value was not returned";

                    if (!(Boolean.parseBoolean( finalNode.dataString() ))) {
                        break;
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    private BooleanNode getBooleanExpressionNode(List<Node> instructionList, int size,List<Node> trueExpressions) {
        BooleanNode booleanNode = null;
        for (int i = 0; i < size; i++) {
            Node current = instructionList.get(i);

            if (current instanceof BooleanNode) {
                booleanNode = (BooleanNode) current;
                continue;
            }

            if (current instanceof StatementNode) {
                trueExpressions.add(current);
            }
        }
        return booleanNode;
    }

    private List<Node> evalIfStatement(Node node, ActivationFrame frame){
        List<Node> instructionList = node.getInstructions();
        int size = instructionList.size();


        List<Node> trueExpressions = new ArrayList<>();
        BooleanNode booleanNode = getBooleanExpressionNode(instructionList, size, trueExpressions);

        if (booleanNode != null && booleanNode.getInstructions().size() == 1){
            FinalNode finalNode = (FinalNode)booleanNode.getInstructions().get(0);
            if (finalNode.getIntegralType() == IntegralType.jboolean){
                Boolean bool = Boolean.parseBoolean(finalNode.dataString());
                if (bool){
                    return trueExpressions;
                }
            }
        } else if ( booleanNode != null && !booleanNode.getInstructions().isEmpty()){
            Node currentValue = frame.returnNode;
            frame.returnNode = null;
            Boolean booleanResult = false;
            evalBooleanNode( booleanNode, frame);

            if ( frame.returnNode != null && frame.returnNode instanceof BooleanNode ){
                Node booleanEvalReturnNode = frame.returnNode;
                FinalNode result = getFinalNodeFromAnyNode( booleanEvalReturnNode );
                booleanResult =  Boolean.parseBoolean( result.dataString() );
            }

            // TODO - FINISH THIS
            if ( booleanResult && frame.returnNode != null  ) {
                Node returnNode = frame.returnNode;
                if ( returnNode instanceof BreakExprNode){
                    List<Node> returnList = new ArrayList<>();
                    returnList.add( returnNode );
                    return new ArrayList<>();
                }
            }

            frame.returnNode = currentValue;
        }

        return new ArrayList<>();
    }

    private List<Node> evalFunctionDecl(Node node){
        return new ArrayList<>();
    }

    private List<Node> evalBooleanNode(Node node, ActivationFrame frame){
        Node variableType  = node.getInstructions().get(0);

        try {
            Node lvalue = null;
            if (variableType instanceof VariableNode) {
                String variableName = ((VariableNode) node.getInstructions().get(0)).variableName;
                lvalue = frame.variableSet.get(variableName);

            } else {
                lvalue = variableType;
            }

            boolean isEqualEqual;
            Node rvalue = null;
            // This is ugly code. Need to find a better way to
            // handle these cases.
            // Multiple ifs will only cause confusion.
            FinalNode updatedLvalue = null;

            if (node.getInstructions().size() == 1) {
                //lvalue must be a single boolean expression
                if (lvalue instanceof FinalNode) {
                    BooleanNode booleanNode = new BooleanNode();
                    booleanNode.addInst(lvalue);
                    frame.returnNode = booleanNode;
                    return new ArrayList<>();
                }

                if (lvalue instanceof PrimitiveNode) {
                    updatedLvalue = (FinalNode) lvalue.getInstructions().get(0);
                }

            } else if (node.getInstructions().size() > 1) {
                //if (booleanOperatorNode.getInstructions().get(0) instanceof EqualEqualSignNode) {
                    //isEqualEqual;
                //}
                rvalue = node.getInstructions().get(2);
                FinalNode updatedRvalue = null;
                if (rvalue != null && rvalue instanceof PrimitiveNode) {
                    updatedRvalue = (FinalNode) rvalue.getInstructions().get(0);
                }

                if (updatedLvalue != null) {
                    lvalue = updatedLvalue;
                }

                if (updatedRvalue != null) {
                    rvalue = updatedRvalue;
                }

                isEqualEqual = getFinalNodeFromAnyNode( lvalue) .dataString().equals( getFinalNodeFromAnyNode(rvalue).dataString());
                //else if (booleanOperatorNode.getInstructions().get(0) instanceof  )
                FinalNode finalNode = new FinalNode();
                finalNode.setDataString(isEqualEqual);

                BooleanNode booleanNode = new BooleanNode();
                booleanNode.addInst(finalNode);

                frame.returnNode = booleanNode;
                return new ArrayList<>();
            }
        }
        catch( Exception ex){
            Logger.log(ex.getMessage());
        }

        return new ArrayList<>();
    }

    private List<Node> evalVariableDeclration(Node node, ActivationFrame frame){
        return new ArrayList<>();
    }

    private FinalNode getFinalNodeFromAnyNode(Node node){
        if ( node instanceof FinalNode){
            return (FinalNode)node;
        }

        if (node.getInstructions().size() == 1){
            return getFinalNodeFromAnyNode( node.getInstructions().get(0));
        }

        throw new RuntimeException( "not able to find a final node");
    }

    private boolean isEqual(Node left, Node right){
        return left.equals(right);
    }

    private boolean isLessThan(Node left, Node right){
        return false; //left < right;
    }

    private boolean isGreaterThan(Node left, Node right){
        return false;
    }

    private List<Node> evalBooleanOperator(Node node, ActivationFrame frame){
        return new ArrayList<>();
    }

    private List<Node> evalUserDefinedFunctionCall (Node n){
        UserDefinedTypeFunctionReferenceNode userDefinedTypeFunctionReferenceNode = (UserDefinedTypeFunctionReferenceNode)n;
        return evalFunctionCall( userDefinedTypeFunctionReferenceNode.getFuncCallNode() );
    }

    private List<Node> evalFunctionCall(Node node) {
        FunctionCallNode functionCallNode = (FunctionCallNode)node;
        String functionToCall = functionCallNode.functionName();

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
                    frame.variableSet.put(variableNode.variableName, activationFrameStack.peek().variableSet.get(sourceVariables.get(i).variableName));
                }
                else {
                    throw new RuntimeException( "data types are not the same");
                }
            }



            activationFrameStack.push(frame);
            execute(functionDeclNode.getInstructions());
            activationFrameStack.pop();
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

            return EvaluatePrimitives.evalPrimitives(primitiveNode, activationFrameStack.peek());
        }

        return new ArrayList<>();
    }


    private List<Node> AggregateNode(Node node){
        List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)node).data();
        int addCount = integralTypeNodes.size() - 1;
        //TODO Different Primitive Types //add
        for(IntegralTypeNode integralTypeNode : integralTypeNodes) {
            integralTypeNode( integralTypeNode);
        }
        for(int i =0;i<addCount;i++){
            binaryOperation( (a,b) -> a+b); //check
        }
        return new ArrayList<>();
    }

    private List<Node> binaryNode( String variableName, Node node){
        evalBinaryNode( node );
        ActivationFrame frame = activationFrameStack.peek();
        VariableNode v = (VariableNode) frame.variableSet.get( variableName );

        v.setIntegralTypeNode( (IntegralTypeNode)frame.operandStack.pop() );
        return new ArrayList<>();
    }

    private List<Node> evaluateAggregate(Node node, ActivationFrame frame) {
        SummationType summationType = (SummationType) node.getInstructions().get(0);
        List<Node> list = node.getInstructions();

        int size = list.size();
        int sum = 0;

        List<VariableNode> listOfVariableNodes = new ArrayList<>();

        for (int i = 1; i < size; i++) {
            if (node.getInstructions().get(i) instanceof VariableNode) {
                listOfVariableNodes.add((VariableNode) node.getInstructions().get(i));
            }
            else {
                String value = ((FinalNode) list.get(i).getInstructions().get(0)).dataString();
                sum += Integer.parseInt(value);
            }
        }

        if (!listOfVariableNodes.isEmpty()) {
            sum += aggregateVariable( listOfVariableNodes , frame);
        }

        FinalNode returnNode = new FinalNode();
        returnNode.setDataString(sum);
        frame.returnNode = returnNode;

        return new ArrayList<>();
    }

    private int aggregateVariable(List<VariableNode> variableNodeList, ActivationFrame frame){
        int sum = 0;
        for (int i = 0; i<variableNodeList.size(); i++){

            Node v = frame.variableSet.get( variableNodeList.get(i).variableName);
            FinalNode finalNode = null;

            if (v instanceof FinalNode && v.getInstructions().isEmpty()){
                finalNode = (FinalNode)v;
            }

            if (v instanceof PrimitiveNode) {
                PrimitiveNode primitiveNode = (PrimitiveNode) v;
                finalNode = (FinalNode)primitiveNode.getInstructions().get(0);
            }

            if (finalNode != null) {
                sum += Integer.parseInt(finalNode.dataString());
            }
        }

        return sum;
    }


    private List<Node> evalBinaryNode(Node node) {
        BinaryNode bn = (BinaryNode) node;
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
                break;
        }
        return new ArrayList<>();
    }

    private List<Node> binaryOperation( IntegerMath integerMath) {
        //ActivationFrame frame = activationFrameStack.peek();
     //   String data1 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
      //  int v1 = Integer.decode(data1).intValue();


     //   String data2 = ((IntegralTypeNode) frame.operandStack.pop()).getIntegralValue();
     //   int v2 = Integer.decode(data2).intValue();

     //   String sum = new Integer(integerMath.operation(v2, v1)).toString();

        //TODO - NEED to FIX THIS.
        //frame.operandStack.push(new IntegralTypeNode(sum, IntegralType.jinteger));
        return new ArrayList<>();
    }

    private void integralTypeNode(IntegralTypeNode itn) {
        ActivationFrame frame = activationFrameStack.peek();
        frame.operandStack.push(itn);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }

    interface Evaluate {
        List<Node> evaluate(Node node, ActivationFrame frame);
    }
}
