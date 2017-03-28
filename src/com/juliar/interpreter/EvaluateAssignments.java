package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.List;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluateAssignments {

    static public void evalReassignment( Node n, ActivationFrame activationFrame){
        if ( n != null){
            VariableReassignmentNode node = (VariableReassignmentNode)n;

            VariableNode variableNode = (VariableNode)node.getInstructions().get(0);
            Node rValue = node.getInstructions().get(2);

            String variableName = variableNode.variableName;

            ActivationFrame frame = activationFrame;
            if (frame.variableSet.containsKey( variableName )) {
                frame.variableSet.remove( variableName );
            }

            FinalNode variableNameTerminalNode = (FinalNode) node.getInstructions().get(2).getInstructions().get(0);
            frame.variableSet.put( variableName, variableNameTerminalNode );
        }
    }

    static public void evalAssignment(Node n, ActivationFrame activationFrame) {
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
                    ActivationFrame frame = activationFrame;
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



    static private boolean canPrimitiveValueBeAssignedToVar(VariableDeclarationNode lvalue, PrimitiveNode rvalue){
        FinalNode lvalueTerminal =  (FinalNode)lvalue.getInstructions().get(0).getInstructions().get(0);
        FinalNode rvalueTerminal =  (FinalNode)rvalue.getInstructions().get(0);

        if (lvalueTerminal.dataString().equals( "int" )){
            int integerValue = Integer.parseInt(rvalueTerminal.dataString());
            return true;
        }

        return false;
    }
}
