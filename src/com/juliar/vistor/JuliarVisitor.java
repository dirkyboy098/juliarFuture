package com.juliar.vistor;

import com.juliar.juliargrammarBaseVisitor;
import com.juliar.juliargrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.lang.*;

import static java.lang.System.out;
import com.juliar.nodes.*;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliargrammarBaseVisitor<Node>
{

    @Override
    public Node visitCompileUnit(juliargrammarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();

        for(ParseTree t : ctx.children){
            node.statementNodes.add(t.accept(this));
        }

        return node;
    }

    @Override
    public Node visitStatement(juliargrammarParser.StatementContext ctx) {
        StatementNode node = new StatementNode();

        for (ParseTree t : ctx.children){
            if (t instanceof juliargrammarParser.StartLineContext || t instanceof juliargrammarParser.EndLineContext){
                continue;
            }

            Node n = t.accept(this);
            node.statements.add(n);
        }

        return node;
    }
    @Override
    public Node visitStartLine(juliargrammarParser.StartLineContext ctx) {
        for(ParseTree t : ctx.children){
            Object n = t.accept(this);
            out.println(n);
        }
        return super.visitStartLine(ctx);
    }

    @Override
    public Node visitEndLine(juliargrammarParser.EndLineContext ctx) {
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
    public Node visitAdd(juliargrammarParser.AddContext ctx) {
        String text = ctx.ID().getText();
        if (text.equals("add") && ctx.getChildCount() == 3){
            BinaryNode node = new BinaryNode();


            Object id1 = ctx.INT(0).accept(this);
            Object id2 = ctx.INT(1).accept(this);

            BinaryNode binaryNodeLvalue = new BinaryNode(BinaryOperation.data , id1);
            BinaryNode binaryNodeRvalue = new BinaryNode(BinaryOperation.data , id2);

            return node.MakeNode(BinaryOperation.add, binaryNodeLvalue, binaryNodeRvalue);
        }

        return super.visitAdd(ctx);
    }
/*
    @Override
    public Node visitTerminal(TerminalNode node) {
        out.print(node.getText());
        out.print(" ");
        return super.visitTerminal(node);
    }
*/
}
