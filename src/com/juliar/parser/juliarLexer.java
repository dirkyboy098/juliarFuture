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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INT=12, FLOAT=13, DOUBLE=14, LONG=15, STRING=16, ID=17, 
		WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'if'", "'('", "')'", "'{'", "'}'", "'+'", "'add'", "'-'", 
		"'='", "'=='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\6\rC\n\r\r\r"+
		"\16\rD\3\16\6\16H\n\16\r\16\16\16I\3\16\3\16\7\16N\n\16\f\16\16\16Q\13"+
		"\16\3\17\6\17T\n\17\r\17\16\17U\3\17\3\17\7\17Z\n\17\f\17\16\17]\13\17"+
		"\3\20\6\20`\n\20\r\20\16\20a\3\20\3\20\7\20f\n\20\f\20\16\20i\13\20\3"+
		"\21\3\21\7\21m\n\21\f\21\16\21p\13\21\3\21\3\21\3\22\3\22\7\22v\n\22\f"+
		"\22\16\22y\13\22\3\23\6\23|\n\23\r\23\16\23}\3\23\3\23\2\2\24\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\3\2\7\3\2\62;\7\2\"\"\62;C\\aac|\5\2C\\aac|\7\2//\62;C\\aac|"+
		"\5\2\13\f\17\17\"\"\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7,\3\2"+
		"\2\2\t.\3\2\2\2\13\60\3\2\2\2\r\62\3\2\2\2\17\64\3\2\2\2\21\66\3\2\2\2"+
		"\23:\3\2\2\2\25<\3\2\2\2\27>\3\2\2\2\31B\3\2\2\2\33G\3\2\2\2\35S\3\2\2"+
		"\2\37_\3\2\2\2!j\3\2\2\2#s\3\2\2\2%{\3\2\2\2\'(\7,\2\2(\4\3\2\2\2)*\7"+
		"k\2\2*+\7h\2\2+\6\3\2\2\2,-\7*\2\2-\b\3\2\2\2./\7+\2\2/\n\3\2\2\2\60\61"+
		"\7}\2\2\61\f\3\2\2\2\62\63\7\177\2\2\63\16\3\2\2\2\64\65\7-\2\2\65\20"+
		"\3\2\2\2\66\67\7c\2\2\678\7f\2\289\7f\2\29\22\3\2\2\2:;\7/\2\2;\24\3\2"+
		"\2\2<=\7?\2\2=\26\3\2\2\2>?\7?\2\2?@\7?\2\2@\30\3\2\2\2AC\t\2\2\2BA\3"+
		"\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\32\3\2\2\2FH\4\62;\2GF\3\2\2\2H"+
		"I\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KO\7\60\2\2LN\4\62;\2ML\3\2\2\2"+
		"NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\34\3\2\2\2QO\3\2\2\2RT\4\62;\2SR\3\2\2"+
		"\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2W[\7\60\2\2XZ\4\62;\2YX\3\2"+
		"\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\36\3\2\2\2][\3\2\2\2^`\4\62;\2_"+
		"^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cg\7\60\2\2df\4\62;\2"+
		"ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h \3\2\2\2ig\3\2\2\2jn\7$\2\2"+
		"km\t\3\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2"+
		"qr\7$\2\2r\"\3\2\2\2sw\t\4\2\2tv\t\5\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2"+
		"wx\3\2\2\2x$\3\2\2\2yw\3\2\2\2z|\t\6\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2"+
		"}~\3\2\2\2~\177\3\2\2\2\177\u0080\b\23\2\2\u0080&\3\2\2\2\r\2DIOU[agn"+
		"w}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}