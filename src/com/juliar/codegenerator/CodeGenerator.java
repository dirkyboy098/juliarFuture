package com.juliar.codegenerator;

import java.io.FileOutputStream;
import java.util.List;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.*;
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

            if (b.Operation().equals(Operation.add)){

                Integer left = 0;
                Integer right = 0;

                if (b.Left().Operation().equals(Operation.data))
                {
                    left = Integer.parseInt( (String) b.Left().Data() );
                }

                if (b.Right().Operation().equals(Operation.data)) {
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

        GenerateAggregateIntegerAdd(root, mw, ga);


        return mw;
    }

    private void GenerateAggregateIntegerAdd(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof AggregateNode){

            List<BinaryNode> binaryNodeList = ((AggregateNode)root).Data();

            int addCount = binaryNodeList.size() - 1;

            mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");

            for(BinaryNode binaryNode : binaryNodeList) {
                ga.push( Integer.parseInt( (String) binaryNode.Data()));
            }

            for(int i = 0; i < addCount; i++) {
                ga.visitInsn(IADD);
            }

            mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(I)V", false);
        }
    }
}
