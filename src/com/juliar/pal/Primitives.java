package com.juliar.pal;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * platform abstraction layer.
 */
public class Primitives {
    public static void sys_file_open(String path) {
        try {
            int read = 1024;
            int N = 1024 * read;
            System.out.println("Reading file "+ path);
            char[] buffer = new char[N];
            String text = "";

            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (true) {
                read = bufferedReader.read(buffer, 0, N);
                text += new String(buffer, 0, read);

                if (read < N) {
                    break;
                }
            }

        } catch (Exception fne) {
            System.out.println(fne.getMessage());
        }
    }

    public static void sys_file_write(String path){}

    //public static void sys_
}
