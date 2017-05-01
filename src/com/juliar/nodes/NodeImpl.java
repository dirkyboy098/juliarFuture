package com.juliar.nodes;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.io.*;

import static com.juliar.nodes.IntegralType.*;
import static com.juliar.nodes.NodeType.*;
/**
 * Created by Don on 1/13/2017.
 */
public abstract class NodeImpl implements Node , Serializable{
    protected List<Node> instructions = new ArrayList<>();
    protected String nodeName;
    private IntegralType integralType;

    public NodeImpl(){
        setNodeName();
    }

    @Override
    public void AddInst(Node parent, Node instruction) {
    /*add instruction given parent*/
    }

    @Override
    public void AddInst(Node instruction) {
        instructions.add( instruction );
    }

    @Override
    public void AddInst(Stack<Node> contextStack, Node instruction) {
        Node n = contextStack.peek();
        n.AddInst(instruction);
    }

    @Override
    public List<Node> getInstructions(){
        return instructions;
    }

    @Override
    public void setNodeName(){
        nodeName = this.toString();
    }

    @Override
    public String getNodeName(){
        return nodeName;
    }

    @Override
    public IntegralType getIntegralType(){
        return integralType;
    }

    @Override
    public void setVariableTypeByIntegralType( IntegralType type){
        integralType = type;
    }

    @Override
    public void setVariableType(String variableType){
        switch (variableType) {
            case "int":
                integralType = jinteger;
                break;
            case "double":
                integralType = jdouble;
                break;
            case "float":
                integralType = jfloat;
                break;
            case "long":
                integralType = jlong;
                break;
            case "string":
                integralType = jstring;
                break;
            case "object":
                integralType = jobject;
                break;
            case "boolean":
                integralType = jboolean;
                break;
        }
    }

    public void writeNode( ObjectOutputStream stream){
        try {
            int ordrinal = getType().ordinal();
            stream.writeInt( ordrinal );
            //stream.writeObject( this );

            for (Node n : instructions) {
                n.writeNode( stream );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Node readObject (ObjectInputStream stream){
        try {
            int type = stream.readInt();
            NodeType t[] = NodeType.values();
            Object loadedType = stream.readObject();

            for ( NodeType nodeType : t) {
                if ( nodeType.ordinal() == type){
                    break;
                }
            }

            /*
            switch (type){
                case AddType:
                    return (AddNode)loadedType;
                case AggregateType:
                    return (AggregateNode)loadedType;
                case AssignmentType:
                    return (AssignmentNode)loadedType;
                case BinaryType:
                    return (BinaryNode)loadedType;
                case BooleanType:
                    return (BooleanNode)loadedType;
                case BooleanOperatorType:
                    return (BooleanOperatorNode)loadedType;
                case BreakType:
                    return (BreakExprNode)loadedType;
                case CompliationUnitType:
                    return (CompliationUnitNode)loadedType;
                case CommandType:
                    return (CommandNode)loadedType;
                case EqualEqualType:
                    return (EqualEqualSignNode)loadedType;
                case EqualSignType:
                    return (EqualSignNode)loadedType;
                case ExpressionType:
                    return (ExpressionNode)loadedType;
                case FinalType:
                    return (FinalNode)loadedType;
                case FunctionaCallType:
                    return (FunctionCallNode)loadedType;
                case FunctionDeclType:
                    return (FunctionDeclNode)loadedType;
                case IfExprType:
                    return (IfExprNode)loadedType;
                case IntegralTypeType:
                    return (IntegralTypeNode)loadedType;
                case KeywordType:
                    return (KeywordNode)loadedType;
                case LineNodeType:
                    return (LineNode)loadedType;
                case OperationType:
                    //return (Operation)loadedType;
                case PrimitiveType:
                    return (PrimitiveNode)loadedType;
                case ReturnValueType:
                    return (ReturnValueNode)loadedType;
                case RvalueType:
                    return (RValueNode)loadedType;
                case StatementType:
                    return (StatementNode)loadedType;
                case SummationType:
                    return (SummationType)loadedType;
                case VariableDeclarationType:
                    return (VariableDeclarationNode)loadedType;
                case VariableType:
                    return (VariableNode)loadedType;
                case VariableReassignmentType:
                    return (VariableReassignmentNode)loadedType;
                case WhileExpressionType:
                    return (WhileExprNode)loadedType;
            }
            */


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public NodeType readType ( ObjectInputStream stream) {
        int b = 0;
        try {
            b = stream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (b == NodeType.AddType.ordinal()) {
            return NodeType.AddType;
        }
        if (b == AggregateType.ordinal()) {
            return AggregateType;
        }
        if (b == AssignmentType.ordinal()) {
            return AssignmentType;
        }
        if (b == BinaryType.ordinal()) {
            return BinaryType;
        }
        if (b == NodeType.BooleanOperatorType.ordinal()) {
            return NodeType.BooleanOperatorType;
        }

        if (b == BreakType.ordinal() ){
            return BreakType;
        }
        if (b == CompliationUnitType.ordinal()){
            return CompliationUnitType;
        }
        if (b == CommandType.ordinal() ){
            return CommandType;
        }
        if (b == EqualEqualType.ordinal() ){
            return EqualEqualType;
        }
        if (b == EqualSignType.ordinal() ){
            return EqualSignType;
        }
        if (b == ExpressionType.ordinal() ){
            return ExpressionType;
        }
        if (b == FinalType.ordinal() ){
            return FinalType;
        }
        if (b == FunctionaCallType.ordinal() ){
            return FunctionaCallType;
        }
        if (b == FunctionDeclType.ordinal() ){
            return FunctionDeclType;
        }
        if (b == IfExprType.ordinal() ){
            return IfExprType;
        }
        if (b == IntegralTypeType.ordinal() ){
            return IntegralTypeType;
        }
        if (b == KeywordType.ordinal() ){
            return KeywordType;
        }
        if (b == LineNodeType.ordinal() ){
            return LineNodeType;
        }
        if (b == OperationType.ordinal() ){
            return OperationType;
        }
        if (b == PrimitiveType.ordinal() ){
            return PrimitiveType;
        }
        if (b == ReturnValueType.ordinal() ){
            return ReturnValueType;
        }
        if (b == RvalueType.ordinal() ){
            return RvalueType;
        }
        if (b == StatementType.ordinal() ){
            return StatementType;
        }
        if (b == SummationType.ordinal() ){
            return SummationType;
        }
        if (b == VariableDeclarationType.ordinal() ){
            return VariableDeclarationType;
        }
        if (b == VariableType.ordinal() ){
            return VariableType;
        }
        if (b == VariableReassignmentType.ordinal() ){
            return VariableReassignmentType;
        }
        if (b == WhileExpressionType.ordinal() ){
            return WhileExpressionType;
        }

        return null;
    }

}
