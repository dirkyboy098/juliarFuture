package com.juliar.nodes;

/**
 * Created by donreamey on 1/7/17.
 */
public class AssignmentNode implements Node {
    public String type;
    public String variableName;
    public Node command;

    public AssignmentNode(String t, String v, Node c){
        type = t;
        variableName = v;
        command = c;
    }

}
