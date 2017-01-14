package com.juliar.nodes;

import java.util.ArrayList;

/**
 * Created by donreamey on 1/7/17.
 */
public class AssignmentNode extends NodeImpl  {
    public String type;
    public String variableName;
    public Node command;

    public AssignmentNode(String t, String v, Node c){
        type = t;
        variableName = v;
        command = c;
    }

    @Override
    public void AddInst(Node instruction) {
        super.AddInst( instruction );
    }
}
