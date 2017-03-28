package com.juliar.interpreter;

import com.juliar.nodes.FinalNode;
import com.juliar.nodes.IntegralTypeNode;
import com.juliar.nodes.Node;

/**
 * Created by donreamey on 3/28/17.
 */
public class EvaluatePrimitives {
    static public void evalPrimitives(Node n, ActivationFrame activationFrame) {
        String functionName = ((FinalNode)n.getInstructions().get(0)).dataString();
        IntegralTypeNode integralTypeNode = (IntegralTypeNode)n.getInstructions().get(2);
        FinalNode argument = (FinalNode)integralTypeNode.getInstructions().get(0);

        if (functionName.equals("printLine")) {
            com.juliar.pal.Primitives.sys_print_line( argument.dataString() );
        }
    }

}
