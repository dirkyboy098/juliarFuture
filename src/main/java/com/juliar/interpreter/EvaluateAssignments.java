package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static com.juliar.nodes.IntegralType.*;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluateAssignments<T> {
    private EvaluateAssignments() {}

    private static Interpreter interpreterCallback = null;

    public static void create(Interpreter interpreter){
        if (interpreterCallback == null) {
            interpreterCallback = interpreter;
        }
    }

    public static List<Node> evalReassignment( Node n, ActivationFrame activationFrame, Interpreter calback) {
        if ( n != null){
            VariableReassignmentNode node = (VariableReassignmentNode)n;

            VariableNode lValueVariableNode = (VariableNode)node.getInstructions().get(0);
            String variableName = lValueVariableNode.variableName;

            Node rvalueVariableNode = node.getInstructions().get(2);

            NodeType nodeType = rvalueVariableNode.getType();

            activationFrame.variableSet.remove( variableName );
            switch ( nodeType){
                case LiteralType:
                    LiteralNode literalNode = (LiteralNode)rvalueVariableNode;
                    activationFrame.variableSet.put ( variableName, literalNode);
                    break;
                case VariableType:
                    VariableNode variableNode = (VariableNode) rvalueVariableNode;
                    activationFrame.variableSet.put ( variableName, variableNode );
                    break;
            }
        }

        return new ArrayList<>();
    }


    public static void functionCallNode(FunctionCallNode functionCallNode, ActivationFrame activationFrame,VariableDeclarationNode variableToAssignTo){
        List<Node> functionList = new ArrayList<>();
        functionList.add(functionCallNode);
        interpreterCallback.execute(functionList);
        assignReturnValueToVariable(activationFrame, variableToAssignTo);
    }

    public static void primitiveInstance(PrimitiveNode primitiveNode, ActivationFrame activationFrame,VariableDeclarationNode variableToAssignTo){
        if (canPrimitiveValueBeAssignedToVar(variableToAssignTo, primitiveNode)) {
            String variableName;

            if (variableToAssignTo.getIntegralType() == juserDefined) {

                variableName = variableToAssignTo.getUserDefinedNode().getFullyQualifiedVariableName();
            } else {
                FinalNode variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);
                variableName = variableNameTerminalNode.dataString();
            }

            if (activationFrame.variableSet.containsKey(variableName)) {
                activationFrame.variableSet.remove(variableName);
            }

            activationFrame.variableSet.put(variableName, primitiveNode);
        }
    }

    public static void booleanInstance(BooleanNode booleanNode, ActivationFrame activationFrame,VariableDeclarationNode variableToAssignTo){
        List<Node> slotList = new ArrayList<>();
        slotList.add( booleanNode );
        interpreterCallback.execute( slotList );
        assignReturnValueToVariable(activationFrame, variableToAssignTo);
    }

    public static void commandInstance(CommandNode commandNode, ActivationFrame activationFrame,VariableDeclarationNode variableToAssignTo){
        List<Node> slotList = new ArrayList<>();
        slotList.add( commandNode );
        interpreterCallback.execute( slotList );

        FinalNode variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);

        String variableName = variableNameTerminalNode.dataString();

        if (activationFrame.variableSet.containsKey( variableName )) {
            activationFrame.variableSet.remove(variableName);
        }

        activationFrame.variableSet.put( variableName, activationFrame.peekReturnNode());
        //activationFrame.returnNode = null;
    }

    public static List<Node> evalVariableDeclWithAssignment(Node n, ActivationFrameStack activationFrameStack, String mainName, Map<String, Node> functionNodeMap){
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode)n;
        List<Node> instructionsToReturnAndExecute = new ArrayList<>();
        List<Node> instructions = variableDeclarationNode.getInstructions();
        KeywordNode keywordNode = variableDeclarationNode.getKeyWordNode();
        Node rightHandSide = null;
        if ( variableDeclarationNode.isDeclarationWithAssignment() ) {
            if ( !variableDeclarationNode.isOperatorEqualSign() ) {
                throw new RuntimeException( "Invalid operator for expression" );
            }

            rightHandSide = variableDeclarationNode.getRightValue();

            switch ( rightHandSide.getType() ) {
                case LiteralType:
                    if (rightHandSide instanceof LiteralNode) {
                        LiteralNode literalNode = (LiteralNode) rightHandSide;
                        EvaluateAssignments<LiteralNode> literalNodeEvaluateAssignments = new EvaluateAssignments<>();
                        if (literalNodeEvaluateAssignments.canLiteralBeAssigned(keywordNode, literalNode)) {
                            if (instructions.get(1) instanceof VariableNode) {
                                VariableNode variableNode = (VariableNode) instructions.get(1);
                                if (activationFrameStack.peek().variableSet.containsKey(variableNode.variableName)) {
                                    throw new RuntimeException("Variable already declared");
                                } else {
                                    activationFrameStack.peek().variableSet.put(variableNode.variableName, rightHandSide);
                                }
                            }
                        }

                    }
                    break;
                case FunctionaCallType:
                    instructionsToReturnAndExecute = EvaluateFunctionsCalls.evalFunctionCall( rightHandSide, activationFrameStack, mainName, functionNodeMap, interpreterCallback);
                    if ( activationFrameStack.peek().parameterStack.size() > 0 ){
                        VariableNode variableNode = (VariableNode) instructions.get(1);
                        if (activationFrameStack.peek().variableSet.containsKey(variableNode.variableName)) {
                            throw new RuntimeException("Variable already declared");
                        } else {
                            activationFrameStack.peek().variableSet.put(variableNode.variableName, activationFrameStack.peek().parameterStack.pop());
                        }
                    }

            }
        }

        return instructionsToReturnAndExecute;

    }

    public static List<Node> evalAssignment(Node n, ActivationFrame activationFrame, Interpreter calback) {
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

            if (rvalue instanceof FunctionCallNode){
                functionCallNode((FunctionCallNode) rvalue, activationFrame, variableToAssignTo);
            }
            if (rvalue instanceof PrimitiveNode){
                primitiveInstance((PrimitiveNode) rvalue, activationFrame, variableToAssignTo);
            }
            if (rvalue instanceof  BooleanNode){
                booleanInstance((BooleanNode) rvalue, activationFrame, variableToAssignTo);
            }
            if (rvalue instanceof CommandNode)
            {
                commandInstance((CommandNode) rvalue, activationFrame, variableToAssignTo);
            }
        }
        return new ArrayList<>();
    }

    private static void assignReturnValueToVariable(ActivationFrame activationFrame, VariableDeclarationNode variableToAssignTo) {
        if (activationFrame.peekReturnNode() != null){
            VariableNode variableNode = (VariableNode)variableToAssignTo.getInstructions().get(1);
            if (activationFrame.variableSet.containsKey( variableNode.variableName )){
                activationFrame.variableSet.remove( variableNode.variableName);
            }

            activationFrame.variableSet.put( variableNode.variableName, activationFrame.popNode());
        }
    }

    public <T extends NodeImpl> boolean canLiteralBeAssigned(KeywordNode keyword, T t){
        if ( keyword.getInstructions().get (0) instanceof FinalNode){
            FinalNode finalNode = (FinalNode)keyword.getInstructions().get (0);
            String dataType = finalNode.dataString();

            String rvalueDataString = (( FinalNode )t.getInstructions().get ( 0 )).dataString();

            switch( finalNode.getIntegralType() ){
                case jinteger: {
                    try {
                        Integer.parseInt(rvalueDataString);
                    }
                    catch( NumberFormatException nfe){
                        throw new RuntimeException( "invalid r-Value" );
                    }

                    return true;
                }
            }
        }

        return false;
    }


    public static boolean canPrimitiveValueBeAssignedToVar(VariableDeclarationNode lvalue, PrimitiveNode rvalue) {
        FinalNode rvalueTerminal = (FinalNode) rvalue.getInstructions().get(0);

        VariableNode variableNode;

        if (juserDefined == lvalue.getIntegralType()){
            variableNode = lvalue.getUserDefinedNode().getVariableNode();
        }
        else {
            variableNode = (VariableNode) lvalue.getInstructions().get(1);
        }
        String data = rvalueTerminal.dataString();

        try {
            switch (variableNode.getIntegralType()) {
                case jinteger:
                    return true;
                case jdouble:
                    return true;
                case jfloat:
                    return true;
                case jlong:
                    return true;
                case jstring:
                    return true;
                case jobject:
                    return false;
                case jboolean:
                    return Boolean.parseBoolean(data);
                case juserDefined:
                    return true;
                default:
                    return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
