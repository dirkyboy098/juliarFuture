package com.juliar.gui;

import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AndreiM on 5/20/2017.
 */
class Highlighter {
    private static final String[] KEYWORDS = new String[] {
            "break",
            "class",
            "double",
            "else",
            "float",
            "for",
            "function",
            "int",
            "if",
            "return",
            "string",
            "while",
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "[()]";
    private static final String BRACE_PATTERN = "[{}]";
    private static final String BRACKET_PATTERN = "[\\[]]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*(\"|$)";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static String calculateStyle(Matcher matcher){
        if(matcher.group("KEYWORD") != null) return "keyword";
        else if(matcher.group("PAREN") != null)  return "paren";
        else if(matcher.group("BRACE") != null) return "brace";
        else if(matcher.group("BRACKET") != null) return "bracket";
        else if(matcher.group("SEMICOLON") != null) return "semicolon";
        else if(matcher.group("STRING") != null) return "string";
        else if(matcher.group("COMMENT") != null) return "comment";
        return null;
    }

    public static StyleSpans<Collection<String>> getHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass = calculateStyle(matcher);
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    private Highlighter() {
        throw new IllegalStateException("Highlighter");
    }
}
