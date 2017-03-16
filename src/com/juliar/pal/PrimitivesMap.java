package com.juliar.pal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AndreiM on 1/1/2017.
 */
public class PrimitivesMap {
    private static final Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put("fileOpen", "sys_file_open");
        map.put("printLine", "sys_print_line");
        map.put("printInt", "sys_print_int");
        map.put("printFloat", "sys_print_float");
        map.put("printDouble", "sys_print_double");
        map.put("printLong", "sys_print_long");
        map.put("fileWrite", "sys_file_write");
        map.put("print", "sys_print");
        map.put("available_memory", "sys_available_memory");
    }


    public static String getFunction(String name){
        String current = map.get(name);

        if(current == null) {
            return name;
        }

        return current;
    }

    public static Boolean isPrimitive(String name) {
        return map.get( name ) != null;
    }

}
