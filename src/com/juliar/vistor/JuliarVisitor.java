package com.juliar.vistor;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_EXCLUSIONPeer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import com.juliar.nodes.*;
import com.juliar.parser.*;
import com.juliar.errors.PrintError;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliarBaseVisitor<Node>
{
    private List<Node> instructionList = new ArrayList<>();

    public List<Node> instructions(){
        return instructionList;
    }


    @Override
    public Node visitCompileUnit(juliarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();
        instructionList.add(node);

        for(ParseTree t : ctx.children){
            t.accept(this);
            //node.statementNodes.add(t.accept(this));
        }

        //return node;
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
            //Node n = t.accept(this);
            //node.statements.add(n);
        }

        return null;
    }

/*
    @Override
    public Node visitStartLine(juliarParser.StartLineContext ctx) {
        for(ParseTree t : ctx.children){
            t.accept(this);
            //Object n = t.accept(this);
            //out.println(n);
        }
        //return super.visitStartLine(ctx);
        return null;
    }
*/
    @Override
    public Node visitEndLine(juliarParser.EndLineContext ctx) {
        for(ParseTree t : ctx.children){
            t.accept(this);
            //Object n = t.accept(this);
            //out.println(n);
        }
        //return super.visitEndLine(ctx);
        return null;
    }

    @Override
    public Node visitBooleanExpression(juliarParser.BooleanExpressionContext ctx) {
        return super.visitBooleanExpression(ctx);
    }
/*
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
    //TODO need to refactor and combine vistAdd and visitSubtract
    @Override
    public Node visitAdd(juliarParser.AddContext ctx) {

        String text = ctx.summation().getText();
        if (text.equals("add") || text.equals("+")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.MakeNode(
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

                instructionList.add( aggregateNode );
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
                    instructionList.add(node.MakeNode(
                            Operation.sub,
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
                AggregateNode aggregateNode = new AggregateNode(Operation.sub, data);

                instructionList.add( aggregateNode );
            }
        }
        return null;
    }

    @Override
    public Node visitDivide(juliarParser.DivideContext ctx) {

        String text = ctx.division().getText();
        if (text.equals("divide") || text.equals("/")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.MakeNode(
                            Operation.divide,
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
                AggregateNode aggregateNode = new AggregateNode(Operation.divide, data);

                instructionList.add( aggregateNode );
            }
        }

        //return super.visitAdd(ctx);
        return null;
    }

    @Override
    public Node visitMultiply(juliarParser.MultiplyContext ctx) {

        String text = ctx.multiplication().getText();
        if (text.equals("multiply") || text.equals("x")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.MakeNode(
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

                instructionList.add( aggregateNode );
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
                instructionList.add(
                        new PrimitiveNode( "printInt" , null));
            }else {
                instructionList.add(
                        new PrimitiveNode(
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
}
