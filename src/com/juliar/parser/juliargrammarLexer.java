// Generated from juliargrammar.g4 by ANTLR 4.5.3
package com.juliar.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class juliargrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, FLOAT=6, STRING=7, ID=8, WS=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "INT", "FLOAT", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'absolute'", "'acos'", "'acosh'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "INT", "FLOAT", "STRING", "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public juliargrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "juliargrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13S\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\6\6-\n\6\r\6\16\6.\3\7\6\7\62\n\7\r\7\16\7\63\3\7\3\7\7"+
		"\78\n\7\f\7\16\7;\13\7\3\b\3\b\7\b?\n\b\f\b\16\bB\13\b\3\b\3\b\3\t\3\t"+
		"\7\tH\n\t\f\t\16\tK\13\t\3\n\6\nN\n\n\r\n\16\nO\3\n\3\n\2\2\13\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\7\3\2\62;\7\2\"\"\62;C\\aac|\5\2"+
		"C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"X\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7 \3\2\2\2\t%\3\2\2\2\13,\3"+
		"\2\2\2\r\61\3\2\2\2\17<\3\2\2\2\21E\3\2\2\2\23M\3\2\2\2\25\26\7,\2\2\26"+
		"\4\3\2\2\2\27\30\7c\2\2\30\31\7d\2\2\31\32\7u\2\2\32\33\7q\2\2\33\34\7"+
		"n\2\2\34\35\7w\2\2\35\36\7v\2\2\36\37\7g\2\2\37\6\3\2\2\2 !\7c\2\2!\""+
		"\7e\2\2\"#\7q\2\2#$\7u\2\2$\b\3\2\2\2%&\7c\2\2&\'\7e\2\2\'(\7q\2\2()\7"+
		"u\2\2)*\7j\2\2*\n\3\2\2\2+-\t\2\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3"+
		"\2\2\2/\f\3\2\2\2\60\62\4\62;\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\65\3\2\2\2\659\7\60\2\2\668\4\62;\2\67\66\3\2\2"+
		"\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\16\3\2\2\2;9\3\2\2\2<@\7$\2\2=?\t"+
		"\3\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7"+
		"$\2\2D\20\3\2\2\2EI\t\4\2\2FH\t\5\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2J\22\3\2\2\2KI\3\2\2\2LN\t\6\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2"+
		"OP\3\2\2\2PQ\3\2\2\2QR\b\n\2\2R\24\3\2\2\2\t\2.\639@IO\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}