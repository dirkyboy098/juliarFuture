package com.juliar.errors;

import org.antlr.v4.runtime.*;

/**
 * Created by Don on 10/28/2016.
 */
public class ErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        Object context = ((Parser)recognizer).getRuleInvocationStack();
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    }
}
