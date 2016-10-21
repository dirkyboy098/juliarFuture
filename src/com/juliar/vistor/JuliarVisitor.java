package com.juliar.vistor;

import com.juliar.juliargrammarBaseVisitor;
import com.juliar.juliargrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.lang.*;

import static java.lang.System.out;

/**
 * Created by donreamey on 10/21/16.
 */
public class JuliarVisitor extends juliargrammarBaseVisitor<String>
{

    @Override
    public String visitStartLine(juliargrammarParser.StartLineContext ctx) {
        out.println();
        return super.visitStartLine(ctx);
    }

    @Override
    public String visitEndLine(juliargrammarParser.EndLineContext ctx) {
        return super.visitEndLine(ctx);
    }

    @Override
    public String visitAsterisk(juliargrammarParser.AsteriskContext ctx) {
        return super.visitAsterisk(ctx);
    }

    @Override
    public String visitCommand(juliargrammarParser.CommandContext ctx) {
        return super.visitCommand(ctx);
    }

    @Override
    public String visitAbsolute(juliargrammarParser.AbsoluteContext ctx) {
        List<ParseTree> trees = ctx.children;

        /*
        for(ParseTree tree : trees){
            tree.accept(this);
        }
        */

        return super.visitAbsolute(ctx);
    }

    @Override
    public String visitAdd(juliargrammarParser.AddContext ctx) {
        String text = ctx.ID().getText();
        if (text.equals("add") && ctx.getChildCount() == 3){
            String id1 = ctx.INT(0).accept(this);
            String id2 = ctx.INT(1).accept(this);
        }
        return super.visitAdd(ctx);
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        out.print(node.getText());
        out.print(" ");
        return super.visitTerminal(node);
    }
}
