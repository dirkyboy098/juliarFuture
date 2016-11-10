package com.juliar.codegenerator;

import java.io.FileOutputStream;
import java.util.List;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.*;

import static org.objectweb.asm.Opcodes.*;
import com.juliar.nodes.*;

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
                if ( ((BinaryNode)instruction).operation() == Operation.add){
                    GenerateBinaryAdd(instruction, mw, ga);
                }

                if ( ((BinaryNode)instruction).operation() == Operation.sub){
                    GenerateBinarySubtraction(instruction, mw, ga);
                }

                if ( ((BinaryNode)instruction).operation() == Operation.multiply){
                    GenerateBinaryMultiplication(instruction, mw, ga);
                }

                if ( ((BinaryNode)instruction).operation() == Operation.divide){
                    GenerateBinaryDivision(instruction, mw, ga);
                }

            }

            if (instruction instanceof AggregateNode) {
                GenerateAggregateIntegerAdd(instruction, mw, ga);
            }
        }


        return mw;
    }

    private void GenerateBinaryAdd(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.operation().equals(Operation.add)) {

                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                pushIntegralType(ga, b.left());
                pushIntegralType(ga, b.right());
                IntegralType addType = pushIntigralAddInsn(ga, b.left(), b.right());

                debugPrintLine(mw, addType);
            }
        }
    }


    private void GenerateBinarySubtraction(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.operation().equals(Operation.sub)) {

                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                pushIntegralType(ga, b.left());
                pushIntegralType(ga, b.right());
                IntegralType addType = pushIntigralSubtractInsn(ga, b.left(), b.right());

                debugPrintLine(mw, addType);
            }
        }
    }

    private void GenerateBinaryMultiplication(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.operation().equals(Operation.multiply)) {

                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                pushIntegralType(ga, b.left());
                pushIntegralType(ga, b.right());
                IntegralType addType = pushIntigralMultiplyInsn(ga, b.left(), b.right());

                debugPrintLine(mw, addType);
            }
        }
    }

    private void GenerateBinaryDivision(Node root, MethodVisitor mw, GeneratorAdapter ga) {
        if (root instanceof BinaryNode){
            BinaryNode b = ((BinaryNode)root);

            if (b.operation().equals(Operation.divide)) {

                if (debug) {
                    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                }

                pushIntegralType(ga, b.left());
                pushIntegralType(ga, b.right());
                IntegralType addType = pushIntigralDivideInsn(ga, b.left(), b.right());

                debugPrintLine(mw, addType);
            }
        }
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

    private void pushIntegralType(GeneratorAdapter ga, Node node) {
        if (node instanceof IntegralTypeNode) {
            IntegralTypeNode integralTypeNode = ((IntegralTypeNode)node);
            IntegralType integralType = integralTypeNode.getIntegralType();

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

    private IntegralType pushIntigralAddInsn(GeneratorAdapter ga , Node left, Node right){

        IntegralTypeNode ln = (IntegralTypeNode)left;
        IntegralTypeNode rn = (IntegralTypeNode)right;

        if (ln.getIntegralType() == IntegralType.jdouble || rn.getIntegralType() == IntegralType.jdouble){
            ga.visitInsn(DADD);
            return IntegralType.jdouble;
        } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
            ga.visitInsn(FADD);
            return IntegralType.jfloat;
        } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
            ga.visitInsn(IADD);
            return IntegralType.jinteger;
        } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
            ga.visitInsn(LADD);
            return IntegralType.jlong;
        }

        return null;
    }


    private IntegralType pushIntigralSubtractInsn(GeneratorAdapter ga , Node left, Node right){

        IntegralTypeNode ln = (IntegralTypeNode)left;
        IntegralTypeNode rn = (IntegralTypeNode)right;

        if (ln.getIntegralType() == IntegralType.jdouble || rn.getIntegralType() == IntegralType.jdouble){
            ga.visitInsn(DSUB);
            return IntegralType.jdouble;
        } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
            ga.visitInsn(FSUB);
            return IntegralType.jfloat;
        } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
            ga.visitInsn(ISUB);
            return IntegralType.jinteger;
        } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
            ga.visitInsn(LSUB);
            return IntegralType.jlong;
        }

        return null;
    }

    private IntegralType pushIntigralMultiplyInsn(GeneratorAdapter ga , Node left, Node right){

        IntegralTypeNode ln = (IntegralTypeNode)left;
        IntegralTypeNode rn = (IntegralTypeNode)right;

        if (ln.getIntegralType() == IntegralType.jdouble || rn.getIntegralType() == IntegralType.jdouble){
            ga.visitInsn(DMUL);
            return IntegralType.jdouble;
        } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
            ga.visitInsn(FMUL);
            return IntegralType.jfloat;
        } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
            ga.visitInsn(IMUL);
            return IntegralType.jinteger;
        } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
            ga.visitInsn(LMUL);
            return IntegralType.jlong;
        }

        return null;
    }

    private IntegralType pushIntigralDivideInsn(GeneratorAdapter ga , Node left, Node right){

        IntegralTypeNode ln = (IntegralTypeNode)left;
        IntegralTypeNode rn = (IntegralTypeNode)right;

        if (ln.getIntegralType() == IntegralType.jdouble || rn.getIntegralType() == IntegralType.jdouble){
            ga.visitInsn(DDIV);
            return IntegralType.jdouble;
        } else if (ln.getIntegralType() == IntegralType.jfloat || rn.getIntegralType() == IntegralType.jfloat){
            ga.visitInsn(FDIV);
            return IntegralType.jfloat;
        } else if (ln.getIntegralType() == IntegralType.jinteger || rn.getIntegralType() == IntegralType.jinteger){
            ga.visitInsn(IDIV);
            return IntegralType.jinteger;
        } else if (ln.getIntegralType() == IntegralType.jlong || rn.getIntegralType() == IntegralType.jlong){
            ga.visitInsn(LDIV);
            return IntegralType.jlong;
        }

        return null;
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
                pushIntegralType( ga, integralTypeNode);
            }

            for(int i = 0; i < addCount; i++) {
                ga.visitInsn(IADD);
            }

            //mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(I)V", false);
        }
    }
}
