package com.juliar.codegenerator;

import com.juliar.errors.Logger;
import com.juliar.nodes.*;
import com.juliar.pal.Primitives;
import com.juliar.pal.PrimitivesMap;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.GeneratorAdapter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import static org.objectweb.asm.Opcodes.*;


/**
 * Created by donreamey on 10/22/16.
 */
public class CodeGenerator {
    private boolean isDebug = true;
    public CodeGenerator(boolean debug) {
        isDebug = debug;
    }

    public void generate(InstructionInvocation invocation, String outputfile) throws IOException {
        List<Node> inst = invocation.getInstructionList();
        generate(inst,outputfile);
    }

    public void generate(List<Node> instructions, String outputfile) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_1, ACC_PUBLIC, outputfile, null, "java/lang/Object", null);

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
        //mw.visitInsn(RETURN);
        // this code uses a maximum of two stack elements and two local
        // variables
        //mw.visitVarInsn(ALOAD,0);
        mw.visitMethodInsn(INVOKESTATIC, outputfile, "juliarMethod", "()V", false);
        mw.visitInsn(RETURN);

        mw.visitMaxs(2, 2);
        mw.visitEnd();

        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "juliarMethod", "()V", null, null);

        Integer stackSize = 0;
        GeneratorAdapter ga = new GeneratorAdapter(mw, ACC_PUBLIC + ACC_STATIC, "juliarMethod", "()V");
        evaluateExpressions(instructions, mw, ga, stackSize);



        mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");
        mw.visitLdcInsn("Instructions:"+instructions);
        mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println","(Ljava/lang/String;)V", false);


        mw.visitInsn(RETURN);
        mw.visitMaxs(16, 6);
        mw.visitEnd();

        /*MethodVisitor foo = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "foo", "()V", null, null);

        GeneratorAdapter ga1 = new GeneratorAdapter(foo, ACC_PUBLIC + ACC_STATIC, "foo", "()V");
        foo.visitInsn(RETURN);
        foo.visitEnd();*/


        // gets the bytecode of the Example class, and loads it dynamically
        byte[] code = cw.toByteArray();

        //Create JAR output
        FileOutputStream fout = new FileOutputStream(outputfile+".jar");

        Manifest manifest = new Manifest();
        manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
        manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, outputfile);

        JarOutputStream jarOut = new JarOutputStream(fout, manifest);

        try {
            jarOut.putNextEntry(new ZipEntry("com/juliar/pal/Primitives.class"));
            InputStream primitiveStream = Primitives.class.getResourceAsStream("Primitives.class");
            jarOut.write(getBytes(primitiveStream));
            jarOut.closeEntry();

            jarOut.putNextEntry(new ZipEntry(outputfile+".class"));
            jarOut.write(code);
            jarOut.closeEntry();
        } catch(Exception e){
            Logger.log(e);
        }
        jarOut.close();
        fout.close();


        /*
        List<String> Dependencies = SomeClass.getDependencies();
        FileOutputStream fout = new FileOutputStream(outputfile+".jar");

        JarOutputStream jarOut = new JarOutputStream(fout);

        //jarOut.putNextEntry(new ZipEntry("com/juliar/pal")); // Folders must end with "/".
        //jarOut.putNextEntry(new ZipEntry("com/juliar/pal/Primitives.class"));
        //jarOut.write(getBytes("com/juliar/pal/Primitives.class"));
        //jarOut.closeEntry();

        jarOut.putNextEntry(new ZipEntry(outputfile+".class"));
        jarOut.write(getBytes(outputfile+".class"));
        jarOut.closeEntry();

        for(String dependency : Dependencies){
            int index = dependency.lastIndexOf( '/' );
            jarOut.putNextEntry(new ZipEntry(dependency.substring( index ))); // Folders must end with "/".
            jarOut.putNextEntry(new ZipEntry(dependency));
            jarOut.write(getBytes(dependency));
            jarOut.closeEntry();
        }


        jarOut.close();

        fout.close();*/
    }

    private MethodVisitor evaluateExpressions(List<Node> instructions, MethodVisitor mw, GeneratorAdapter ga, Integer stackSize ){
        Logger.log("x");
        for(Node instruction : instructions) {
            Logger.log("Instructions");
            Logger.log(instruction.getNodeName().toString());
            if( instruction instanceof FunctionDeclNode){
                List<Node> t = instruction.getInstructions();
                evaluateExpressions(t, mw, ga, stackSize);
            }
            if ( instruction instanceof PrimitiveNode){
                String function = ((PrimitiveNode) instruction).getPrimitiveName().toString();
                Logger.log(function);

                function = PrimitivesMap.getFunction(function);
                mw.visitLdcInsn(((PrimitiveNode) instruction).getGetPrimitiveArgument().toString());
                mw.visitIntInsn(ASTORE, 0);
                mw.visitIntInsn(ALOAD, 0);
                mw.visitMethodInsn(
                        INVOKESTATIC,
                        "com/juliar/pal/Primitives",
                        function,
                        "(Ljava/lang/String;)Ljava/lang/String;",
                        false);


                if ("printLine".equals(function)){
                    function = "sysPrintLine";
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

                if ("print".equals(function)){
                    function = "sysPrint";
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
                //WWLogger.log(((CompliationUnitNode) instructions).getInstructions().toString());
                /*Logger.og(t.toString());
                 */

                List<Node> t = instruction.getInstructions();
                evaluateExpressions(t, mw, ga, stackSize);

                /*for (List<Node> n : t) {
                    Logger.log(n.getNodeName().toString());
                    Logger.log("HERE");
                    evaluateExpressions(n, mw, ga, stackSize);
                }*/
            }

            if (instruction instanceof StatementNode) {
                List<Node> t = instruction.getInstructions();
                evaluateExpressions(t, mw, ga, stackSize);
            }

            if (instruction instanceof BinaryNode){
                Logger.log("BinaryNode");
                Map<IntegralType,Integer> op = CodeGeneratorMap.generateMap(((BinaryNode)instruction).operation().toString());

                BinaryNode b = ((BinaryNode)instruction);
                if (isDebug) {
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
                ga.visitIntInsn(ISTORE, 1);
                pushIntegralType(ga, b.right(),addType);
                ga.visitIntInsn(ISTORE, 2);
                ga.visitIntInsn(ILOAD, 1);
                ga.visitIntInsn(ILOAD, 2);
                ga.visitInsn(op.get(addType));

                mw.visitIntInsn(ILOAD, 0);

                debugPrintLine(mw,addType);
            }

            if (instruction instanceof AggregateNode) {
                Logger.log("BinaryNode");
                Map<IntegralType,Integer> op = CodeGeneratorMap.generateMap(((AggregateNode)instruction).operation().toString());

                List<IntegralTypeNode> integralTypeNodes = ((AggregateNode)instruction).data();
                int addCount = integralTypeNodes.size() - 1;

                if (isDebug) {
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
                        default:
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
        if (isDebug) {
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
                default:
                    break;
            }
        }
    }

    private void pushIntegralType(GeneratorAdapter ga, Node node, IntegralType integralType) {
        if (node instanceof IntegralTypeNode) {
            IntegralTypeNode integralTypeNode = ((IntegralTypeNode)node);
            switch (integralType) {
                case jdouble:
     //               ga.push(Double.parseDouble(integralTypeNode.getIntegralValue()));
                    break;
                case jfloat:
     //               ga.push(Float.parseFloat(integralTypeNode.getIntegralValue()));
                    break;
                case jinteger:
    //                ga.push(Integer.parseInt(integralTypeNode.getIntegralValue()));
                    break;
                case jlong:
    //                ga.push(Long.parseLong(integralTypeNode.getIntegralValue()));
                    break;
                default:
                    break;
            }
        }
    }

    private static byte[] getBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
        {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = is.read(buffer)) != -1;)
                os.write(buffer, 0, len);
            os.flush();
            return os.toByteArray();
        }
    }
}
