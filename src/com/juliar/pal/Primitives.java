package com.juliar.pal;

import java.io.BufferedReader;
import java.io.FileReader;
import com.juliar.errors.PrintError;
/**
 * platform abstraction layer.
 */
public class Primitives {
    public static String sys_file_open(String path) {
        try {
            int read = 1024;
            int N = 1024 * read;
            System.out.println("Reading file " + path);
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

            return text;

        } catch (Exception fne) {
            new PrintError(fne.getMessage());
        }

        return "";
    }

    public static void sys_file_write(String path) {
    }

    public static void sys_print_line(String string) {
        System.out.println(string);
    }

    public static void sys_print(String string) {
        System.out.print(string);
    }

    public static void sys_available_memory() {
        Runtime rt = Runtime.getRuntime();
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        System.out.print(total - free);
    }
}
