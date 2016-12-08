package com.juliar.nodes;

/**
 * Created by donreamey on 10/21/16.
 */
public class BinaryNode implements Node {
    private Operation op;
    private Node lv;
    private Node rv;
    private IntegralTypeNode integralTypeNode;


    public BinaryNode(Operation operation){
        op = operation;
    }

    public BinaryNode(){
    }


    public BinaryNode MakeNode(Operation operation, Node lvalue, Node rvalue){
        BinaryNode binaryNode = new BinaryNode(operation);
        binaryNode.lv = lvalue;
        binaryNode.rv = rvalue;

        return binaryNode;
    }


    private BinaryNode getBinaryNodeWithType(Node value)  throws Exception{
        BinaryNode binaryNode = new BinaryNode(Operation.data);
        return binaryNode;
    }



    public Operation operation(){
        return op;
    }

    public Node left(){ return lv;}

    public Node right(){
        return rv;
    }

    public IntegralTypeNode data(){return integralTypeNode;}


}

