package com.juliar;

import com.fastcgi.FCGIInterface;
import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.ErrorListener;
import com.juliar.errors.Logger;
import com.juliar.gui.Gui;
import com.juliar.interpreter.Interpreter;
import com.juliar.interpreter.ReadWriteBinaryFile;
import com.juliar.parser.JuliarLexer;
import com.juliar.parser.JuliarParser;
import com.juliar.symboltable.SymbolTable;
import com.juliar.vistor.Visitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JuliarCompiler {
	public static boolean isDebugMode = false;
    private ErrorListener errors;
    private String inputFileName;

    public static void main(String[] args) {
		fastCGI();
    	if(System.console() == null) {
			new Thread(() -> javafx.application.Application.launch(Gui.class)).start();
			return;
		}
		try {
			String[] unparsedArgs = parseFlags(args);

			if (startupInstructions(unparsedArgs)) {
				return;
			}

			Boolean compileFlag = false;
			String fileName = unparsedArgs[0];
			String outputPath = "/";
			if(unparsedArgs.length > 1){
				outputPath = unparsedArgs[1];
				compileFlag = true;
			}

			Boolean replFlag = false;
			JuliarCompiler compiler = new JuliarCompiler();
			compiler.compile(fileName, outputPath, compileFlag, replFlag);

		} catch (Exception ex) {
			Logger.log("Error " + ex.getMessage());
		}
	}

	private static boolean startupInstructions(String[] args) {
		Logger.log("Juliar Compiler - Copyright (C) 2017");

		if(args.length != 1 && args.length != 2){
			Logger.log("Usage: java -jar JuliarCompiler.jar <source file> <output path> <fcgi port>");
			Logger.log("Path to Juliar source file");
			Logger.log("Path to output directory if compiled.");
			Logger.log("If output path is undefined, source file will be interpreted");
			Logger.log("If you would like to use JuliarCompiler for web specify fcgi port ex. -DFCGI=9000");
			return true;
        }
		return false;
	}

	private static String[] parseFlags(String[] args) {
		ArrayList<String> unparsed = new ArrayList<>();
		for(int i=0; i < args.length; i++) {
			if(args[i].startsWith("-")){
				 switch(args[i]){
					 case "-app":
						 new Thread(() -> javafx.application.Application.launch(Gui.class)).start();
						 break;
					 case "-verbose":
						Logger.log("verbose is on");
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
				String documentROOT = System.getProperty("DOCUMENT_ROOT");
				String scriptNAME = System.getProperty("SCRIPT_NAME");
				Logger.log("Content-type: text/html\r\n\r\n");
				Logger.log("<html>");

				if ("/".equals(scriptNAME) || "".equals(scriptNAME)) {
					scriptNAME = "index.jrl";
				}

				JuliarCompiler compiler = new JuliarCompiler();
				compiler.compile(documentROOT + scriptNAME, "", false, false);
				Logger.log("</html>");
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
			Logger.log(ex.getMessage());
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
					return errors.errorList();
				}

			}
			} catch (Exception ex) {
			Logger.log(ex.getMessage());
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
            Logger.log(context.toStringTree(parser));
        }

		Visitor visitor = new Visitor((imports, linesToSkip) -> {}, true);
		visitor.visit(context);

		if (!errors.errorList().isEmpty()|| !visitor.getErrorList().isEmpty()){
			for (String error : errors.errorList()){
				Logger.logerr( error );
			}

			for (String error : visitor.getErrorList()){
				Logger.logerr( error );
			}

			return true;
		}

		if(compilerFlag){
            com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
            generator.generate(visitor.instructions(),outputfile);
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
            Logger.log(context.toStringTree(parser));
        }
		Visitor v = new Visitor((imports, linesToSkip) -> {
            /*TODO Nothing?*/
        }, true);

		v.visit(context);
		new Interpreter(v.instructions());
	}


	private JuliarParser parse(InputStream b) throws IOException {
        JuliarParser parser = null;

        ANTLRInputStream s = new ANTLRInputStream(b);

        JuliarLexer lexer = new JuliarLexer(s);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JuliarParser(tokenStream);

        parser.removeErrorListeners();

        return parser;
	}
}
