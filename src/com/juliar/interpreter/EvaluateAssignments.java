package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Node> evalReassignment( Node n, ActivationFrame activationFrame) {
        if ( n != null){
            VariableReassignmentNode node = (VariableReassignmentNode)n;

            VariableNode variableNode = (VariableNode)node.getInstructions().get(0);
            Node rValue = node.getInstructions().get(2);

            String variableName = variableNode.variableName;
            Node rValueType = node.getInstructions().get(2).getInstructions().get(0);

            if (activationFrame.variableSet.containsKey( variableName ) && rValueType instanceof  FinalNode) {
                Node variableFromFrame = activationFrame.variableSet.get( variableName );
                IntegralType integralType = variableFromFrame.getIntegralType();

                if (integralType != variableNode.getIntegralType()){
                    throw new IllegalArgumentException("Cannot assign "+ variableNode.getIntegralType().toString() +" to "+integralType.toString());
                }

                activationFrame.variableSet.remove( variableName );
                FinalNode variableNameTerminalNode = (FinalNode) node.getInstructions().get(2).getInstructions().get(0);
                variableNameTerminalNode.setVariableTypeByIntegralType( integralType );
                activationFrame.variableSet.put(variableName, variableNameTerminalNode );
            }
            else if (rValue instanceof CommandNode){
                List<Node> instructions = new ArrayList<>();
                instructions.add( rValueType );
                interpreterCallback.execute( instructions );
                activationFrame.variableSet.put (variableName, activationFrame.returnNode);
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

        activationFrame.variableSet.put( variableName, activationFrame.returnNode );
        activationFrame.returnNode = null;
    }

    public static List<Node> evalVariableDeclWithAssignment( Node n, ActivationFrame activationFrame){
        VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode)n;
        List<Node> instructions = variableDeclarationNode.getInstructions();
        KeywordNode keywordNode = variableDeclarationNode.getKeyWordNode();
        Node rightHandSide = null;
        if ( variableDeclarationNode.isDeclarationWithAssignment() ) {
            if ( !variableDeclarationNode.isOperatorEqualSign() ) {
                throw new RuntimeException( "Invalid operator for expression" );
            }

            rightHandSide = variableDeclarationNode.getRightValue();

            if ( rightHandSide instanceof LiteralNode) {
                LiteralNode literalNode = (LiteralNode)rightHandSide;
                EvaluateAssignments<LiteralNode> literalNodeEvaluateAssignments = new EvaluateAssignments<>();
                if (literalNodeEvaluateAssignments.canLiteralBeAssigned( keywordNode, literalNode)){
                    if ( instructions.get( 1 ) instanceof VariableNode ) {
                        VariableNode variableNode = (VariableNode)instructions.get( 1 );
                        if (activationFrame.variableSet.containsKey( variableNode.variableName)) {
                            throw new RuntimeException( "Variable already declared" );
                        } else {
                            activationFrame.variableSet.put ( variableNode.variableName, rightHandSide );
                        }
                    }
                }

            }

        }


        return new ArrayList<>();

    }

    public static List<Node> evalAssignment(Node n, ActivationFrame activationFrame) {
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
        if (activationFrame.returnNode != null){
            VariableNode variableNode = (VariableNode)variableToAssignTo.getInstructions().get(1);
            if (activationFrame.variableSet.containsKey( variableNode.variableName )){
                activationFrame.variableSet.remove( variableNode.variableName);
            }

            activationFrame.variableSet.put( variableNode.variableName, activationFrame.returnNode);
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
