package com.juliar.codegenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.commons.Method;

import static com.sun.org.apache.bcel.internal.generic.InstructionConstants.ISTORE_1;
import static com.sun.org.apache.bcel.internal.generic.InstructionConstants.ISTORE_2;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import static java.lang.System.out;
import static org.objectweb.asm.Opcodes.*;
import com.juliar.nodes.*;

/**
 * Created by donreamey on 10/22/16.
 */
public class CodeGenerator {
    public CodeGenerator(){
    }

    public void Generate(Node rootNode) throws java.io.FileNotFoundException, java.io.IOException {
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
        EvaluateExpressions(rootNode, mw, ga, stackSize);

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


        // ------------------------------------------------------------------------
        // Same example with a GeneratorAdapter (more convenient but slower)
        // ------------------------------------------------------------------------
/*
        cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cw.visit(V1_1, ACC_PUBLIC, "Example", null, "java/lang/Object", null);

        // creates a GeneratorAdapter for the (implicit) constructor
        Method m = Method.getMethod("void <init> ()");
        GeneratorAdapter mg = new GeneratorAdapter(ACC_PUBLIC, m, null, null,
                cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();

        // creates a GeneratorAdapter for the 'main' method
        m = Method.getMethod("void main (String[])");
        mg = new GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, m, null, null, cw);
        mg.getStatic(Type.getType(System.class), "out",
                Type.getType(PrintStream.class));
        mg.push("Hello world!");
        mg.invokeVirtual(Type.getType(PrintStream.class),
                Method.getMethod("void println (String)"));
        mg.returnValue();
        mg.endMethod();

        cw.visitEnd();

        code = cw.toByteArray();
       */
    }

    private MethodVisitor EvaluateExpressions(Node root, MethodVisitor mw, GeneratorAdapter ga, Integer stackSize ){
        if (root instanceof CompliationUnitNode){
            List<Node> t = ((CompliationUnitNode)root).statementNodes;
            for(Node n : t){
                EvaluateExpressions(n, mw, ga, stackSize);
            }
        }

        if (root instanceof StatementNode){
            List<Node> t = ((StatementNode)root).statements;
            for (Node n : t){
                EvaluateExpressions(n, mw, ga, stackSize);
            }
        }

        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.Operation().equals(BinaryOperation.add)){

                Integer left = 0;
                Integer right = 0;

                if (b.Left().Operation().equals(BinaryOperation.data))
                {
                    left = Integer.parseInt( (String) b.Left().Data() );
                }

                if (b.Right().Operation().equals(BinaryOperation.data)) {
                    right = Integer.parseInt((String) b.Right().Data());
                }

                mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");

                ga.push( left.intValue());
                ga.push( right.intValue());
                ga.visitInsn(IADD);

                mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(I)V", false);
                out.println(left + right);
            }
        }
return mw;
    }
}
