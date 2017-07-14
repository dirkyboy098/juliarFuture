package com.juliar.codegenerator;

import com.juliar.nodes.Node;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Don on 1/12/2017.
 */
public class InstructionInvocation implements Serializable {
    private static final long serialVersionUID = 321323213;
    private List<Node> instructionList = new ArrayList<>();
    private Map<String, Node> functionNodeMap = new HashMap<>();

    public InstructionInvocation(List<Node> inst, Map<String, Node> functionMap){
        instructionList = inst;
        functionNodeMap = functionMap;
    }

    public List<Node> getInstructionList(){
        return instructionList;
    }

    public Map<String, Node> getFunctionNodeMap() {
        return functionNodeMap;
    }
}
