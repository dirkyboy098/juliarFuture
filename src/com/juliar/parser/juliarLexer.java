// Generated from /Users/donreamey/github/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.5.3
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
public class juliarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INT=2, FLOAT=3, STRING=4, ID=5, WS=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "INT", "FLOAT", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "INT", "FLOAT", "STRING", "ID", "WS"
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


	public juliarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "juliar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b9\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\6\3\23\n\3\r\3\16\3"+
		"\24\3\4\6\4\30\n\4\r\4\16\4\31\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\5\3"+
		"\5\7\5%\n\5\f\5\16\5(\13\5\3\5\3\5\3\6\3\6\7\6.\n\6\f\6\16\6\61\13\6\3"+
		"\7\6\7\64\n\7\r\7\16\7\65\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\7"+
		"\3\2\62;\7\2\"\"\62;C\\aac|\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\""+
		"\">\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\3\17\3\2\2\2\5\22\3\2\2\2\7\27\3\2\2\2\t\"\3\2\2\2\13+\3\2\2\2"+
		"\r\63\3\2\2\2\17\20\7,\2\2\20\4\3\2\2\2\21\23\t\2\2\2\22\21\3\2\2\2\23"+
		"\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\6\3\2\2\2\26\30\4\62;\2\27"+
		"\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33"+
		"\37\7\60\2\2\34\36\4\62;\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37"+
		" \3\2\2\2 \b\3\2\2\2!\37\3\2\2\2\"&\7$\2\2#%\t\3\2\2$#\3\2\2\2%(\3\2\2"+
		"\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7$\2\2*\n\3\2\2\2+/\t\4"+
		"\2\2,.\t\5\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\f\3\2\2"+
		"\2\61/\3\2\2\2\62\64\t\6\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\66\67\3\2\2\2\678\b\7\2\28\16\3\2\2\2\t\2\24\31\37&/\65"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}