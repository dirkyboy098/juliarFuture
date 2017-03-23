package com.juliar;

import com.fastcgi.FCGIInterface;
import com.juliar.gui.Gui;
import com.juliar.errors.ErrorListener;
import com.juliar.errors.LogMessage;
import com.juliar.interpreter.Interpreter;
import com.juliar.parser.juliarLexer;
import com.juliar.parser.juliarParser;
import com.juliar.symbolTable.SymbolTable;
import com.juliar.vistor.JuliarVisitor;
import com.juliar.jpm.JPM;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class JuliarCompiler {
	
    private ErrorListener errors;
	
    public static void main(String[] args) {
		/*
    	if(System.console() == null) {
			new Thread(() -> javafx.application.Application.launch(Gui.class)).start();
			return;
		}*/
        try {
			fastCGI();
			//checkAddArgs(args);

			LogMessage.message("Juliar Compiler - Copyright (C) 2017");
			
            if(args.length != 4){
                LogMessage.message("Usage: java -jar JuliarCompiler.jar <source file> <output path> <fcgi port>");
                LogMessage.message("Path to Juliar source file");
                LogMessage.message("Path to output directory if compiled.");
                LogMessage.message("If output path is undefined, source file will be interpreted");
                LogMessage.message("If you would like to use JuliarCompiler for web specify fcgi port ex. -DFCGI=9000");
                return;
			}

			String fileName = args[0];
			String outputPath = args[1];
			Boolean compileFlag = args[2].equals("true") ? true : false;
			Boolean replFlag = args[3].equals("true") ? true : false;

			JuliarCompiler compiler = new JuliarCompiler();

            compiler.compile(fileName, outputPath, compileFlag , replFlag);

			} catch (Exception ex) {
            new LogMessage("Error " + ex.getMessage(),ex);
		}
	}

	private static void checkAddArgs(String[] args) {
		for(int i=0; i < args.length; i++) {
            if(args[i].startsWith("-DFCGI_PORT=")) fastCGI();
            else if(args[i].equals("-selfupdate")) new JPM();
        }
	}

	private static void fastCGI() {
		int status =0;
		int count = 0;
		FCGIInterface intf = new FCGIInterface();
		while (intf.FCGIaccept() >= 0) {
				String DOCUMENT_ROOT = System.getProperty("DOCUMENT_ROOT");
				String SCRIPT_NAME = System.getProperty("SCRIPT_NAME");
                String QUERY_STRING = System.getProperty("QUERY_STRING"); //PARAMETERS
                /*Map<String, String> query_pairs = new LinkedHashMap<String, String>();
                String[] pairs = QUERY_STRING.split("&");
                for(String pair: pairs){
                    int idx = pair.indexOf('=');
                    try {
                        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }*/
				System.out.println("Content-type: text/html\r\n\r\n");

				System.out.println("<html>");
				if (SCRIPT_NAME == "/" || SCRIPT_NAME == "") SCRIPT_NAME = "index.jrl";
				JuliarCompiler compiler2 = new JuliarCompiler();
				compiler2.compile(DOCUMENT_ROOT + SCRIPT_NAME, "", false, false);
				System.out.println("</html>");
				SymbolTable.DeleteSymbolTable();
        }
	}


	public List<String> compile(String source, String outputPath, boolean compilerFlag, boolean isRepl) {
        try {
			FileInputStream fileInputStream = new FileInputStream(source);
			return compile(fileInputStream, outputPath, compilerFlag, isRepl);
        }
		catch (Exception ex) {
			new LogMessage(ex.getMessage(),ex);
		}
		
        return new ArrayList<>();
	}

	public List<String> compile(InputStream b, String outputfile, boolean compilerFlag, boolean isRepl) {
        try {
			juliarParser parser = parse( b );
			
			errors = new ErrorListener();
			parser.addErrorListener(errors);
			
			// call parse statement.
			// This will parse a single line to validate the syntax
			if (isRepl) {
				juliarParser.CompileUnitContext context = parser.compileUnit();
				System.out.println(context.toStringTree(parser));

				JuliarVisitor v = new JuliarVisitor(new ImportsInterface() {
					@Override
					public void createTempCallback(String imports, int linesToSkip) {

					}
				}, true);

				v.visit(context);
				Interpreter i = new Interpreter(v.instructions());
			}
			else {
				// Calls the parse CompileUnit method
				// to parse a complete program
				// then calls the code generator.

				juliarParser.CompileUnitContext context = parser.compileUnit();
				System.out.println(context.toStringTree(parser));
				
				if (errors.ErrorList().size() > 0){
					for (String error : errors.ErrorList()){
						//out.println( error );
					}
					
					return errors.ErrorList();
				}

				JuliarVisitor visitor = new JuliarVisitor(new ImportsInterface() {
					@Override
					public void createTempCallback(String imports, int linesToSkip) {

					}
				}, true);
				visitor.visit(context);

				if(!compilerFlag){
					Interpreter i = new Interpreter(visitor.instructions());
				}
				else {
					com.juliar.codegenerator.CodeGenerator generator = new com.juliar.codegenerator.CodeGenerator();
					generator.Generate(visitor.instructions(),outputfile);
					Interpreter i = new Interpreter(visitor.instructions());
				}
			}
			
			//return errors.ErrorList();
			
			
			} catch (Exception ex) {
			new LogMessage(ex.getMessage(),ex);
		}
		
        return new ArrayList<>();
	}
	
	
	
	private juliarParser parse(InputStream b) throws Exception {
        juliarParser parser = null;

        ANTLRInputStream s = new ANTLRInputStream(b);

        juliarLexer lexer = new juliarLexer(s);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        parser = new juliarParser(tokenStream);

        parser.removeErrorListeners();

        return parser;
	}
}
