package com.juliar.juliarrepl;

import com.nire4j.repl.*;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by donreamey on 11/10/16.
 */
public class JRepl extends replTerminal {
    public static void main(String[] args) {
        if (args[0]!=null && (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false"))) {
            new JRepl(Boolean.parseBoolean(args[0]));
        }
        else {
            new JRepl(true);
        }
    }
    public JRepl() {
        super();
    }

    public JRepl(boolean isDebug) {
        super(isDebug);
    }

    @Override
    public void printStartUpMessage() {
        //TODO Nothing?
    }

    @Override
    public List<String> repl(ByteArrayInputStream byteArrayInputStream) {
        return null;
    }

    @Override
    public void printEndMessage() {
        //TODO Nothing?
    }
}
