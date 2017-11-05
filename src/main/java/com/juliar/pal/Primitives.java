package com.juliar.pal;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.juliar.errors.Logger;
/**
 * platform abstraction layer.
 */
public class Primitives {
    public static String sysFileOpen(String path) {
        path = stripQuotes( path );
        try {
            int read = 1024;
            int N = 1024 * read;
            char[] buffer = new char[N];
            StringBuilder text = new StringBuilder();

            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (true) {
                read = bufferedReader.read(buffer, 0, N);
                text.append(new String(buffer, 0, read));

                if (read < N) {
                    break;
                }
            }

            return text.toString();

        } catch (Exception fne) {
           Logger.log(fne.getMessage());
        }

        return "";
    }

    public static String sysExec(String execString){
        String command = "/bin/sh";
        String param = "-c";
        if(System.getProperty("os.name").toLowerCase().contains("win")) {
            command = "cmd.exe";
            param = "/C";
        }
        ProcessBuilder builder = new ProcessBuilder(command, param, execString);
        builder.redirectErrorStream(true);
        try {
            Process process = builder.start();
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            StringBuilder output =new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append(System.getProperty("line.separator"));
            }
            return output.toString();
        }
        catch (Exception e){
            return "";
        }
    }

    public static void sysFileWrite(String path) {
        try{
            List<String> lines = Arrays.asList("Test Line 1", "Test Line 2");
            Path file = Paths.get("the-file-name.txt");
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            Logger.log(e.getMessage() + " sysFileWrite error");
        }
    }

    public static void sysPrintLine(String string) {
        System.out.println(stripQuotes(string));

    }

    public static void sysPrint(String string) {
        System.out.print(stripQuotes(string));
    }

    public static String stripQuotes( String s){
        if (s.startsWith("\"") && s.endsWith("\"") ||
                s.startsWith("'") && s.endsWith("'") ||
                s.startsWith("`") && s.endsWith("`")) {
            if (s.length()==1){
                return s;
            }
            return (s.substring(1, s.length()-1));
        }

        return s;
    }

    public static long sysAvailableMemory() {
        Runtime rt = Runtime.getRuntime();
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        long freeMemory = total- free;

        return freeMemory;
    }

    public static char[] sysGetByteFromString(String s){
        return s.toCharArray();
    }
}
