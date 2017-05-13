package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;

import java.io.*;

/**
 * Created by donre on 4/28/2017.
 */
public class ReadWriteBinaryFile {

    public void write(String inputFile, InstructionInvocation invocation) {
        String fileName = getLibiraryName(inputFile);

        FileOutputStream ostream = null;
        try {
            ostream = new FileOutputStream(fileName);
            ObjectOutputStream p = new ObjectOutputStream(ostream);
            p.writeObject( invocation );
            p.flush();
            ostream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public InstructionInvocation read(String inputFile) {
        String libName = getLibiraryName( inputFile );
        InstructionInvocation invocation = null;
        Object object = null;

        try (FileInputStream istream = new FileInputStream( libName )) {
            ObjectInputStream s = new ObjectInputStream(istream);

            object = s.readObject();
            if ( object instanceof InstructionInvocation ){
                invocation = (InstructionInvocation) object;
            }

            s.close();
            istream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }

        return invocation;
    }


    private String getLibiraryName(String inputFile) {
        String fileName = inputFile;
        char[] pathSeperator = new char[]{File.pathSeparatorChar};

        if (fileName.contains(new String(pathSeperator))) {
            int lastIndexOf = fileName.lastIndexOf(pathSeperator[0]);
            fileName = fileName.substring(lastIndexOf);
        }

        int extensionIndex = fileName.lastIndexOf('.');
        fileName = fileName.substring(0, extensionIndex);

        if (fileName != null) {
            fileName += ".lib";
        }
        return fileName;
    }
}
