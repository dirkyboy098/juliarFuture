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
            if (t instanceof juliarParser.StartLineContext || t instanceof juliarParser.EndLineContext){
                continue;
            }

            t.accept(this);
            //Node n = t.accept(this);
            //node.statements.add(n);
        }

        return null;
    }


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

    @Override
    public Node visitIfExpr(juliarParser.IfExprContext ctx) {
        Object booleanExpression = ctx.booleanExpression();
        Object commandExpression = ctx.command();
        return super.visitIfExpr(ctx);
    }

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
                    out.println(ex.getMessage());
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
    public Node visitTerminal(TerminalNode node) {
        return new JTerminalNode(node);
    }
}
