package com.juliar.codegenerator;

import com.juliar.nodes.Node;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Don on 1/12/2017.
 */
public class InstructionInvocation implements Serializable {
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<String, Node>();

    public InstructionInvocation(List<Node> inst, HashMap<String, Node> functionMap){
        instructionList = inst;
        functionNodeMap = functionMap;
    }

    public List<Node> getInstructionList(){
        return instructionList;
    }

    public HashMap<String, Node> getFunctionNodeMap() {
        return functionNodeMap;
    }
}
