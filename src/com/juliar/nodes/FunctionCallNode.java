package com.juliar.nodes;
import java.util.List;

/**
 * Created by Don on 1/12/2017.
 */
public class FunctionCallNode extends NodeImpl {
    private String functionNameString;

    public String functionName(){
        List<Node> nodes = getInstructions();
        if (nodes.size() >= 1)
        {
            FinalNode functionName = (FinalNode)nodes.get(0);
            return functionName.dataString();

        }

        assert true;
        return null;
        //TODO handle exception
        //throw new Exception();
    }

    public FunctionCallNode(String funcName){
        this();
        functionNameString = funcName;
    }

    public FunctionCallNode(){
    }

    @Override
    public NodeType getType() {
        return NodeType.FunctionaCallType;
    }
}
