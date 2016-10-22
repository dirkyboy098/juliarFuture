package com.juliar.vistor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.*;

import static java.lang.System.out;
import com.juliar.nodes.*;
import com.juliar.parser.*;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliarBaseVisitor<Node>
{

    @Override
    public Node visitCompileUnit(juliarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();

        for(ParseTree t : ctx.children){
            node.statementNodes.add(t.accept(this));
        }

        return node;
    }

    @Override
    public Node visitStatement(juliarParser.StatementContext ctx) {
        StatementNode node = new StatementNode();

        for (ParseTree t : ctx.children){
            if (t instanceof juliarParser.StartLineContext || t instanceof juliarParser.EndLineContext){
                continue;
            }

            Node n = t.accept(this);
            node.statements.add(n);
        }

        return node;
    }
    @Override
    public Node visitStartLine(juliarParser.StartLineContext ctx) {
        for(ParseTree t : ctx.children){
            Object n = t.accept(this);
            out.println(n);
        }
        return super.visitStartLine(ctx);
    }

    @Override
    public Node visitEndLine(juliarParser.EndLineContext ctx) {
        for(ParseTree t : ctx.children){
            Object n = t.accept(this);
            out.println(n);
        }
        return super.visitEndLine(ctx);
    }
/*
    @Override
    public Node visitAsterisk(juliargrammarParser.AsteriskContext ctx) {
        return super.visitAsterisk(ctx);
    }

    @Override
    public Node visitCommand(juliargrammarParser.CommandContext ctx) {
        return super.visitCommand(ctx);
    }

    @Override
    public Node visitAbsolute(juliargrammarParser.AbsoluteContext ctx) {
        List<ParseTree> trees = ctx.children;


        for(ParseTree tree : trees){
            tree.accept(this);
        }

        return super.visitAbsolute(ctx);
    }
*/
    @Override
    public Node visitAdd(juliarParser.AddContext ctx) {
        String text = ctx.ID().getText();
        if (text.equals("add") && ctx.getChildCount() == 3){
            BinaryNode node = new BinaryNode();

            return node.MakeNode(
                    BinaryOperation.add,
                    (BinaryNode) ctx.INT(0).accept(this),
                    (BinaryNode) ctx.INT(1).accept(this));
        }

        return super.visitAdd(ctx);
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        return new BinaryNode(BinaryOperation.data , node.getText());
    }

}
