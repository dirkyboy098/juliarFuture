package com.juliar.codegenerator;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.*;

import static org.objectweb.asm.Opcodes.*;
import com.juliar.nodes.*;
import com.juliar.codegenerator.CodeGeneratorMap;


/**
 * Created by donreamey on 10/22/16.
 */
public class CodeGenerator {
    private boolean debug = true;
    public CodeGenerator(){
    }

    public void Generate(List<Node> instructions) throws java.io.FileNotFoundException, java.io.IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_1, ACC_PUBLIC, "JuliarFuture", null, "java/lang/Object", null);

        // creates a MethodWriter for the (implicit) constructor
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        // pushes the 'this' variable
        mw.visitVarInsn(ALOAD, 0);
        // invokes the super class constructor
        mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mw.visitInsn(RETURN);
        // this code uses a maximum of one stack element and one local variable
        mw.visitMaxs(1, 1);
        mw.visitEnd();


        // creates a MethodWriter for the 'main' method
        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        // pushes the 'out' field (of type PrintStream) of the System class
        mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");
        // pushes the "Hello Juliar Future" String constant
        mw.visitLdcInsn("Now Calling generated Juliar Methods!");
        // invokes the 'println' method (defined in the PrintStream class)
        mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(Ljava/lang/String;)V", false);
        // mw.visitInsn(RETURN);
        // this code uses a maximum of two stack elements and two local
        // variables
        //mw.visitVarInsn(ALOAD,0);
        mw.visitMethodInsn(INVOKESTATIC, "JuliarFuture", "juliarMethod", "()V", false);
        mw.visitInsn(RETURN);

        mw.visitMaxs(2, 2);
        mw.visitEnd();

        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "juliarMethod", "()V", null, null);

        Integer stackSize = 0;
        GeneratorAdapter ga = new GeneratorAdapter(mw, ACC_PUBLIC + ACC_STATIC, "juliarMethod", "()V");
        EvaluateExpressions(instructions, mw, ga, stackSize);

        mw.visitInsn(RETURN);
        mw.visitMaxs(16, 6);
        mw.visitEnd();

        MethodVisitor foo = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "foo", "()V", null, null);

        GeneratorAdapter ga1 = new GeneratorAdapter(foo, ACC_PUBLIC + ACC_STATIC, "foo", "()V");
        foo.visitInsn(RETURN);
        foo.visitEnd();


        // gets the bytecode of the Example class, and loads it dynamically
        byte[] code = cw.toByteArray();

        FileOutputStream fos = new FileOutputStream("JuliarFuture.class");
        fos.write(code);
        fos.close();
    }

    private MethodVisitor EvaluateExpressions(List<Node> instructions, MethodVisitor mw, GeneratorAdapter ga, Integer stackSize ){
        for(Node instruction : instructions) {
            if ( instruction instanceof PrimitiveNode){
                String function = ((PrimitiveNode) instruction).getPrimitiveName().toString();

                if (function.equals("fileOpen")){
                    function = "sys_file_open";

                mw.visitLdcInsn( ((PrimitiveNode) instruction).getGetPrimitiveArgument().toString());
                mw.visitIntInsn(ASTORE, 0);
                mw.visitIntInsn(ALOAD, 0);
                mw.visitMethodInsn(
                        INVOKESTATIC,
                        "com/juliar/pal/Primitives",
                        function,
                        "(Ljava/lang/String;)Ljava/lang/String;",
                        false);
                }

                if (function.equals("printLine")){
                    function = "sys_print_line";
                    mw.visitLdcInsn( ((PrimitiveNode) instruction).getGetPrimitiveArgument().toString());
                    mw.visitIntInsn(ASTORE, 0);
                    mw.visitIntInsn(ALOAD, 0);
                    mw.visitMethodInsn(
                            INVOKESTATIC,
                            "com/juliar/pal/Primitives",
                            function,
                            "(Ljava/lang/String;)V",
                            false);
                }
            }

            if (instruction instanceof CompliationUnitNode) {
                /*
                List<Node> t = ((CompliationUnitNode) instructions).statementNodes;

                for (Node n : t) {
                    EvaluateExpressions(n, mw, ga, stackSize);
                }
                */
            }

            if (instruction instanceof StatementNode) {
                /*
                List<Node> t = ((StatementNode) instructions).statements;

                for (Node n : t) {
                    EvaluateExpressions(n, mw, ga, stackSize);
                }
                */
            }

            if (instruction instanceof BinaryNode){
                Map<IntegralType,Integer> op = CodeGeneratorMap.GenerateMap(((BinaryNode)instruction).operation().toString());

                BinaryNode b = ((BinaryNode)instruction);
                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                IntegralType addType;
                IntegralTypeNode ln = (IntegralTypeNode)b.left();
                IntegralTypeNode rn = (IntegralTypeNode)b.right();

                if (ln.getIntegralType() == IntegralType.jdouble || rn.getIntegralType() == IntegralType.jdouble){
                    addType = IntegralType.jdouble;
                } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
                    addType =  IntegralType.jfloat;
                } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
                    addType = IntegralType.jlong;
                } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
                    addType = IntegralType.jinteger;
                } else{
                   addType = null;
                }

                pushIntegralType(ga, b.left(),addType);
                pushIntegralType(ga, b.right(),addType);
                ga.visitInsn(op.get(addType));

                debugPrintLine(mw,addType);
            }

            if (instruction instanceof AggregateNode) {
                Map<IntegralType,Integer> op = CodeGeneratorMap.GenerateMap(((AggregateNode)instruction).operation().toString());

                List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)instruction).data();
                int addCount = integralTypeNodes.size() - 1;

                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                //Scan Type to typecast correctly
                IntegralType addType = IntegralType.jinteger;
                int[] anArray = new int[5];
                for(IntegralTypeNode integralTypeNode: integralTypeNodes){
                    switch(integralTypeNode.getIntegralType()){
                        case jdouble:
                            anArray[0]++;
                            break;
                        case jfloat:
                            anArray[1]++;
                            break;
                        case jlong:
                            anArray[2]++;
                            break;
                    }
                }
                //
                if(anArray[0] != 0){
                    addType = IntegralType.jdouble;
                }
                else if(anArray[1] != 0){
                    addType = IntegralType.jfloat;
                }
                else if(anArray[2] != 0){
                    addType = IntegralType.jlong;
                }
                for(IntegralTypeNode integralTypeNode : integralTypeNodes) {
                    pushIntegralType( ga, integralTypeNode,addType);
                }

                for(int i = 0; i < addCount; i++) {
                    ga.visitInsn(op.get(addType));
                }

                debugPrintLine(mw,addType);
            }
        }


        return mw;
    }

    private void debugPrintLine(MethodVisitor mw, IntegralType addType) {
        if (debug) {
            switch (addType) {
                case jdouble:
                    mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
                    break;
                case jfloat:
                    mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
                    break;
                case jinteger:
                    mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
                    break;
                case jlong:
                    mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(L)V", false);
                    break;
            }
        }
    }

    private void pushIntegralType(GeneratorAdapter ga, Node node, IntegralType integralType) {
        if (node instanceof IntegralTypeNode) {
            IntegralTypeNode integralTypeNode = ((IntegralTypeNode)node);
            switch (integralType) {
                case jdouble:
                    ga.push(Double.parseDouble((String) integralTypeNode.data()));
                    break;
                case jfloat:
                    ga.push(Float.parseFloat((String) integralTypeNode.data()));
                    break;
                case jinteger:
                    ga.push(Integer.parseInt((String) integralTypeNode.data()));
                    break;
                case jlong:
                    ga.push(Long.parseLong((String) integralTypeNode.data()));
                    break;
            }
        }
    }
}
