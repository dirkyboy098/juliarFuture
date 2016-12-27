package com.juliar.juliarRepl;

import com.juliar.JuliarCompiler;
import com.nire4j.repl.*;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by donreamey on 11/10/16.
 */
public class jRepl extends replTerminal {
    public static void main(String[] args) {
        if (args[0]!=null && (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false"))) {
            replTerminal r = new jRepl(Boolean.parseBoolean(args[0]));
        }
        else {
            new jRepl(true);
        }
    }
    public jRepl() {
        super();
    }

    public jRepl(boolean isDebug) {
        super(isDebug);
    }

    @Override
    public void printStartUpMessage() {

    }

    @Override
    public List<String> repl(ByteArrayInputStream byteArrayInputStream) {
        JuliarCompiler jc = new JuliarCompiler();
        return jc.compile(byteArrayInputStream, "", true);
    }

    @Override
    public void printEndMessage() {

    }
}
