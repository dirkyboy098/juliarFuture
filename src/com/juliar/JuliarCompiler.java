package com.juliar;

import com.juliar.errors.ErrorListener;
import com.juliar.interpreter.interpreter;
import com.juliar.vistor.JuliarVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.juliar.parser.*;
import static java.lang.System.out;
import com.juliar.errors.PrintError;


public class JuliarCompiler {

    private ErrorListener errors;

    public static void main(String[] args) {
        try {
            assert args[0] != null && args[1] != null;
            boolean compilerFlag = args[2] == null ? true : false;
            JuliarCompiler compiler = new JuliarCompiler();
            compiler.compile(args[0], args[1], compilerFlag, false);
        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }
    }

    public List<String> compile(String source, String outputPath, boolean isRepl) {
        try {
            FileInputStream fileInputStream = new FileInputStream(source);
            return compile(fileInputStream, outputPath, false, isRepl);
        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }

        return new ArrayList<String>();
    }

    public List<String> compile(InputStream b, String source, boolean compilerFlag, boolean isRepl) {
        try {
            juliarParser parser = parse( b );

            errors = new ErrorListener();
            parser.addErrorListener(errors);

            // call parse statement.
            // This will parse a single line to validate the syntax
            if (isRepl) {
                juliarParser.StatementContext context = parser.statement();
                out.println(context.toStringTree(parser));

                JuliarVisitor v = new JuliarVisitor();
                v.visit(context);
                interpreter i = new interpreter(v.instructions());
            } else {
                // Calls the parse CompileUnit method
                // to parse a complete program
                // then calls the code generator.
                juliarParser.CompileUnitContext context = parser.compileUnit();
                out.println(context.toStringTree(parser));

                if (errors.ErrorList().size() > 0){
                    for (String error : errors.ErrorList()){
                        out.println( error );
                    }

                    return errors.ErrorList();
                }


                JuliarVisitor visitor = new JuliarVisitor();
                visitor.visit(context);

                if(compilerFlag){
                    interpreter i = new interpreter(visitor.instructions());
                }
                else {
                    com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
                    //generator.Generate(visitor.instructions());
                }
            }

            //return errors.ErrorList();


        } catch (Exception ex) {
            new PrintError(ex.getMessage(),ex);
        }

        return new ArrayList<>();
    }



    private juliarParser parse(InputStream b) throws Exception {
        juliarParser parser = null;

        try {
            ANTLRInputStream s = new ANTLRInputStream(b);

            juliarLexer lexer = new juliarLexer(s);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new juliarParser(tokenStream);

            parser.removeErrorListeners();
        } catch (Exception ex) {
            throw ex;
        }

        return parser;
    }
}
