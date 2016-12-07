package com.juliar.codegenerator;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassWriter;
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
        mw.visitLdcInsn("Calling generated Juliar Methods!");
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
        mw.visitMaxs(6, 6);
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
                    pushIntegralType(ga, b.left(),IntegralType.jdouble);
                    pushIntegralType(ga, b.right(),IntegralType.jdouble);
                    ga.visitInsn(op.get(IntegralType.jdouble));
                    addType = IntegralType.jdouble;
                } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
                    pushIntegralType(ga, b.left(),IntegralType.jfloat);
                    pushIntegralType(ga, b.right(),IntegralType.jfloat);
                    ga.visitInsn(op.get(IntegralType.jfloat));
                    addType =  IntegralType.jfloat;
                } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
                    pushIntegralType(ga, b.left(),IntegralType.jinteger);
                    pushIntegralType(ga, b.right(),IntegralType.jinteger);
                    ga.visitInsn(op.get(IntegralType.jinteger));
                    addType = IntegralType.jinteger;
                } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
                    pushIntegralType(ga, b.left(),IntegralType.jlong);
                    pushIntegralType(ga, b.right(),IntegralType.jlong);
                    ga.visitInsn(op.get(IntegralType.jlong));
                    addType = IntegralType.jlong;
                } else{
                   addType = null;
                }

                debugPrintLine(mw,addType);
            }

            if (instruction instanceof AggregateNode) {
                GenerateAggregateIntegerAdd(instruction, mw, ga);
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

    private void GenerateAggregateIntegerAdd(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof AggregateNode){

            List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)root).Data();

            int addCount = integralTypeNodes.size() - 1;

            if (debug) {
                //mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            }

            for(IntegralTypeNode integralTypeNode : integralTypeNodes) {
                //ga.push( Integer.parseInt( (String) binaryNode.data()));
                pushIntegralType( ga, integralTypeNode,IntegralType.jinteger);
            }

            for(int i = 0; i < addCount; i++) {
                ga.visitInsn(IADD);
            }

            //mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(I)V", false);
        }
    }
}
