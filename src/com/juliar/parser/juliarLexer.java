// Generated from src/com/juliar/parser/juliar.g4 by ANTLR 4.5.3
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
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, FLOAT=6, DOUBLE=7, LONG=8, STRING=9, 
		ID=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", 
		"ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'+'", "'add'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "INT", "FLOAT", "DOUBLE", "LONG", "STRING", 
		"ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rc\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\6\6%\n\6\r\6\16"+
		"\6&\3\7\6\7*\n\7\r\7\16\7+\3\7\3\7\7\7\60\n\7\f\7\16\7\63\13\7\3\b\6\b"+
		"\66\n\b\r\b\16\b\67\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\t\6\tB\n\t\r\t\16"+
		"\tC\3\t\3\t\7\tH\n\t\f\t\16\tK\13\t\3\n\3\n\7\nO\n\n\f\n\16\nR\13\n\3"+
		"\n\3\n\3\13\3\13\7\13X\n\13\f\13\16\13[\13\13\3\f\6\f^\n\f\r\f\16\f_\3"+
		"\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\7"+
		"\3\2\62;\7\2\"\"\62;C\\aac|\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"l\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t!\3\2\2\2\13$\3\2\2\2\r)"+
		"\3\2\2\2\17\65\3\2\2\2\21A\3\2\2\2\23L\3\2\2\2\25U\3\2\2\2\27]\3\2\2\2"+
		"\31\32\7,\2\2\32\4\3\2\2\2\33\34\7-\2\2\34\6\3\2\2\2\35\36\7c\2\2\36\37"+
		"\7f\2\2\37 \7f\2\2 \b\3\2\2\2!\"\7/\2\2\"\n\3\2\2\2#%\t\2\2\2$#\3\2\2"+
		"\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\f\3\2\2\2(*\4\62;\2)(\3\2\2\2*+\3"+
		"\2\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-\61\7\60\2\2.\60\4\62;\2/.\3\2\2"+
		"\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\16\3\2\2\2\63\61\3\2\2\2"+
		"\64\66\4\62;\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28"+
		"9\3\2\2\29=\7\60\2\2:<\4\62;\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">\20\3\2\2\2?=\3\2\2\2@B\4\62;\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2"+
		"\2DE\3\2\2\2EI\7\60\2\2FH\4\62;\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2J\22\3\2\2\2KI\3\2\2\2LP\7$\2\2MO\t\3\2\2NM\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7$\2\2T\24\3\2\2\2UY\t\4\2\2VX"+
		"\t\5\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\26\3\2\2\2[Y\3\2\2\2"+
		"\\^\t\6\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\b\f\2"+
		"\2b\30\3\2\2\2\r\2&+\61\67=CIPY_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}