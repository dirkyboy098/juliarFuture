package com.juliar.interpreter;

import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.Logger;

import java.io.*;

/**
 * Created by donre on 4/28/2017.
 */
public class ReadWriteBinaryFile {

    public void write(String inputFile, InstructionInvocation invocation) throws IOException {
        String fileName = getLibiraryName(inputFile);

        try (
            OutputStream ostream = new FileOutputStream(fileName);
            ObjectOutputStream p = new ObjectOutputStream(ostream)
        ) {
            p.writeObject( invocation );
            p.flush();
        } catch (IOException e) {
            Logger.log(e);
        }
    }

    public InstructionInvocation read(String inputFile) {
        String libName = getLibiraryName( inputFile );
        InstructionInvocation invocation = null;
        Object object = null;

        try (
            FileInputStream istream = new FileInputStream( libName );
            ObjectInputStream s = new ObjectInputStream(istream)
        ) {
            object = s.readObject();
            if ( object instanceof InstructionInvocation ){
                invocation = (InstructionInvocation) object;
            }
        } catch (IOException|ClassNotFoundException e){
            Logger.log(e);
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
