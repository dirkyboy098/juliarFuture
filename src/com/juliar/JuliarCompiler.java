package com.juliar;

import com.juliar.nodes.*;
import com.juliar.vistor.JuliarVisitor;
import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.FileInputStream;
import java.util.List;
import com.juliar.parser.*;
import static java.lang.System.out;


public class JuliarCompiler {

    public static void main(String[] args) {
        try {
            JuliarCompiler compiler = new JuliarCompiler();
            compiler.compile(args[0], args[1]);
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }


    public void compile(String source, String ouputPath){
        try {
            FileInputStream fileInputStream = new FileInputStream(source);
            ANTLRInputStream s = new ANTLRInputStream(fileInputStream);

            juliarLexer lexer = new juliarLexer(s);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            juliarParser parser = new juliarParser(tokenStream);

            juliarParser.CompileUnitContext context = parser.compileUnit();
            out.println(context.toStringTree(parser));

            JuliarVisitor visitor = new JuliarVisitor();
            Node node = visitor.visit(context);
            EvaluateExpressions( node );


            ParseTreeWalker treeWalker = new ParseTreeWalker();
            com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
            generator.Generate(node);


        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }

    private void EvaluateExpressions(Node root){
        if (root instanceof CompliationUnitNode){
            List<Node> t = ((CompliationUnitNode)root).statementNodes;
            for(Node n : t){
                EvaluateExpressions(n);
            }
        }

        if (root instanceof StatementNode){
            List<Node> t = ((StatementNode)root).statements;
            for (Node n : t){
                EvaluateExpressions(n);
            }
        }

        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.Operation().equals(BinaryOperation.add)){

                Integer left = 0;
                Integer right = 0;

                if (b.Left().Operation().equals(BinaryOperation.data))
                {
                    left = Integer.parseInt( (String) b.Left().Data() );
                }

                if (b.Right().Operation().equals(BinaryOperation.data)) {
                    right = Integer.parseInt((String) b.Right().Data());
                }

                out.println(left + right);
            }
        }
    }
}
