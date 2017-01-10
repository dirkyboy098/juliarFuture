package com.juliar.interpreter;

import com.juliar.nodes.*;

import java.util.List;
import java.util.Stack;

/**
 * Created by donreamey on 1/8/17.
 */
public class interpreter {
    private Stack<Node> parameterStack = new Stack<Node>();
    private Stack<Node> operatorStack = new Stack<Node>();
    private Stack<Node> operandStack = new Stack<Node>();
    private List<Node> inst;

    public interpreter(List<Node> instructions){
        inst = instructions;
    }

    public void execute() {
        for (Node n : inst) {
            if (n instanceof PrimitiveNode) {
                primitives((PrimitiveNode) n);
            }

            if ( n instanceof AssignmentNode){
                assignment((AssignmentNode) n);
            }

            if (n instanceof BinaryNode){

            }
        }
    }

    private void primitives(PrimitiveNode n) {
        String functionName = n.getPrimitiveName();
        String argument = n.getGetPrimitiveArgument();

        if (functionName.equals("printLine")){
            com.juliar.pal.Primitives.sys_print_line(argument);
        }
        if (functionName.equals("printInt")){
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            int intValue = Integer.decode( argument ).intValue();
            com.juliar.pal.Primitives.sys_print_int( intValue );
        }
        if (functionName.equals("printFloat")){
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            float floatValue = Integer.decode( argument ).floatValue();
            com.juliar.pal.Primitives.sys_print_float( floatValue );
        }
        if (functionName.equals("printDouble")){
            argument = ((IntegralTypeNode) operandStack.pop()).data();
            double doubleValue = Integer.decode( argument ).doubleValue();
            com.juliar.pal.Primitives.sys_print_double( doubleValue );
        }
    }

    private void assignment(AssignmentNode n) {
        String variableName = n.variableName;
        Node command = n.command;
        if ( command instanceof BinaryNode){
            binaryNode( command );
        }
        String type = n.type;
    }

    private void binaryNode( Node n){
        BinaryNode bn = (BinaryNode)n;
        String operation = bn.operation().name();

        Object ol = bn.left();
        Object or = bn.right();

        if (ol instanceof IntegralTypeNode){
            integralTypeNode( (IntegralTypeNode)ol);
        }

        if (or instanceof IntegralTypeNode){
            integralTypeNode( (IntegralTypeNode)or);
        }

        switch ( operation.toLowerCase() )  {
            case "+":
            case "add":
                add();
                break;
            case "-":
            case "subtract":
                subtract();
            default:
                assert false;
        }
    }

    private void subtract(){
        String data1 = ((IntegralTypeNode) operandStack.pop()).data();
        int v1 = Integer.decode ( data1 ).intValue();

        String data2 = ((IntegralTypeNode) operandStack.pop()).data();
        int v2 = Integer.decode ( data2 ).intValue();

        String sum = new Integer(v1 - v2).toString();

        operandStack.push (new IntegralTypeNode(sum, IntegralType.jinteger));
    }


    private void add(){
        String data1 = ((IntegralTypeNode) operandStack.pop()).data();
        int v1 = Integer.decode ( data1 ).intValue();

        String data2 = ((IntegralTypeNode) operandStack.pop()).data();
        int v2 = Integer.decode ( data2 ).intValue();

        String sum = new Integer(v1 + v2).toString();

        operandStack.push (new IntegralTypeNode(sum, IntegralType.jinteger));
    }


    private void integralTypeNode(IntegralTypeNode itn){
        operandStack.push( itn );
    }
}
