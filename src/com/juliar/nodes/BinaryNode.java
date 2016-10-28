package com.juliar.nodes;

import com.juliar.parser.juliarParser;


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

        /*
        if (value.FLOAT() != null) {
            binaryNode.integralTypeNode = new IntegralTypeNode(value.FLOAT().getText(), IntegralType.jfloat);
        }else if (value.INT() != null) {
            binaryNode.integralTypeNode = new IntegralTypeNode(value.FLOAT().getText(), IntegralType.jinteger);
        }else if (value.DOUBLE() != null) {
            binaryNode.integralTypeNode = new IntegralTypeNode(value.FLOAT().getText(), IntegralType.jdouble);
        }else if (value.LONG() != null) {
            binaryNode.integralTypeNode = new IntegralTypeNode(value.FLOAT().getText(), IntegralType.jlong);
        } else {
            throw new Exception("invalid types");
        }
*/

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

