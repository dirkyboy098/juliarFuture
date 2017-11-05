package com.juliar;

import com.juliar.errors.ErrorListener;
import com.juliar.errors.Logger;
import com.juliar.interpreter.Interpreter;
import com.juliar.parser.JuliarLexer;
import com.juliar.parser.JuliarParser;
import com.juliar.symboltable.SymbolTable;
import com.juliar.vistor.Visitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JuliarAndroid {
    private static ErrorListener errors;
    public static void main(String[] args) {
        try {
            compile(args[0]);
        } catch(Exception e) {
            Logger.log("Something went wrong");
        }
    }

    public static void compile(String s) {
        InputStream b = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        try {
            SymbolTable.clearSymbolTable();
            JuliarParser parser = parse( b );

            errors = new ErrorListener();
            parser.addErrorListener(errors);

            // call parse statement.
            // This will parse a single line to validate the syntax

            if (excuteCompiler(parser)) {
                errors.errorList();
            }

        } catch (Exception ex) {
            Logger.log(ex.getMessage());
        }
    }

    /*
    Will execute the compiler or the interpreter.
     */
    private static boolean excuteCompiler(JuliarParser parser) throws IOException {
        // Calls the parse CompileUnit method
        // to parse a complete program
        // then calls the code generator.

        JuliarParser.CompileUnitContext context = parser.compileUnit();
        Visitor visitor = new Visitor((imports, linesToSkip) -> {}, true);
        visitor.visit(context);

        if (!errors.errorList().isEmpty() || !visitor.getErrorList().isEmpty()) {
            for (String error : errors.errorList()) {
                Logger.logerr(error);
            }

            for (String error : visitor.getErrorList()) {
                Logger.logerr(error);
            }

            return true;
        }
        new Interpreter(visitor.instructions());
        return false;
    }



    private static JuliarParser parse(InputStream b) throws IOException {
        JuliarParser parser;
        CharStream s = CharStreams.fromStream(b);
        JuliarLexer lexer = new JuliarLexer(s);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JuliarParser(tokenStream);
        parser.removeErrorListeners();
        return parser;
    }
}
