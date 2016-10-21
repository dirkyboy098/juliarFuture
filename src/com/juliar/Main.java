package com.juliar;

import java.io.Console;
import com.juliar.parser.*;
import java.io.*;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("d:\\test.jr");
            ANTLRInputStream s = new ANTLRInputStream(fileInputStream);


            juliargrammarLexer lexer = new juliargrammarLexer(s);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            juliargrammarParser parser = new juliargrammarParser(tokenStream);

            juliargrammarParser.CompileUnitContext context = parser.compileUnit();
            out.println(context.toStringTree(parser));

            JuliarVisitor visitor = new JuliarVisitor();
            visitor.visit(context);

            ParseTreeWalker treeWalker = new ParseTreeWalker();


        }
        catch(Exception ex)
        {

        }
    }
}


class JuliarVisitor extends juliargrammarBaseVisitor<String>
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
    public String visitTerminal(TerminalNode node) {
        out.print(node.getText());
        out.print(" ");
        return super.visitTerminal(node);
    }
}
