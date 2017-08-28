package com.juliar.juliarrepl;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by donreamey on 11/10/16.
 */

public class JRepl {
    protected boolean isDebug;
    public static void main(String[] args) {
        if (args[0]!=null && (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false"))) {
            new JRepl(Boolean.parseBoolean(args[0]));
        }
        else {
            new JRepl(true);
        }
    }

    public JRepl() {
    }

    public JRepl(boolean isDebug) {
        try {
            this.printStartUpMessage();

            while(true) {
                byte[] line = new byte[254];
                System.out.print(":>");
                int i = System.in.read(line);
                String s = (new String(line)).trim();
                if (s.toLowerCase().equals("quit") || s.toLowerCase().equals("q")) {
                    this.printEndMessage();
                    break;
                }

                byte[] updated = Arrays.copyOf(line, s.length());
                ByteArrayInputStream byteStream = new ByteArrayInputStream(updated);
                List<String> errors = this.repl(byteStream);
                Iterator i$ = errors.iterator();

                while(i$.hasNext()) {
                    String error = (String)i$.next();
                    System.out.println(error);
                }
            }
        } catch (Exception var10) {
            System.out.println(var10.getMessage());
        }

    }

    public void printStartUpMessage() {
        //TODO Nothing?
    }

    public List<String> repl(ByteArrayInputStream byteArrayInputStream) {
        return Collections.emptyList();
    }

    public void printEndMessage() {
        //TODO Nothing?
    }
}
