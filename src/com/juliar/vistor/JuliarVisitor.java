package com.juliar.vistor;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.ErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.lang.*;
import java.util.*;
import com.juliar.nodes.*;
import com.juliar.parser.*;
import com.juliar.errors.PrintError;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliarBaseVisitor<Node>
{
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<String, Node>();
    private Stack<Node> funcContextStack = new Stack<Node>();

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
                    new PrintError(ex.getMessage(),ex);
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
                    new PrintError(ex.getMessage(),ex);
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

        List<juliarParser.StatementContext> statementContexts = ctx.statement();
        for(juliarParser.StatementContext context : statementContexts){
            context.accept(this);
        }

        funcContextStack.pop();

        instructionList.add( functionDeclNode );
        functionNodeMap.put(funcName, functionDeclNode);

        return null;
    }

    @Override
    public Node visitFunctionCallKeyword(juliarParser.FunctionCallKeywordContext ctx) {
        return super.visitFunctionCallKeyword(ctx);
    }

    @Override
    public Node visitFunctionCall(juliarParser.FunctionCallContext ctx) {
        FunctionCallNode node = new FunctionCallNode(ctx.funcName().ID().getText());
        node.AddInst(funcContextStack , node);

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
                    new PrintError(ex.getMessage(),ex);
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
                    new PrintError(ex.getMessage(),ex);
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
                    new PrintError(ex.getMessage(),ex);
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
    public Node visitEqualequal(juliarParser.EqualequalContext ctx) {
        return super.visitEqualequal(ctx);
    }


    @Override
    public Node visitPrimitives(juliarParser.PrimitivesContext ctx) {
        if (ctx != null){
            List<ParseTree> parseTreeList = ctx.children;
            if (parseTreeList.toArray()[0].toString().equals( "printInt") ){
                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst(new PrimitiveNode( "printInt" , null));
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
        if (funcContextStack.empty()){
            assert true;
        }

        if (ctx.variable().size() == 1){

            String type = ctx.keywords().getText();
            // The type will dictate the valid values used in the command.
            String variableName = ctx.variable( 0 ).getText();

            VariableNode variableNode = new VariableNode( variableName, type );

            String operator = ctx.equalsign().getText();

            AssignmentNode node = new AssignmentNode( variableNode);

            funcContextStack.push( node );
            ctx.command().accept( this );
            funcContextStack.pop();
            node.AddInst(funcContextStack, node);
        }

        return null;
    }

    @Override
    public Node visitExpression(juliarParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }



        /*
    @Override
    public Node visitBooleanExpression(juliarParser.BooleanExpressionContext ctx) {
        return super.visitBooleanExpression(ctx);
    }

    @Override
    public Node visitIfExpr(juliarParser.IfExprContext ctx) {
        Object booleanExpression = ctx.booleanExpression().accept(this);

        for(juliarParser.StatementContext statementContext : ctx.statement()){
            statementContext.accept(this);
        }

        return super.visitIfExpr(ctx);
    }
    */

    /*
    @Override
    public Node visitAbsolute(juliarParser.AbsoluteContext ctx){

        return super.visitAbsolute(ctx);
    }

    @Override
    public Node visitAcos(juliarParser.AcosContext ctx){

        return super.visitAcos(ctx);
    }

    @Override
    public Node visitAcosh(juliarParser.AcoshContext ctx){

        return super.visitAcosh(ctx);
    }
*/

}
