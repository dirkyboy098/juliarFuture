package com.juliar.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by don on 5/18/17.
 */
@SuppressWarnings("serial")
public class UserDefinedTypeNode extends NodeImpl {
    private String typeName;
    private String keyWordName;

    public List<String> variableList = new ArrayList<>();
    public List<String> functionList = new ArrayList<>();

    public UserDefinedTypeNode(){
    }

    public UserDefinedTypeNode(String typeName, String keyWordName){
        this.typeName = typeName;
        this.keyWordName = keyWordName;
    }

    public String getTypeName(){
        return ((FinalNode)instructions.get( 1 ).getInstructions().get( 0 )).dataString();
    }

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

    public String getFullyQualifiedVariableName(){
        FinalNode object = getObjectIdentifier();
        FinalNode variableName = getVariableIdentifer();

        return object.dataString() + "::" + variableName.dataString();
    }

    public List<String> getAllVariableNames(){
        StatementNode statementNode = (StatementNode)instructions.get ( 4 );
        return statementNode.findAllVariablesInStatement();
    }

}
