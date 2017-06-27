package com.juliar.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donreamey on 10/21/16.
 */
public class StatementNode extends NodeImpl {
    @Override
    public NodeType getType() {
        return NodeType.StatementType;
    }


    public List<String> findAllVariablesInStatement(){
        int size = instructions.size();
        List<String> variables = new ArrayList<>( size );

        for (int i = 0; i < size; i ++){
            if (instructions.get(i) instanceof ExpressionNode){
                ExpressionNode expressionNode = (ExpressionNode)instructions.get( i );

                variables.add( expressionNode.getVariableName() );
            }
        }

        return variables;
    }

}
