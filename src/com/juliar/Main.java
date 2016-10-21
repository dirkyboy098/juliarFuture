package com.juliar;


import java.io.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import com.juliar.vistor.JuliarVisitor;
import com.juliar.nodes.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            ANTLRInputStream s = new ANTLRInputStream(fileInputStream);


            juliargrammarLexer lexer = new juliargrammarLexer(s);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            juliargrammarParser parser = new juliargrammarParser(tokenStream);

            juliargrammarParser.CompileUnitContext context = parser.compileUnit();
            out.println(context.toStringTree(parser));

            JuliarVisitor visitor = new JuliarVisitor();
            Node node = visitor.visit(context);

            ParseTreeWalker treeWalker = new ParseTreeWalker();


        }
        catch(Exception ex)
        {
            out.println(ex.getMessage());
        }
    }
}

