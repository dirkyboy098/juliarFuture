package com.juliar.test;

import com.juliar.pal.Primitives;

/**
 * Created by Don on 12/24/2016.
 */
public class TestByteCode {
    public TestByteCode(String path) {
        test();
    }
    static public void test(){
        String s = "path";
        Primitives.sys_file_open(s);
 }
}
