package com.juliar.test;

import com.juliar.pal.Primitives;
import junit.framework.TestCase;

/**
 * Created by Don on 12/24/2016.
 */
public class TestByteCode extends TestCase {
    public void testRead(){
        String s = "D:\\source\\juliarFuture\\test.jrl";
        Primitives.sys_file_open(s);
        assertNotNull(s);
    }

    public void testPrint(){
        Primitives.sys_print_line("this is a test");
        assertNotNull("test");
    }


    public void testGetMemoryUsage(){
        Primitives.sys_available_memory();
        assertNotNull(Primitives.sys_available_memory());
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
