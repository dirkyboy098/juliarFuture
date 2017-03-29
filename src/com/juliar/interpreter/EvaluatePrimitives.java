package com.juliar.interpreter;

import com.juliar.nodes.*;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluatePrimitives {
    static public void evalPrimitives(Node n, ActivationFrame activationFrame) {
        String functionName = ((FinalNode)n.getInstructions().get(0)).dataString();
        Node argumentNode = n.getInstructions().get(2);

        if (functionName.equals( "printLine")) {
            if (argumentNode instanceof VariableNode) {
                VariableNode variableName = (VariableNode) argumentNode;
                Object variable = activationFrame.variableSet.get(variableName.variableName);

                if (variable != null && variable instanceof PrimitiveNode) {
                    PrimitiveNode primitiveNode = (PrimitiveNode) variable;
                    FinalNode finalNode = (FinalNode) primitiveNode.getInstructions().get(0);
                    com.juliar.pal.Primitives.sys_print_line(finalNode.dataString());
                    return;
                }
            }

            if (argumentNode instanceof IntegralTypeNode) {
                FinalNode finalNode = (FinalNode) argumentNode.getInstructions().get(0);
                com.juliar.pal.Primitives.sys_print_line(finalNode.dataString());
                return;
            }
        }

        if (functionName.equals( "fileOpen")){
            if (argumentNode instanceof FinalNode) {
                FinalNode finalNode = (FinalNode) argumentNode;
                com.juliar.pal.Primitives.sys_file_open(finalNode.dataString());
                return;
            }
        }
    }

}
