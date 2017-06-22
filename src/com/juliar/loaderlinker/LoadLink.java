package com.juliar.loaderlinker;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.interpreter.ReadWriteBinaryFile;
import com.juliar.nodes.CompliationUnitNode;
import com.juliar.nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dreamey on 5/12/17.
 */
public class LoadLink {
    public static InstructionInvocation loadAndLink( String[] filesToLoad ){
        int fileCount = filesToLoad.length;

        ReadWriteBinaryFile read = new ReadWriteBinaryFile();
        InstructionInvocation[] instructionInvocations = new InstructionInvocation[ fileCount ];
        int count = 0;

        for (String file : filesToLoad ) {
            instructionInvocations[ count] = read.read( file );
            if (instructionInvocations[ count ].getInstructionList().size() == 0){
                throw new RuntimeException( "Invalid library. Make sure there were no compilation errors");
            }
            count++;
        }

        InstructionInvocation instructionInvocation = link( instructionInvocations ) ;
        //read.write( "a.out",  );
        return instructionInvocation;
    }


    /*
    Finds all function maps and combines into one function map. Looks for multiple main methods.

     */
    private static InstructionInvocation link( InstructionInvocation[] instructionInvocations ) {
        InstructionInvocation firstInvocation = instructionInvocations[0];

        CompliationUnitNode compliationUnitNode = (CompliationUnitNode) firstInvocation.getInstructionList().get(0);

        HashMap<String, Node> functionNodeMap = new HashMap<>();

        functionNodeMap.putAll(firstInvocation.getFunctionNodeMap());
        long oneMainFunction = functionNodeMap.keySet().stream().filter(f -> "main".equals(f)).count();

        if (instructionInvocations.length > 0) {
            for (int i = 1; i < instructionInvocations.length; i++) {
                compliationUnitNode.getInstructions().addAll(instructionInvocations[i].getInstructionList());

                oneMainFunction += instructionInvocations[i].getFunctionNodeMap().keySet().stream().filter(f -> "main".equals(f)).count();

                functionNodeMap.putAll(instructionInvocations[i].getFunctionNodeMap());
            }
        }

        if (oneMainFunction == 1) {
            List<Node> inst = new ArrayList<>();
            inst.add(compliationUnitNode);
            return new InstructionInvocation(inst, functionNodeMap);
        }

        if (oneMainFunction > 1) {
            throw new RuntimeException("Multiple main methods were found during linking");
        }


        throw new RuntimeException("No main functions were found during linking");
    }
}
