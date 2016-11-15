package com.juliar.codegenerator;
import java.util.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AndreiM on 11/14/2016.
 */
public class CodeGeneratorMap {
    public CodeGeneratorMap(){
    }
    public List<String> mytype(String type){
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("subtract", new ArrayList<String>(Arrays.asList("DSUB", "FSUB","ISUB","LSUB")));
        map.put("add", new ArrayList<String>(Arrays.asList("DADD", "FADD", "IADD", "LADD")));
        map.put("multiply", new ArrayList<String>(Arrays.asList("DMUL", "FMUL", "IMUL", "LMUL")));
        map.put("divide", new ArrayList<String>(Arrays.asList("DDIV", "FDIV", "IDIV", "LDIV")));

        return map.get(type);
    }
}
