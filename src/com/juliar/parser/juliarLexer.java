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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT=6, FLOAT=7, DOUBLE=8, LONG=9, 
		STRING=10, ID=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "INT", "FLOAT", "DOUBLE", "LONG", 
		"STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'+'", "'add'", "'-'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "INT", "FLOAT", "DOUBLE", "LONG", 
		"STRING", "ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16g\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\6\7)\n\7\r\7\16\7*\3\b\6\b.\n\b\r\b\16\b/\3\b\3\b\7\b\64\n\b\f\b\16"+
		"\b\67\13\b\3\t\6\t:\n\t\r\t\16\t;\3\t\3\t\7\t@\n\t\f\t\16\tC\13\t\3\n"+
		"\6\nF\n\n\r\n\16\nG\3\n\3\n\7\nL\n\n\f\n\16\nO\13\n\3\13\3\13\7\13S\n"+
		"\13\f\13\16\13V\13\13\3\13\3\13\3\f\3\f\7\f\\\n\f\f\f\16\f_\13\f\3\r\6"+
		"\rb\n\r\r\r\16\rc\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\3\2\7\3\2\62;\7\2\"\"\62;C\\aac|\5\2C\\aac|\7\2//"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"p\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35\3\2\2\2"+
		"\7\37\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r(\3\2\2\2\17-\3\2\2\2\219\3\2\2"+
		"\2\23E\3\2\2\2\25P\3\2\2\2\27Y\3\2\2\2\31a\3\2\2\2\33\34\7,\2\2\34\4\3"+
		"\2\2\2\35\36\7-\2\2\36\6\3\2\2\2\37 \7c\2\2 !\7f\2\2!\"\7f\2\2\"\b\3\2"+
		"\2\2#$\7/\2\2$\n\3\2\2\2%&\7?\2\2&\f\3\2\2\2\')\t\2\2\2(\'\3\2\2\2)*\3"+
		"\2\2\2*(\3\2\2\2*+\3\2\2\2+\16\3\2\2\2,.\4\62;\2-,\3\2\2\2./\3\2\2\2/"+
		"-\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\65\7\60\2\2\62\64\4\62;\2\63\62"+
		"\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\20\3\2\2\2\67\65"+
		"\3\2\2\28:\4\62;\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2="+
		"A\7\60\2\2>@\4\62;\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\22\3\2\2"+
		"\2CA\3\2\2\2DF\4\62;\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2"+
		"\2IM\7\60\2\2JL\4\62;\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\24\3"+
		"\2\2\2OM\3\2\2\2PT\7$\2\2QS\t\3\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3"+
		"\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7$\2\2X\26\3\2\2\2Y]\t\4\2\2Z\\\t\5\2\2["+
		"Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\30\3\2\2\2_]\3\2\2\2`b\t\6\2"+
		"\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\b\r\2\2f\32\3\2"+
		"\2\2\r\2*/\65;AGMT]c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}