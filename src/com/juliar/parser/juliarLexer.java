// Generated from C:\Users\AndreiM\Desktop\juliarFuture\src\com\juliar\parser\juliar.g4 by ANTLR 4.5.3
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INT=20, FLOAT=21, DOUBLE=22, LONG=23, STRING=24, ID=25, 
		WS=26, COMMENT=27, LINE_COMMENT=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS", 
		"COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'if'", "'('", "')'", "'{'", "'}'", "'nif'", "'+'", "'add'", 
		"'-'", "'subtract'", "'x'", "'multiply'", "'/'", "'divide'", "'='", "'=='", 
		"'fileOpen'", "'printLine'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "INT", "FLOAT", "DOUBLE", 
		"LONG", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00e5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u008b"+
		"\n\25\r\25\16\25\u008c\3\26\6\26\u0090\n\26\r\26\16\26\u0091\3\26\3\26"+
		"\7\26\u0096\n\26\f\26\16\26\u0099\13\26\3\27\6\27\u009c\n\27\r\27\16\27"+
		"\u009d\3\27\3\27\7\27\u00a2\n\27\f\27\16\27\u00a5\13\27\3\30\6\30\u00a8"+
		"\n\30\r\30\16\30\u00a9\3\30\3\30\7\30\u00ae\n\30\f\30\16\30\u00b1\13\30"+
		"\3\31\3\31\7\31\u00b5\n\31\f\31\16\31\u00b8\13\31\3\31\3\31\3\32\3\32"+
		"\7\32\u00be\n\32\f\32\16\32\u00c1\13\32\3\33\6\33\u00c4\n\33\r\33\16\33"+
		"\u00c5\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u00cf\n\34\f\34\16\34\u00d2"+
		"\13\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00dd\n\35\f"+
		"\35\16\35\u00e0\13\35\3\35\3\35\3\35\3\35\4\u00d0\u00de\2\36\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\7\3\2\62"+
		";\t\2\"\"\60\60\62<C\\^^aac|\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"\u00f1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\3;\3\2\2\2\5=\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2"+
		"\2\17H\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31]\3\2"+
		"\2\2\33_\3\2\2\2\35h\3\2\2\2\37j\3\2\2\2!q\3\2\2\2#s\3\2\2\2%v\3\2\2\2"+
		"\'\177\3\2\2\2)\u008a\3\2\2\2+\u008f\3\2\2\2-\u009b\3\2\2\2/\u00a7\3\2"+
		"\2\2\61\u00b2\3\2\2\2\63\u00bb\3\2\2\2\65\u00c3\3\2\2\2\67\u00c9\3\2\2"+
		"\29\u00d8\3\2\2\2;<\7=\2\2<\4\3\2\2\2=>\7k\2\2>?\7h\2\2?\6\3\2\2\2@A\7"+
		"*\2\2A\b\3\2\2\2BC\7+\2\2C\n\3\2\2\2DE\7}\2\2E\f\3\2\2\2FG\7\177\2\2G"+
		"\16\3\2\2\2HI\7p\2\2IJ\7k\2\2JK\7h\2\2K\20\3\2\2\2LM\7-\2\2M\22\3\2\2"+
		"\2NO\7c\2\2OP\7f\2\2PQ\7f\2\2Q\24\3\2\2\2RS\7/\2\2S\26\3\2\2\2TU\7u\2"+
		"\2UV\7w\2\2VW\7d\2\2WX\7v\2\2XY\7t\2\2YZ\7c\2\2Z[\7e\2\2[\\\7v\2\2\\\30"+
		"\3\2\2\2]^\7z\2\2^\32\3\2\2\2_`\7o\2\2`a\7w\2\2ab\7n\2\2bc\7v\2\2cd\7"+
		"k\2\2de\7r\2\2ef\7n\2\2fg\7{\2\2g\34\3\2\2\2hi\7\61\2\2i\36\3\2\2\2jk"+
		"\7f\2\2kl\7k\2\2lm\7x\2\2mn\7k\2\2no\7f\2\2op\7g\2\2p \3\2\2\2qr\7?\2"+
		"\2r\"\3\2\2\2st\7?\2\2tu\7?\2\2u$\3\2\2\2vw\7h\2\2wx\7k\2\2xy\7n\2\2y"+
		"z\7g\2\2z{\7Q\2\2{|\7r\2\2|}\7g\2\2}~\7p\2\2~&\3\2\2\2\177\u0080\7r\2"+
		"\2\u0080\u0081\7t\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7N\2\2\u0085\u0086\7k\2\2\u0086\u0087\7p\2\2\u0087"+
		"\u0088\7g\2\2\u0088(\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d*\3\2\2\2"+
		"\u008e\u0090\4\62;\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097\7\60\2\2"+
		"\u0094\u0096\4\62;\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098,\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009c\4\62;\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\7\60\2\2\u00a0"+
		"\u00a2\4\62;\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4.\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8"+
		"\4\62;\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00af\7\60\2\2\u00ac\u00ae\4"+
		"\62;\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\60\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b6\7$\2\2"+
		"\u00b3\u00b5\t\3\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00ba\7$\2\2\u00ba\62\3\2\2\2\u00bb\u00bf\t\4\2\2\u00bc\u00be\t\5\2\2"+
		"\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0"+
		"\3\2\2\2\u00c0\64\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\t\6\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\33\2\2\u00c8\66\3\2\2\2\u00c9\u00ca"+
		"\7\61\2\2\u00ca\u00cb\7,\2\2\u00cb\u00d0\3\2\2\2\u00cc\u00cf\5\67\34\2"+
		"\u00cd\u00cf\13\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d7\b\34\3\2\u00d78\3\2\2\2\u00d8\u00d9\7\61\2\2\u00d9\u00da"+
		"\7\61\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\13\2\2\2\u00dc\u00db\3\2\2\2"+
		"\u00dd\u00e0\3\2\2\2\u00de\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e1"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\f\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\b\35\3\2\u00e4:\3\2\2\2\20\2\u008c\u0091\u0097\u009d\u00a3\u00a9"+
		"\u00af\u00b6\u00bf\u00c5\u00ce\u00d0\u00de\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}