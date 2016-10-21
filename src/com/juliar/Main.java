package com.juliar;

import java.io.Console;
import com.juliar.parser.*;
import java.io.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        int i = 3;
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
    public String visitAsterisk(juliargrammarParser.AsteriskContext ctx) {
        out.println(ctx.children.toArray()[0]);
        return super.visitAsterisk(ctx);
    }

    @Override
    public String visitCommand(juliargrammarParser.CommandContext ctx) {
        return super.visitCommand(ctx);
    }

    @Override
    public String visitAbsolute(juliargrammarParser.AbsoluteContext ctx) {
        out.println(ctx.children.toArray()[0]);
        return super.visitAbsolute(ctx);
    }
}
