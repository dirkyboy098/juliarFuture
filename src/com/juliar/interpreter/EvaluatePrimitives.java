package com.juliar.interpreter;

import com.juliar.nodes.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluatePrimitives {
    static public List<Node> evalPrimitives(Node n, ActivationFrame activationFrame) {
        String functionName = ((FinalNode) n.getInstructions().get(0)).dataString();
        FinalNode finalNode = new FinalNode();

        switch (functionName) {
            case "print":
                printLine(activationFrame, functionName, n.getInstructions().get(2));
                break;
            case "__getByteFromString":
                getByteFromString(activationFrame, n.getInstructions().get(1));
                break;
            case "printLine":
                printLine(activationFrame, functionName, n.getInstructions().get(2));
                break;
            case "fileOpen":
                String data = fileOpen(n.getInstructions().get(2));
                finalNode.setDataString(data);
                finalNode.setVariableTypeByIntegralType(IntegralType.jstring);
                activationFrame.returnNode = finalNode;
                break;
            case "availableMemory":
                long value = availableMemory();
                finalNode.setDataString(value);
                finalNode.setVariableTypeByIntegralType(IntegralType.jlong);
                activationFrame.returnNode = finalNode;
                break;
            default:
                throw new RuntimeException( "function "+functionName+" does not exist");
        }

        return new ArrayList<>();
    }

    private static String fileOpen(Node argumentNode) {
        if (argumentNode instanceof FinalNode) {
            FinalNode finalNode = (FinalNode) argumentNode;
            return com.juliar.pal.Primitives.sys_file_open(finalNode.dataString());
        }

        return "";
    }

    private static long availableMemory() {
        return com.juliar.pal.Primitives.sys_available_memory();
    }

    private static void getByteFromString(ActivationFrame activationFrame, Node argumentNode){
        Object variable = activationFrame.variableSet.get( ((VariableNode)argumentNode).variableName);

        if (variable instanceof FinalNode){
            char[] array = com.juliar.pal.Primitives.sys_get_byte_from_string( ((FinalNode)variable).dataString() );

            FinalNode finalNode = new FinalNode();
            finalNode.setDataString( array[0] );
            activationFrame.returnNode = finalNode;
        }
    }

    private static void printLine(ActivationFrame activationFrame, String functionName, Node argumentNode) {
        FinalNode finalNode = null;

        if (argumentNode instanceof VariableNode) {
            VariableNode variableName = (VariableNode) argumentNode;
            Object variable = activationFrame.variableSet.get(variableName.variableName);

            if (variable != null && variable instanceof PrimitiveNode) {
                PrimitiveNode primitiveNode = (PrimitiveNode) variable;
                finalNode = (FinalNode) primitiveNode.getInstructions().get(0);
            }

            if (variable instanceof IntegralTypeNode) {
                finalNode = (FinalNode) ((IntegralTypeNode) variable).getInstructions().get(0);
            }

            if (variable instanceof BooleanNode) {
                finalNode = (FinalNode) ((BooleanNode) variable).getInstructions().get(0);
            }

            if (variable instanceof FinalNode) {
                finalNode = (FinalNode) variable;
            }
        }

        if (argumentNode instanceof IntegralTypeNode) {
            finalNode = (FinalNode) argumentNode.getInstructions().get(0);
        }

        assert finalNode != null : "EvaluatePrimitives.printLine - finalNode == null";

        if (finalNode.dataString() != null) {
            if (functionName.equals("printLine")) {
                com.juliar.pal.Primitives.sys_print_line(finalNode.dataString());
            } else if (functionName.equals("print")) {
                com.juliar.pal.Primitives.sys_print(finalNode.dataString());
            }
        }
    }
}


