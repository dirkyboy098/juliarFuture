package com.juliar.interpreter;

import com.juliar.errors.Logger;
import com.juliar.nodes.*;
import com.sun.istack.internal.FinalArrayList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.juliar.pal.Primitives.*;

/**
 * Created by donreamey on 3/28/17.
 */
class EvaluatePrimitives {
    private static List<String> primitiveFunctions = new ArrayList<String>(Arrays.asList("print" , "__getByteFromString" , "printLine", "availableMemory","sysExec", "fileOpen"));
    private EvaluatePrimitives(){

    }

    public static boolean evalIfPrimitive( Node n , ActivationFrame activationFrame){
        String functionName = ((FinalNode) n.getInstructions().get(0)).dataString();
        if ( primitiveFunctions.contains( functionName )){
            evalPrimitives(n, activationFrame);
            return true;
        }

        return false;
    }

    public static List<Node> evalPrimitives(Node n, ActivationFrame activationFrame) {
        String functionName = ((FinalNode) n.getInstructions().get(0)).dataString();
        FinalNode finalNode = new FinalNode();

        switch (functionName) {
            case "print":
                printLine(activationFrame, functionName, n.getInstructions().get(2));
                break;
            case "__getByteFromString":
                getByteFromString(activationFrame, n.getInstructions().get(1) , n.getInstructions().get(2) );
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
            case "sysExec":
                String ex = sysExec(n.getInstructions().get(2));
                finalNode.setDataString(ex);
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
                Logger.log( "function "+functionName+" does not exist");
                break;
        }

        return new ArrayList<>();
    }

    private static String fileOpen(Node argumentNode) {
        if (argumentNode instanceof FinalNode) {
            FinalNode finalNode = (FinalNode) argumentNode;
            return sysFileOpen(finalNode.dataString());
        }

        return "";
    }

    public static String sysExec(Node argumentNode) {
        if (argumentNode instanceof FinalNode) {
            FinalNode finalNode = (FinalNode) argumentNode;
            return com.juliar.pal.Primitives.sysExec(finalNode.dataString());
        }
        return "";
    }

    private static long availableMemory() {
        return sysAvailableMemory();
    }

    private static void getByteFromString(ActivationFrame activationFrame, Node argumentNode, Node index) {
        String variableName = ((VariableNode) argumentNode).variableName;
        Object variable = activationFrame.variableSet.get( variableName );

        if (variable instanceof FinalNode) {
            char[] array = sysGetByteFromString(((FinalNode) variable).dataString());

            FinalNode finalNode = new FinalNode();

            String argTwoVariableName = ((VariableNode)index).variableName;
            Object argTwo = activationFrame.variableSet.get( argTwoVariableName );

            FinalNode argumentTwo = null;

            if (argTwo instanceof PrimitiveNode) {
                argumentTwo = (FinalNode) activationFrame.variableSet.get( argTwoVariableName ).getInstructions().get(0);
            } else if (argTwo instanceof FinalNode) {
                argumentTwo = (FinalNode) activationFrame.variableSet.get( argTwoVariableName );
            }

            assert (argumentTwo != null ? argumentTwo.dataString() : null) != null;
            int parsedIndex = Integer.parseInt(argumentTwo.dataString());

            if (parsedIndex > array.length) {
                throw new RuntimeException("\r\nJuliar runtime exception - Index out of bounds accessing variable - '"+ variableName +"'");
            }
            if (parsedIndex < array.length) {
                finalNode.setDataString(array[parsedIndex]);
                activationFrame.returnNode = finalNode;
            }
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

            if (variable instanceof IntegralTypeNode) finalNode = (FinalNode) ((IntegralTypeNode) variable).getInstructions().get(0);
            if (variable instanceof BooleanNode) finalNode = (FinalNode) ((BooleanNode) variable).getInstructions().get(0);
            if (variable instanceof FinalNode) finalNode = (FinalNode) variable;
        }

        if (argumentNode instanceof IntegralTypeNode) {
            finalNode = (FinalNode) argumentNode.getInstructions().get(0);
        }

        if ( argumentNode instanceof FinalNode ){
            finalNode = (FinalNode)argumentNode;
            if (finalNode.dataString() != null) {
                if ("printLine".equals(functionName)) {
                    sysPrintLine(finalNode.dataString());
                } else if ("print".equals(functionName)) {
                    sysPrint(finalNode.dataString());
                }
            }
        }
    }
}


