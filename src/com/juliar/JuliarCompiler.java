package com.juliar;

import com.fastcgi.FCGIInterface;
import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.ErrorListener;
import com.juliar.errors.LogMessage;
import com.juliar.interpreter.Interpreter;
import com.juliar.interpreter.ReadWriteBinaryFile;
import com.juliar.parser.JuliarLexer;
import com.juliar.parser.JuliarParser;
import com.juliar.symbolTable.SymbolTable;
import com.juliar.vistor.Visitor;
import com.juliar.jpm.JPM;
import com.juliar.gui.Gui;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JuliarCompiler {
	public boolean isDebugMode = false;
    private ErrorListener errors;
    private String inputFileName;

    public static void main(String[] args) {
		fastCGI();
    	if(System.console() == null) {
			new Thread(() -> javafx.application.Application.launch(Gui.class)).start();
			return;
		}
		try {
			String[] unparsed_args = parseFlags(args);

			if (startupInstructions(unparsed_args)) {
				return;
			}

			Boolean compileFlag = false;
			String fileName = unparsed_args[0];
			String outputPath = "/";
			if(unparsed_args.length > 1){
				outputPath = unparsed_args[1];
				compileFlag = true;
			}

			Boolean replFlag = false;
			JuliarCompiler compiler = new JuliarCompiler();
			compiler.compile(fileName, outputPath, compileFlag, replFlag);

		} catch (Exception ex) {
			new LogMessage("Error " + ex.getMessage(), ex);
		}
	}

	private static boolean startupInstructions(String[] args) {
		LogMessage.message("Juliar Compiler - Copyright (C) 2017");

		if(args.length != 1 && args.length != 2){
            LogMessage.message("Usage: java -jar JuliarCompiler.jar <source file> <output path> <fcgi port>");
            LogMessage.message("Path to Juliar source file");
            LogMessage.message("Path to output directory if compiled.");
            LogMessage.message("If output path is undefined, source file will be interpreted");
            LogMessage.message("If you would like to use JuliarCompiler for web specify fcgi port ex. -DFCGI=9000");
			return true;
        }
		return false;
	}

	private static String[] parseFlags(String[] args) {
		String[] params;
		ArrayList<String> unparsed = new ArrayList<String>();
		for(int i=0; i < args.length; i++) {
			if(args[i].startsWith("-")){
				 params = args[i].split("-");
				 switch(params[0]){
					 case "-selfupdate":
					 	new JPM();
					 	break;
					 case "-verbose":
						System.out.println("verbose is on");
					 	break;
					 default:
					 	break;
				 }
			}
			else{
				unparsed.add(args[i]);
			}
        }
        return unparsed.toArray(new String[0]);
	}

	private static void fastCGI() {
		FCGIInterface fastCGIInterface = new FCGIInterface();
		while (fastCGIInterface.FCGIaccept() >= 0) {
			String method = System.getProperty("REQUEST_METHOD");

			if (method != null) {
				String DOCUMENT_ROOT = System.getProperty("DOCUMENT_ROOT");
				String SCRIPT_NAME = System.getProperty("SCRIPT_NAME");
				System.out.println("Content-type: text/html\r\n\r\n");
				System.out.println("<html>");

				if (SCRIPT_NAME == "/" || SCRIPT_NAME == "") {
					SCRIPT_NAME = "index.jrl";
				}

				JuliarCompiler compiler = new JuliarCompiler();
				compiler.compile(DOCUMENT_ROOT + SCRIPT_NAME, "", false, false);
				System.out.println("</html>");
			}
		}
	}

	public List<String> compile(String source, String outputPath, boolean compilerFlag, boolean isRepl) {
        try {
        	inputFileName = source;
			FileInputStream fileInputStream = new FileInputStream(source);
			return compile(fileInputStream, outputPath, compilerFlag, isRepl);
        }
		catch (Exception ex) {
        	ex.printStackTrace();
			new LogMessage(ex.getMessage(),ex);
		}
		
        return new ArrayList<>();
	}

	public List<String> compile(InputStream b, String outputfile, boolean compilerFlag, boolean isRepl) {
        try {
			SymbolTable.clearSymbolTable();
			JuliarParser parser = parse( b );
			
			errors = new ErrorListener();
			parser.addErrorListener(errors);
			
			// call parse statement.
			// This will parse a single line to validate the syntax
			if (isRepl) {
				executeCommandLineRepl(parser);
			}
			else {
				if (excuteCompiler(outputfile, compilerFlag, parser)) {
					return errors.ErrorList();
				}

			}
			} catch (Exception ex) {
			new LogMessage(ex.getMessage(),ex);
		}
		
        return new ArrayList<>();
	}

	/*
	Will execute the compiler or the interpreter.
	 */
	private boolean excuteCompiler(String outputfile, boolean compilerFlag, JuliarParser parser) throws IOException {
		// Calls the parse CompileUnit method
		// to parse a complete program
		// then calls the code generator.

		JuliarParser.CompileUnitContext context = parser.compileUnit();
		if (isDebugMode) {
            System.out.println(context.toStringTree(parser));
        }

		Visitor visitor = new Visitor((imports, linesToSkip) -> {}, true);
		visitor.visit(context);

		if (errors.ErrorList().size() > 0 || visitor.getErrorList().size() > 0){
			for (String error : errors.ErrorList()){
				System.out.println( error );
			}

			for (String error : visitor.getErrorList()){
				System.out.println( error );
			}

			return true;
		}

		if(compilerFlag){
            com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
            generator.Generate(visitor.instructions(),outputfile);
        }

        if ( isDebugMode ) {
			ReadWriteBinaryFile readWriteBinaryFile = new ReadWriteBinaryFile();
			readWriteBinaryFile.write(inputFileName, visitor.instructions() );
			InstructionInvocation invocation = readWriteBinaryFile.read( inputFileName );
			if (invocation != null) {
				new Interpreter( invocation );
			}
		}
		else {
			new Interpreter(visitor.instructions());
		}

		return false;
	}

	/*
	Runs the REPL engine from the command line.
	 */
	private void executeCommandLineRepl(JuliarParser parser) {
		JuliarParser.CompileUnitContext context = parser.compileUnit();
		if (isDebugMode) {
            System.out.println(context.toStringTree(parser));
        }
		Visitor v = new Visitor(new ImportsInterface() {
            @Override
            public void createTempCallback(String imports, int linesToSkip) {

            }
        }, true);

		v.visit(context);
		Interpreter i = new Interpreter(v.instructions());
	}


	private JuliarParser parse(InputStream b) throws Exception {
        JuliarParser parser = null;

        ANTLRInputStream s = new ANTLRInputStream(b);

        JuliarLexer lexer = new JuliarLexer(s);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JuliarParser(tokenStream);

        parser.removeErrorListeners();

        return parser;
	}
}
