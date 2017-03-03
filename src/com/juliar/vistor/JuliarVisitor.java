package com.juliar.vistor;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.controlflow.ControlFlowAdjacencyList;
import com.juliar.errors.LogMessage;
import com.juliar.symbolTable.SymbolTable;
import com.juliar.symbolTable.SymbolTypeEnum;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.lang.*;
import java.util.*;
import com.juliar.nodes.*;
import com.juliar.parser.*;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliarBaseVisitor<Node>
{
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<String, Node>();
    private Stack<Node> funcContextStack = new Stack<Node>();
    private Queue<String> callStack = new ArrayDeque<>();
    private SymbolTable symbolTable = SymbolTable.CreateSymbolTable();
    private ControlFlowAdjacencyList cfa = new ControlFlowAdjacencyList();

    public InstructionInvocation instructions(){
        return new InstructionInvocation(instructionList, functionNodeMap);
    }


    @Override
    public Node visitCompileUnit(juliarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();
        instructionList.add(node);

        for(ParseTree t : ctx.children){
            t.accept(this);
        }

        cfa.walkGraph();
        //symbolTable.dumpSymbolTable();

        return null;
    }

    @Override
    public Node visitStatement(juliarParser.StatementContext ctx) {
        StatementNode node = new StatementNode();

        for (ParseTree t : ctx.children){
            if (t instanceof juliarParser.EndLineContext){
                continue;
            }

            t.accept(this);
        }

        return null;
    }

    @Override
    public Node visitEndLine(juliarParser.EndLineContext ctx) {
        for(ParseTree t : ctx.children){
            t.accept(this);
        }
        return null;
    }


    //TODO need to refactor and combine vistAdd and visitSubtract
    @Override
    public Node visitAdd(juliarParser.AddContext ctx) {

        String text = ctx.summation().getText();
        if (text.equals("add") || text.equals("+")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.add,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.add, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }
        return null;
    }

    @Override
    public Node visitSubtract(juliarParser.SubtractContext ctx) {
        String text = ctx.subtraction().getText();
        if (text.equals("subtract") || text.equals("-")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {

                    Node n = node.MakeNode(
                                Operation.subtract,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this));
                    n.AddInst( funcContextStack, n);
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.subtract, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }
        return null;
    }

    @Override
    public Node visitFunctionDeclaration(juliarParser.FunctionDeclarationContext ctx) {
        String funcName = ctx.funcName().getText();
        FunctionDeclNode functionDeclNode = new FunctionDeclNode(funcName, new ArrayList<Node>());
        funcContextStack.push( functionDeclNode );

        callStack.add( funcName );
        symbolTable.AddLevel( callStack.peek(), funcName, SymbolTypeEnum.functionDecl);

        List<juliarParser.StatementContext> statementContexts = ctx.statement();
        for(juliarParser.StatementContext context : statementContexts){
            context.accept(this);
        }

        funcContextStack.pop();
        callStack.remove();

        instructionList.add( functionDeclNode );
        functionNodeMap.put(funcName, functionDeclNode);

        return null;
    }

    @Override
    public Node visitFunctionCall(juliarParser.FunctionCallContext ctx) {
        Node parent = funcContextStack.peek();
        String caller = null;

        if (parent instanceof  FunctionDeclNode) {
            caller = ((FunctionDeclNode) parent).getFunctionName();
        }

        if (parent instanceof  AssignmentNode){
            caller = "assignment";//((AssignmentNode) parent).getVariableNode().variableName;
        }

        String callee = ctx.funcName().ID().getText();
        cfa.addNode( caller, callee);

        FunctionCallNode node = new FunctionCallNode( callee );
        node.AddInst(funcContextStack , node);

        return null;
    }

    @Override
    public Node visitEqualequal(juliarParser.EqualequalContext ctx){
        //ifeq or if_acmpeq
        /*String text = ctx.().getText();
        if (text.equals("add") || text.equals("+")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.add,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.add, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }
        return null;*/
        return null;

    }

    @Override
    public Node visitLessthan(juliarParser.LessthanContext ctx){
        //if_icmplt
        return null;
    }
    @Override
    public Node visitGreaterthan(juliarParser.GreaterthanContext ctx){
        //if_icmpgt
        return null;
    }
    @Override
    public Node visitLessthanorequalto(juliarParser.LessthanorequaltoContext ctx){

        //if_icmple
        return null;
    }
    @Override
    public Node visitGreaterthanorequalto(juliarParser.GreaterthanorequaltoContext ctx){
        //if_icmpge
        return null;
    }
    @Override
    public Node visitThreeway(juliarParser.ThreewayContext ctx){
        return null;
    }

    public Node visitModulo(juliarParser.ModuloContext ctx) {

        String text = ctx.moduli().getText();
        if (text.equals("modulo") || text.equals("%")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.MakeNode(
                            Operation.modulo,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.modulo, data);

                instructionList.add( aggregateNode );
            }
        }

        //return super.visitAdd(ctx);
        return null;
    }
    @Override
    public Node visitDivide(juliarParser.DivideContext ctx) {

        String text = ctx.division().getText();
        if (text.equals("divide") || text.equals("/")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    if (!funcContextStack.empty()) {
                        FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                        functionDeclNode.AddInst(node.MakeNode(
                                Operation.divide,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this)));
                    }
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.divide, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }

        //return super.visitAdd(ctx);
        return null;
    }


    @Override
    public Node visitMultiply(juliarParser.MultiplyContext ctx) {

        String text = ctx.multiplication().getText();
        if (text.equals("multiply") || text.equals("*")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.multiply,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.multiply, data);
                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }

        //return super.visitAdd(ctx);
        return null;
    }


    @Override
    public Node visitTypes(juliarParser.TypesContext ctx) {
        if (ctx.children.size() > 1) {
            //throw new Exception("invalid number of types");
        }
        ParseTree tn = ctx.children.get(0);

        JTerminalNode terminal = (JTerminalNode) tn.accept(this);
        IntegralTypeNode itn = new IntegralTypeNode(ctx, terminal);

        return itn;
    }



    @Override
    public Node visitPrimitives(juliarParser.PrimitivesContext ctx) {
        if (ctx != null){
            List<ParseTree> parseTreeList = ctx.children;
            if (parseTreeList.toArray()[0].toString().equals( "printInt") ){
                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst(new PrimitiveNode( "printInt" , ctx.variable().getText()));
            }else {
                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst(new PrimitiveNode(
                                parseTreeList.toArray()[0].toString(),
                                parseTreeList.toArray()[2].toString()));
            }
        }

        return null;
    }


    @Override
    public Node visitTerminal(TerminalNode node) {
        return new JTerminalNode(node);
    }

    @Override
    public Node visitAssignmentExpression(juliarParser.AssignmentExpressionContext ctx) {
        if (funcContextStack.empty()) {
            assert true;
        }

        String operator = ctx.equalsign().getText();
        AssignmentNode node = new AssignmentNode(null);

        funcContextStack.push(node);
        for ( ParseTree p : ctx.children ) {
            p.accept( this );
        }

        funcContextStack.pop();
        node.AddInst(funcContextStack, node);

        return null;
    }

    @Override
    public Node visitNumericTypes(juliarParser.NumericTypesContext ctx) {
        return super.visitNumericTypes(ctx);
    }

    @Override
    public Node visitPrimitiveTypes(juliarParser.PrimitiveTypesContext ctx) {
        for (ParseTree p : ctx.children){
            p.accept( this );
        }

        return null;
    }

    @Override
    public Node visitEqualsign(juliarParser.EqualsignContext ctx) {
        return super.visitEqualsign(ctx);
    }

    @Override
    public Node visitExpression(juliarParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Node visitVariable(juliarParser.VariableContext ctx) {
        String variableName = ctx.ID().getText();
        VariableNode variableNode = new VariableNode( variableName , null);
        variableNode.AddInst(funcContextStack, variableNode );

        symbolTable.AddLevel( callStack.peek(), variableName, SymbolTypeEnum.variableDecl);

        return null;
    }

    @Override
    public Node visitReturnValue(juliarParser.ReturnValueContext ctx) {
        ReturnValueNode valueNode = null;

        if (ctx.variable() != null) {
            valueNode = new ReturnValueNode( SymbolTypeEnum.variableRef, ctx.variable().getText());
        }
        else if(ctx.functionCall() != null) {
            valueNode = new ReturnValueNode(SymbolTypeEnum.functionCall, ctx.functionCall().getText());
        }

        funcContextStack.peek().AddInst( valueNode );

        return null;
    }

}
