package com.juliar.LoaderLinker;

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
            count++;
        }

        return link( instructionInvocations ) ;
    }


    private static InstructionInvocation link( InstructionInvocation[] instructionInvocations ){
        InstructionInvocation firstInvocation = instructionInvocations[0];

        CompliationUnitNode compliationUnitNode = (CompliationUnitNode) firstInvocation.getInstructionList().get( 0 );

        HashMap<String , Node> functionNodeMap = new HashMap<>();
        functionNodeMap.putAll( firstInvocation.getFunctionNodeMap() );

        if (instructionInvocations.length > 0 ){
            for (int i = 1; i < instructionInvocations.length; i++){
                compliationUnitNode.getInstructions().addAll( instructionInvocations[i].getInstructionList() );
                functionNodeMap.putAll( instructionInvocations[i].getFunctionNodeMap() );
            }
        }

        List<Node> inst = new ArrayList<Node>();
        inst.add(  compliationUnitNode );
        return new InstructionInvocation( inst, functionNodeMap );
    }
}
