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
		INT=18, FLOAT=19, DOUBLE=20, LONG=21, STRING=22, ID=23, WS=24, COMMENT=25, 
		LINE_COMMENT=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'fileOpen'", "'('", "')'", "'printLine'", "'printInt'", 
		"'+'", "'add'", "'-'", "'subtract'", "'='", "'=='", "'int'", "'float'", 
		"'double'", "'long'", "'object'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "INT", "FLOAT", "DOUBLE", "LONG", 
		"STRING", "ID", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00e8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u008e"+
		"\n\23\r\23\16\23\u008f\3\24\6\24\u0093\n\24\r\24\16\24\u0094\3\24\3\24"+
		"\7\24\u0099\n\24\f\24\16\24\u009c\13\24\3\25\6\25\u009f\n\25\r\25\16\25"+
		"\u00a0\3\25\3\25\7\25\u00a5\n\25\f\25\16\25\u00a8\13\25\3\26\6\26\u00ab"+
		"\n\26\r\26\16\26\u00ac\3\26\3\26\7\26\u00b1\n\26\f\26\16\26\u00b4\13\26"+
		"\3\27\3\27\7\27\u00b8\n\27\f\27\16\27\u00bb\13\27\3\27\3\27\3\30\3\30"+
		"\7\30\u00c1\n\30\f\30\16\30\u00c4\13\30\3\31\6\31\u00c7\n\31\r\31\16\31"+
		"\u00c8\3\31\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u00d2\n\32\f\32\16\32\u00d5"+
		"\13\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u00e0\n\33\f"+
		"\33\16\33\u00e3\13\33\3\33\3\33\3\33\3\33\4\u00d3\u00e1\2\34\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\7\3\2\62;\t\2\"\""+
		"\60\60\62<C\\^^aac|\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17\"\"\u00f4"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7B\3"+
		"\2\2\2\tD\3\2\2\2\13F\3\2\2\2\rP\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23_\3"+
		"\2\2\2\25a\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33o\3\2\2\2\35s\3\2\2\2\37"+
		"y\3\2\2\2!\u0080\3\2\2\2#\u0085\3\2\2\2%\u008d\3\2\2\2\'\u0092\3\2\2\2"+
		")\u009e\3\2\2\2+\u00aa\3\2\2\2-\u00b5\3\2\2\2/\u00be\3\2\2\2\61\u00c6"+
		"\3\2\2\2\63\u00cc\3\2\2\2\65\u00db\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7h"+
		"\2\2:;\7k\2\2;<\7n\2\2<=\7g\2\2=>\7Q\2\2>?\7r\2\2?@\7g\2\2@A\7p\2\2A\6"+
		"\3\2\2\2BC\7*\2\2C\b\3\2\2\2DE\7+\2\2E\n\3\2\2\2FG\7r\2\2GH\7t\2\2HI\7"+
		"k\2\2IJ\7p\2\2JK\7v\2\2KL\7N\2\2LM\7k\2\2MN\7p\2\2NO\7g\2\2O\f\3\2\2\2"+
		"PQ\7r\2\2QR\7t\2\2RS\7k\2\2ST\7p\2\2TU\7v\2\2UV\7K\2\2VW\7p\2\2WX\7v\2"+
		"\2X\16\3\2\2\2YZ\7-\2\2Z\20\3\2\2\2[\\\7c\2\2\\]\7f\2\2]^\7f\2\2^\22\3"+
		"\2\2\2_`\7/\2\2`\24\3\2\2\2ab\7u\2\2bc\7w\2\2cd\7d\2\2de\7v\2\2ef\7t\2"+
		"\2fg\7c\2\2gh\7e\2\2hi\7v\2\2i\26\3\2\2\2jk\7?\2\2k\30\3\2\2\2lm\7?\2"+
		"\2mn\7?\2\2n\32\3\2\2\2op\7k\2\2pq\7p\2\2qr\7v\2\2r\34\3\2\2\2st\7h\2"+
		"\2tu\7n\2\2uv\7q\2\2vw\7c\2\2wx\7v\2\2x\36\3\2\2\2yz\7f\2\2z{\7q\2\2{"+
		"|\7w\2\2|}\7d\2\2}~\7n\2\2~\177\7g\2\2\177 \3\2\2\2\u0080\u0081\7n\2\2"+
		"\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2\u0083\u0084\7i\2\2\u0084\"\3\2"+
		"\2\2\u0085\u0086\7q\2\2\u0086\u0087\7d\2\2\u0087\u0088\7l\2\2\u0088\u0089"+
		"\7g\2\2\u0089\u008a\7e\2\2\u008a\u008b\7v\2\2\u008b$\3\2\2\2\u008c\u008e"+
		"\t\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090&\3\2\2\2\u0091\u0093\4\62;\2\u0092\u0091\3\2\2\2"+
		"\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u009a\7\60\2\2\u0097\u0099\4\62;\2\u0098\u0097\3\2\2\2"+
		"\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b(\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\4\62;\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a6\7\60\2\2\u00a3\u00a5\4\62;\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7*\3\2\2\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9\u00ab\4\62;\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00b2\7\60\2\2\u00af\u00b1\4\62;\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3,\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b9\7$\2\2\u00b6\u00b8\t\3\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7$\2\2\u00bd.\3\2\2\2\u00be\u00c2"+
		"\t\4\2\2\u00bf\u00c1\t\5\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\60\3\2\2\2\u00c4\u00c2\3\2\2"+
		"\2\u00c5\u00c7\t\6\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\31\2\2"+
		"\u00cb\62\3\2\2\2\u00cc\u00cd\7\61\2\2\u00cd\u00ce\7,\2\2\u00ce\u00d3"+
		"\3\2\2\2\u00cf\u00d2\5\63\32\2\u00d0\u00d2\13\2\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7,\2\2\u00d7"+
		"\u00d8\7\61\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b\32\3\2\u00da\64\3\2"+
		"\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00e1\3\2\2\2\u00de"+
		"\u00e0\13\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\7\f\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\b\33\3\2\u00e7\66\3\2\2"+
		"\2\20\2\u008f\u0094\u009a\u00a0\u00a6\u00ac\u00b2\u00b9\u00c2\u00c8\u00d1"+
		"\u00d3\u00e1\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}