package com.juliar.test;

import com.juliar.pal.Primitives;
import junit.framework.TestCase;

/**
 * Created by Don on 12/24/2016.
 */
public class TestByteCode extends TestCase {
    public void testRead(){
        String s = "D:\\source\\juliarFuture\\test.jrl";
        Primitives.sysFileOpen(s);
        assertNotNull(s);
    }

    public void testPrint(){
        Primitives.sysPrintLine("this is a test");
        assertNotNull("test");
    }


    public void testGetMemoryUsage(){
        Primitives.sysAvailableMemory();
        assertNotNull(Primitives.sysAvailableMemory());
    }


    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

}
