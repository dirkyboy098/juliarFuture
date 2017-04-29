package com.juliar.nodes;

import com.juliar.symbolTable.SymbolTypeEnum;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Stack;

/**
 * Created by donreamey on 2/10/17.
 */
public class ReturnValueNode extends NodeImpl {
    private String typeName;
    private SymbolTypeEnum symbolTypeEnum;

    public ReturnValueNode(SymbolTypeEnum typeEnum, String name){
        symbolTypeEnum = typeEnum;
        typeName = name;
    }

    public ReturnValueNode(){

    }

    public String typeName(){
        return typeName;
    }

    @Override
    public void AddInst(Node parent, Node instruction) {
        super.AddInst(parent, instruction);
    }

    @Override
    public void AddInst(Node instruction) {
        super.AddInst(instruction);
    }

    @Override
    public void AddInst(Stack<Node> contextStack, Node instruction) {
        super.AddInst(contextStack, instruction);
    }

    @Override
    public List<Node> getInstructions() {
        return super.getInstructions();
    }

    @Override
    public NodeType getType() {
        return NodeType.ReturnValueType;
    }

    public void writeNode( ObjectOutputStream stream){
        try {
            int ordrinal = getType().ordinal();
            stream.writeInt( ordrinal );
            stream.writeChars( typeName );
            //stream.writeObject( this );

            for (Node n : instructions) {
                n.writeNode( stream );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
