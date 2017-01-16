package com.juliar.nodes;

/**
 * Created by Don on 1/15/2017.
 */
public class VariableNode extends NodeImpl {
    public String type;
    public String variableName;


    public VariableNode(String t, String v){
        type = t;
        variableName = v;
    }
}
