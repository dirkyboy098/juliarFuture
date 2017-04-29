package com.juliar.interpreter;

import com.juliar.nodes.Node;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by donre on 4/28/2017.
 */
public class ReadWriteBinaryFile {

    public void write(String inputFile, List<Node> instructions){

        FileOutputStream ostream = null;
        try {
            ostream = new FileOutputStream("t.txt");
            ObjectOutputStream p = new ObjectOutputStream(ostream);
            instructions.get(0).writeNode( p );
            p.flush();
            ostream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


            /*
            FileInputStream istream = new FileInputStream("t.txt");
            ObjectInputStream s = new ObjectInputStream(istream);
            inst.get(0).readType( s );
            */
    }
}
