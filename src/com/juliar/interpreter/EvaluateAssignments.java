package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.ArrayList;
import java.util.List;

import static com.juliar.nodes.IntegralType.*;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluateAssignments {
    private static Interpreter interpreterCallback = null;

    static public void Create(Interpreter interpreter){
        if (interpreterCallback == null) {
            interpreterCallback = interpreter;
        }
    }

    static public List<Node> evalReassignment( Node n, ActivationFrame activationFrame){
        if ( n != null){
            VariableReassignmentNode node = (VariableReassignmentNode)n;

            VariableNode variableNode = (VariableNode)node.getInstructions().get(0);
            Node rValue = node.getInstructions().get(2);

            String variableName = variableNode.variableName;
            Node rValueType = node.getInstructions().get(2).getInstructions().get(0);

            ActivationFrame frame = activationFrame;
            if (frame.variableSet.containsKey( variableName ) && rValueType instanceof  FinalNode) {
                Node variableFromFrame = frame.variableSet.get( variableName );
                IntegralType integralType = variableFromFrame.getIntegralType();

                if (integralType != variableNode.getIntegralType()){
                    throw new RuntimeException("Cannot assign "+ variableNode.getIntegralType().toString() +" to "+integralType.toString());
                }

                frame.variableSet.remove( variableName );
                FinalNode variableNameTerminalNode = (FinalNode) node.getInstructions().get(2).getInstructions().get(0);
                variableNameTerminalNode.setVariableTypeByIntegralType( integralType );
                frame.variableSet.put(variableName, variableNameTerminalNode );
            }
            else if (rValue instanceof CommandNode){
                List<Node> instructions = new ArrayList<>();
                instructions.add( rValueType );
                interpreterCallback.execute( instructions );
                frame.variableSet.put (variableName, frame.returnNode);
            }
        }

        return new ArrayList<>();
    }

    static public List<Node> evalAssignment(Node n, ActivationFrame activationFrame) {
        AssignmentNode assignmentNode = (AssignmentNode)n;
        List<Node> instructions = assignmentNode.getInstructions();

        final int varDeclIndex = 0;
        final int equalSignIndex = 1;
        final int primtiveIndex = 2;
        VariableDeclarationNode variableToAssignTo =  (VariableDeclarationNode)instructions.get(  varDeclIndex );

        FinalNode variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);

        // | zero             | one       | two
        // | variableDecl     | EqualSign | Primitive
        // | int variableName | =         | 3

        if (instructions.get(equalSignIndex ) instanceof EqualSignNode ){
            Object rvalue = instructions.get( primtiveIndex );

            if (rvalue instanceof FunctionCallNode){
                List<Node> functionList = new ArrayList<Node>();
                functionList.add( (FunctionCallNode)rvalue );

                interpreterCallback.execute(functionList);

                assignReturnValueToVariable(activationFrame, variableToAssignTo);
            }

            if (rvalue instanceof PrimitiveNode){
                PrimitiveNode primitiveNode = (PrimitiveNode)rvalue;
                if (primitiveNode != null && canPrimitiveValueBeAssignedToVar(variableToAssignTo, primitiveNode)){
                    ActivationFrame frame = activationFrame;
                    variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);
                    String variableName = variableNameTerminalNode.dataString();

                    if (frame.variableSet.containsKey( variableName )) {
                        frame.variableSet.remove(variableName);
                    }

                    frame.variableSet.put( variableName, primitiveNode );
                }
            }
            if (rvalue instanceof  BooleanNode){
                BooleanNode booleanNode = (BooleanNode)rvalue;
                List<Node> slotList = new ArrayList<>();
                slotList.add( booleanNode );

                interpreterCallback.execute( slotList );

                assignReturnValueToVariable(activationFrame, variableToAssignTo);
            }

            if (rvalue instanceof CommandNode)
            {
                List<Node> slotList = new ArrayList<>();
                slotList.add( (CommandNode)rvalue );
                interpreterCallback.execute( slotList );

                ActivationFrame frame = activationFrame;
                variableNameTerminalNode = (FinalNode) variableToAssignTo.getInstructions().get(1).getInstructions().get(0);

                String variableName = variableNameTerminalNode.dataString();

                if (frame.variableSet.containsKey( variableName )) {
                    frame.variableSet.remove(variableName);
                }

                frame.variableSet.put( variableName, frame.returnNode );
                frame.returnNode = null;
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


    static private boolean canPrimitiveValueBeAssignedToVar(VariableDeclarationNode lvalue, PrimitiveNode rvalue) {
        FinalNode rvalueTerminal = (FinalNode) rvalue.getInstructions().get(0);
        VariableNode variableNode = (VariableNode) lvalue.getInstructions().get(1);
        String data = rvalueTerminal.dataString();

        try {
            switch (variableNode.getIntegralType()) {
                case jinteger:
                    Integer.parseInt(data);
                    return true;
                case jdouble:
                    Double.parseDouble(data);
                    return true;
                case jfloat:
                    Float.parseFloat(data);
                    return true;
                case jlong:
                    Long.parseLong(data);
                    return true;
                case jstring:
                    return true;
                case jobject:
                    return false;
                case jboolean:
                    Boolean.parseBoolean(data);
                    return true;
                default:
                    return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
