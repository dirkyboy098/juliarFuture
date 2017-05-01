package com.juliar.interpreter;

import com.juliar.nodes.CompliationUnitNode;
import com.juliar.nodes.Node;

import java.io.*;
import java.util.List;

/**
 * Created by donre on 4/28/2017.
 */
public class ReadWriteBinaryFile {

    public void write(String inputFile, List<Node> instructions) {
        String fileName = getLibiraryName(inputFile);

        FileOutputStream ostream = null;
        try {
            ostream = new FileOutputStream(fileName);
            ObjectOutputStream p = new ObjectOutputStream(ostream);
            instructions.get(0).writeNode(p);
            p.flush();
            ostream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void read(String inputFile) {
        String libName = getLibiraryName( inputFile );

        try (FileInputStream istream = new FileInputStream( libName )) {
            ObjectInputStream s = new ObjectInputStream(istream);
            CompliationUnitNode node = new CompliationUnitNode();
            node.readObject( s );
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
