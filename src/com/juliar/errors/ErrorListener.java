package com.juliar.errors;

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Don on 10/28/2016.
 */
public class ErrorListener extends BaseErrorListener {

    private List<String> errorList = new ArrayList<>();
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String errorMessage = "("+line+","+charPositionInLine+") error on line " + line +" at column "+ charPositionInLine +" " +msg;
        errorList.add(errorMessage);
        Object context = ((Parser)recognizer).getRuleInvocationStack();
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    }

    public List<String> ErrorList(){
        return errorList;
    }
}
