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
import org.antlr.v4.runtime.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;

public class JuliarCompiler {
	public static boolean isDebug = false;
	public static boolean isRepl = false;
	public static boolean isInline = false;
    private ErrorListener errors;
    private String inputFileName;

    public static void main(String[] args) {
		if(!isDebug && System.console() == null && args.length == 0) {
			Application.launch(Gui.class);
			return;
		}
		fastCGI();
		try {
			String[] unparsedArgs = parseFlags(args);
			if(isInline){
				String unparsedStr = String.join(" ", unparsedArgs);
				JuliarCompiler compiler = new JuliarCompiler();
				InputStream stream = new ByteArrayInputStream(unparsedStr.getBytes(StandardCharsets.UTF_8));
				compiler.compile(stream, "", false);
				return;
			}
			if (startupInstructions(unparsedArgs)) {
				return;
			}

			Boolean compileFlag = false;
			String fileName = unparsedArgs[0];
			String outputPath = "/";
			if(unparsedArgs.length > 1){
				outputPath = unparsedArgs[1];
				compileFlag = true;
				Logger.log("Compiling...");
			}


			JuliarCompiler compiler = new JuliarCompiler();
			compiler.compile(fileName, outputPath, compileFlag);

		} catch (Exception ex) {
			Logger.log("Error " + ex.getMessage());
		}
	}

	private static boolean startupInstructions(String[] args) {
		Logger.log("Juliar Compiler - Copyright (C) 2017");

		if(args.length != 1 && args.length != 2){
			Logger.log("Usage: java <-D [fcgi port]> -jar JuliarCompiler.jar <source file> <output path> ");
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
		for(String arg: args) {
			if(arg.startsWith("-")) switch (arg) {
				case "-app":
					Application.launch(Gui.class);
					break;
				case "-verbose":
					isDebug = true;
					Logger.log("verbose is on");
					break;
				case "-repl":
					isRepl = true;
					break;
				case "-inline":
					isInline = true;
					break;
				default:
					break;
			}
			else{
				unparsed.add(arg);
			}
        }
        return unparsed.toArray(new String[0]);
	}

	private static void fastCGI() {
		while ( new FCGIInterface().FCGIaccept() >= 0) {
			String method = System.getProperty("REQUEST_METHOD");

			if (method != null) {
				String documentROOT = System.getProperty("DOCUMENT_ROOT");
				String scriptNAME = System.getProperty("SCRIPT_NAME");
				Logger.log("Content-type: text/html\r\n\r\n");

				if ("/".equals(scriptNAME) || "".equals(scriptNAME)) {
					scriptNAME = "index.jrl";
				}

				JuliarCompiler compiler = new JuliarCompiler();
				compiler.compile(documentROOT + scriptNAME, "", false);
			}
		}
	}

	public List<String> compile(String source, String outputPath, boolean compilerFlag) {
        try {
        	inputFileName = source;
			FileInputStream fileInputStream = new FileInputStream(source);
			return compile(fileInputStream, outputPath, compilerFlag);
        }
		catch (Exception ex) {
			Logger.log(ex.getMessage());
		}
		
        return new ArrayList<>();
	}

	public List<String> compile(InputStream b, String outputfile, boolean compilerFlag) {
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
		if (isDebug) {
			Logger.log(context.toStringTree(parser));
		}

		Visitor visitor = new Visitor((imports, linesToSkip) -> {
		}, true);
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
		if (compilerFlag) {
			com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator(isDebug);
			generator.generate(visitor.instructions(), outputfile);
		}
		/*
		ReadWriteBinaryFile readWriteBinaryFile = new ReadWriteBinaryFile();
		readWriteBinaryFile.write(inputFileName, visitor.instructions());

		InstructionInvocation invocation = readWriteBinaryFile.read( inputFileName );
		if (invocation != null) {
			new Interpreter( invocation );
		}*/

		new Interpreter(visitor.instructions());


		return false;
	}

	/*
	Runs the REPL engine from the command line.
	TODO: Does this work?
	 */
	private void executeCommandLineRepl(JuliarParser parser) {
		JuliarParser.CompileUnitContext context = parser.compileUnit();
		if (isDebug) {
            Logger.log(context.toStringTree(parser));
        }
		Visitor v = new Visitor((imports, linesToSkip) -> {
            /*TODO Nothing?*/
        }, true);

		v.visit(context);
		new Interpreter(v.instructions());
	}


	private JuliarParser parse(InputStream b) throws IOException {
        JuliarParser parser;
        CharStream s = CharStreams.fromStream(b);

        JuliarLexer lexer = new JuliarLexer(s);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new JuliarParser(tokenStream);

        parser.removeErrorListeners();

        return parser;
	}
}
