package com.juliar.nodes;
import java.util.List;

/**
 * Created by Don on 1/12/2017.
 */
public class FunctionCallNode extends NodeImpl {
    public String functionName(){
        List<Node> nodes = getInstructions();
        if (!nodes.isEmpty())
        {
            FinalNode functionName = (FinalNode)nodes.get(0);
            return functionName.dataString();

        }
        assert true;
        return null;
    }

    @Override
    public NodeType getType() {
        return NodeType.FunctionaCallType;
    }

}
