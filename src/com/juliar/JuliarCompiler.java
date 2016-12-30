package com.juliar;

import com.juliar.errors.ErrorListener;
import com.juliar.nodes.*;
import com.juliar.vistor.JuliarVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.juliar.parser.*;

import static java.lang.System.err;
import static java.lang.System.out;
import com.juliar.errors.PrintError;


public class JuliarCompiler {

    public static void main(String[] args) {
        try {
            JuliarCompiler compiler = new JuliarCompiler();
            compiler.compile(args[0], args[1], false);
        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }
    }

    public List<String> compile(String source, String outputPath, boolean isRepl) {
        try {
            FileInputStream fileInputStream = new FileInputStream(source);
            return compile(fileInputStream, outputPath, isRepl);
        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }

        return new ArrayList<String>();
    }

    public List<String> compile(InputStream b, String source, boolean isRepl) {

        try {
            //FileInputStream fileInputStream = new FileInputStream(source);
            ANTLRInputStream s = new ANTLRInputStream(b);

            juliarLexer lexer = new juliarLexer(s);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            juliarParser parser = new juliarParser(tokenStream);

            parser.removeErrorListeners();
            ErrorListener errors = new ErrorListener();
            parser.addErrorListener(errors);

            //Additional
            juliarParser.StatementContext context = parser.statement();
            out.println(context.toStringTree(parser));

            JuliarVisitor visitor = new JuliarVisitor();
            visitor.visit(context);
            if (!isRepl) {
                com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
                generator.Generate(visitor.instructions());
            }
            return errors.ErrorList();


        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }

        return new ArrayList<>();
    }

}
