package com.juliar.test;

import com.juliar.JuliarCompiler;
import junit.framework.TestCase;

import java.lang.reflect.Method;

import static java.lang.System.out;

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

    public void testCompile() throws Exception {
        try {
            JuliarCompiler compiler = new JuliarCompiler();
            compiler.compile("test.jrl", ".");
            JClassLoader classLoader = new JClassLoader();

            Class <?> juliar = classLoader.findClass("JuliarFuture");

            if (juliar != null) {
                Method m = juliar.getMethod("juliarMethod");
                Object obj = juliar.newInstance();
                if (m != null && obj != null) {
                    m.invoke(obj);
                }
            }
        }
        catch(Exception ex) {
            throw ex;
        }
    }
}