package com.juliar.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by don on 5/18/17.
 */
public class UserDefinedTypeNode extends NodeImpl {

    public List< String > variableList = new ArrayList<String>();

    public List<String> functionList = new ArrayList<String>();

    @Override
    public NodeType getType() {
        return null;
    }

    public VariableNode getVariableNode(){
        return (VariableNode)this.getInstructions().get(2);
    }

    public FinalNode getObjectIdentifier(){
        return (FinalNode)this.getInstructions().get(0);
    }

    public FinalNode getVariableIdentifer(){
        VariableNode variableNode = (VariableNode)this.getInstructions().get(2);
        return variableNode.getFinalNode();
    }
}
