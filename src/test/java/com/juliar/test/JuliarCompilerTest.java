package com.juliar.test;

import com.juliar.JuliarCompiler;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

import static java.lang.System.out;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by donreamey on 10/25/16.
 */
public class JuliarCompilerTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInterpreter() throws Exception{
        JuliarCompiler compiler = new JuliarCompiler();
        compiler.isDebug = true;
        List<String> errorList = null;
        errorList = compiler.compile("examples/test.jrl", ".",  false);
        //errorList.addAll( compiler.compile("serialize.jrl", ".",  false,false));

        if (errorList.size() > 0 ){
            throw new RuntimeException( "compile errors" );
        }

        try {
            String [] libsToLoad = new String[] { "test.lib" };//, "serialize.lib" } ;
            testLoadLibs( libsToLoad );
        }
        catch( Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public void testCompile() throws Exception {
        try {
            JuliarCompiler compiler = new JuliarCompiler();
            assertNotNull(compiler);
            List<String> errorList = compiler.compile("test.jrl", ".",  false);

            for(String s : errorList){
                out.println(s);
            }
            Assert.assertTrue( errorList.size() == 0 );
        }
        catch(Exception ex) {
            throw ex;
        }
    }


    public void testLoadLibs( String[] libToLoad) throws Exception {
        assertNotNull(libToLoad);
        /*try {
            InstructionInvocation invocation = com.juliar.LoaderLinker.LoadLink.loadAndLink( libToLoad );
            if ( invocation != null ) {
                new Interpreter(invocation);
            }
        }
        catch( Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        */
    }

    public void testScriptEngine() throws Exception {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        engine.eval("function sum(a, b) { a = b; a++; return b; }");
        Object returnScriptValue = engine.eval("sum(1, 2);");
        int i = 4;
    }
}