// Generated from src/com/juliar/parser/juliar.g4 by ANTLR 4.6
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INT=21, FLOAT=22, DOUBLE=23, LONG=24, STRING=25, 
		ID=26, WS=27, COMMENT=28, LINE_COMMENT=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", 
		"ID", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'fileOpen'", "'('", "')'", "'printLine'", "'printInt'", 
		"'printFloat'", "'printDouble'", "'+'", "'add'", "'-'", "'subtract'", 
		"'='", "'=='", "'int'", "'float'", "'double'", "'long'", "'object'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "INT", "FLOAT", 
		"DOUBLE", "LONG", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u0108\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\6\26\u00ae\n\26"+
		"\r\26\16\26\u00af\3\27\6\27\u00b3\n\27\r\27\16\27\u00b4\3\27\3\27\7\27"+
		"\u00b9\n\27\f\27\16\27\u00bc\13\27\3\30\6\30\u00bf\n\30\r\30\16\30\u00c0"+
		"\3\30\3\30\7\30\u00c5\n\30\f\30\16\30\u00c8\13\30\3\31\6\31\u00cb\n\31"+
		"\r\31\16\31\u00cc\3\31\3\31\7\31\u00d1\n\31\f\31\16\31\u00d4\13\31\3\32"+
		"\3\32\7\32\u00d8\n\32\f\32\16\32\u00db\13\32\3\32\3\32\3\33\3\33\7\33"+
		"\u00e1\n\33\f\33\16\33\u00e4\13\33\3\34\6\34\u00e7\n\34\r\34\16\34\u00e8"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u00f2\n\35\f\35\16\35\u00f5\13"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u0100\n\36\f\36"+
		"\16\36\u0103\13\36\3\36\3\36\3\36\3\36\4\u00f3\u0101\2\37\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37\3\2\7\3\2\62"+
		";\t\2\"\"\60\60\62<C\\^^aac|\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"\u0114\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7H\3\2\2\2\tJ\3\2\2\2\13L\3\2\2"+
		"\2\rV\3\2\2\2\17_\3\2\2\2\21j\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27|\3\2"+
		"\2\2\31~\3\2\2\2\33\u0087\3\2\2\2\35\u0089\3\2\2\2\37\u008c\3\2\2\2!\u0090"+
		"\3\2\2\2#\u0096\3\2\2\2%\u009d\3\2\2\2\'\u00a2\3\2\2\2)\u00a9\3\2\2\2"+
		"+\u00ad\3\2\2\2-\u00b2\3\2\2\2/\u00be\3\2\2\2\61\u00ca\3\2\2\2\63\u00d5"+
		"\3\2\2\2\65\u00de\3\2\2\2\67\u00e6\3\2\2\29\u00ec\3\2\2\2;\u00fb\3\2\2"+
		"\2=>\7=\2\2>\4\3\2\2\2?@\7h\2\2@A\7k\2\2AB\7n\2\2BC\7g\2\2CD\7Q\2\2DE"+
		"\7r\2\2EF\7g\2\2FG\7p\2\2G\6\3\2\2\2HI\7*\2\2I\b\3\2\2\2JK\7+\2\2K\n\3"+
		"\2\2\2LM\7r\2\2MN\7t\2\2NO\7k\2\2OP\7p\2\2PQ\7v\2\2QR\7N\2\2RS\7k\2\2"+
		"ST\7p\2\2TU\7g\2\2U\f\3\2\2\2VW\7r\2\2WX\7t\2\2XY\7k\2\2YZ\7p\2\2Z[\7"+
		"v\2\2[\\\7K\2\2\\]\7p\2\2]^\7v\2\2^\16\3\2\2\2_`\7r\2\2`a\7t\2\2ab\7k"+
		"\2\2bc\7p\2\2cd\7v\2\2de\7H\2\2ef\7n\2\2fg\7q\2\2gh\7c\2\2hi\7v\2\2i\20"+
		"\3\2\2\2jk\7r\2\2kl\7t\2\2lm\7k\2\2mn\7p\2\2no\7v\2\2op\7F\2\2pq\7q\2"+
		"\2qr\7w\2\2rs\7d\2\2st\7n\2\2tu\7g\2\2u\22\3\2\2\2vw\7-\2\2w\24\3\2\2"+
		"\2xy\7c\2\2yz\7f\2\2z{\7f\2\2{\26\3\2\2\2|}\7/\2\2}\30\3\2\2\2~\177\7"+
		"u\2\2\177\u0080\7w\2\2\u0080\u0081\7d\2\2\u0081\u0082\7v\2\2\u0082\u0083"+
		"\7t\2\2\u0083\u0084\7c\2\2\u0084\u0085\7e\2\2\u0085\u0086\7v\2\2\u0086"+
		"\32\3\2\2\2\u0087\u0088\7?\2\2\u0088\34\3\2\2\2\u0089\u008a\7?\2\2\u008a"+
		"\u008b\7?\2\2\u008b\36\3\2\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e"+
		"\u008f\7v\2\2\u008f \3\2\2\2\u0090\u0091\7h\2\2\u0091\u0092\7n\2\2\u0092"+
		"\u0093\7q\2\2\u0093\u0094\7c\2\2\u0094\u0095\7v\2\2\u0095\"\3\2\2\2\u0096"+
		"\u0097\7f\2\2\u0097\u0098\7q\2\2\u0098\u0099\7w\2\2\u0099\u009a\7d\2\2"+
		"\u009a\u009b\7n\2\2\u009b\u009c\7g\2\2\u009c$\3\2\2\2\u009d\u009e\7n\2"+
		"\2\u009e\u009f\7q\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7i\2\2\u00a1&\3\2"+
		"\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7l\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7v\2\2\u00a8(\3\2\2\2\u00a9\u00aa"+
		"\7>\2\2\u00aa\u00ab\7?\2\2\u00ab*\3\2\2\2\u00ac\u00ae\t\2\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		",\3\2\2\2\u00b1\u00b3\4\62;\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2"+
		"\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00ba"+
		"\7\60\2\2\u00b7\u00b9\4\62;\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2"+
		"\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb.\3\2\2\2\u00bc\u00ba\3"+
		"\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c6\7\60"+
		"\2\2\u00c3\u00c5\4\62;\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\60\3\2\2\2\u00c8\u00c6\3\2\2"+
		"\2\u00c9\u00cb\4\62;\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca"+
		"\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d2\7\60\2\2"+
		"\u00cf\u00d1\4\62;\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\62\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d9\7$\2\2\u00d6\u00d8\t\3\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2"+
		"\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\7$\2\2\u00dd\64\3\2\2\2\u00de\u00e2\t\4\2\2"+
		"\u00df\u00e1\t\5\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\66\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e7\t\6\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b\34\2\2\u00eb"+
		"8\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\7,\2\2\u00ee\u00f3\3\2\2\2"+
		"\u00ef\u00f2\59\35\2\u00f0\u00f2\13\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0"+
		"\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7,\2\2\u00f7\u00f8\7\61"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\b\35\3\2\u00fa:\3\2\2\2\u00fb\u00fc"+
		"\7\61\2\2\u00fc\u00fd\7\61\2\2\u00fd\u0101\3\2\2\2\u00fe\u0100\13\2\2"+
		"\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u0102\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7\f\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\b\36\3\2\u0107<\3\2\2\2\20\2\u00af\u00b4\u00ba"+
		"\u00c0\u00c6\u00cc\u00d2\u00d9\u00e2\u00e8\u00f1\u00f3\u0101\4\b\2\2\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}