package com.juliar.codegenerator;
import com.juliar.nodes.IntegralType;

import static org.objectweb.asm.Opcodes.*;

import java.util.*;

/**
 * Created by AndreiM on 11/14/2016.
 */
public class CodeGeneratorMap {
    private CodeGeneratorMap(){}

    private static final Map<String, List<Integer>> map;
    static {
        map = new HashMap<>();
        map.put("add", new ArrayList<>(Arrays.asList(IADD,LADD,FADD,DADD)));
        map.put("sub", new ArrayList<>(Arrays.asList(ISUB,LSUB,FSUB,DSUB)));
        map.put("multiply", new ArrayList<>(Arrays.asList(IMUL,LMUL,FMUL,DMUL)));
        map.put("divide", new ArrayList<>(Arrays.asList(IDIV, LDIV,FDIV,DDIV)));
        map.put("modulo", new ArrayList<>(Arrays.asList(IREM,LREM,FREM,DREM)));
    }


    public static Map<IntegralType,Integer> generateMap(String instruction){
        List<Integer> current = map.get(instruction);
        Map<IntegralType, Integer> hmap = new EnumMap<>(IntegralType.class);
        hmap.put(IntegralType.jinteger,current.get(0));
        hmap.put(IntegralType.jlong,current.get(1));
        hmap.put(IntegralType.jfloat,current.get(2));
        hmap.put(IntegralType.jdouble,current.get(3));
        return hmap;
    }

    public static List<Integer> generateList(String instruction){
        return map.get(instruction);
    }
}
