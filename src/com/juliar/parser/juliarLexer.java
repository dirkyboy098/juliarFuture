// Generated from D:/source/juliarFuture/src/com/juliar/parser\juliar.g4 by ANTLR 4.6
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
		T__17=18, INT=19, FLOAT=20, DOUBLE=21, LONG=22, STRING=23, ID=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'if'", "'('", "')'", "'{'", "'}'", "'nif'", "'+'", "'add'", 
		"'-'", "'subtract'", "'x'", "'multiply'", "'/'", "'divide'", "'='", "'=='", 
		"'fileOpen'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "INT", "FLOAT", "DOUBLE", "LONG", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24{\n\24\r\24\16\24"+
		"|\3\25\6\25\u0080\n\25\r\25\16\25\u0081\3\25\3\25\7\25\u0086\n\25\f\25"+
		"\16\25\u0089\13\25\3\26\6\26\u008c\n\26\r\26\16\26\u008d\3\26\3\26\7\26"+
		"\u0092\n\26\f\26\16\26\u0095\13\26\3\27\6\27\u0098\n\27\r\27\16\27\u0099"+
		"\3\27\3\27\7\27\u009e\n\27\f\27\16\27\u00a1\13\27\3\30\3\30\7\30\u00a5"+
		"\n\30\f\30\16\30\u00a8\13\30\3\30\3\30\3\31\3\31\7\31\u00ae\n\31\f\31"+
		"\16\31\u00b1\13\31\3\32\6\32\u00b4\n\32\r\32\16\32\u00b5\3\32\3\32\2\2"+
		"\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\7\3\2\62;\t"+
		"\2\"\"\60\60\62<C\\^^aac|\5\2C\\aac|\7\2//\62;C\\aac|\5\2\13\f\17\17\""+
		"\"\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\7:\3\2"+
		"\2\2\t<\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21F\3\2\2\2\23H\3\2"+
		"\2\2\25L\3\2\2\2\27N\3\2\2\2\31W\3\2\2\2\33Y\3\2\2\2\35b\3\2\2\2\37d\3"+
		"\2\2\2!k\3\2\2\2#m\3\2\2\2%p\3\2\2\2\'z\3\2\2\2)\177\3\2\2\2+\u008b\3"+
		"\2\2\2-\u0097\3\2\2\2/\u00a2\3\2\2\2\61\u00ab\3\2\2\2\63\u00b3\3\2\2\2"+
		"\65\66\7=\2\2\66\4\3\2\2\2\678\7k\2\289\7h\2\29\6\3\2\2\2:;\7*\2\2;\b"+
		"\3\2\2\2<=\7+\2\2=\n\3\2\2\2>?\7}\2\2?\f\3\2\2\2@A\7\177\2\2A\16\3\2\2"+
		"\2BC\7p\2\2CD\7k\2\2DE\7h\2\2E\20\3\2\2\2FG\7-\2\2G\22\3\2\2\2HI\7c\2"+
		"\2IJ\7f\2\2JK\7f\2\2K\24\3\2\2\2LM\7/\2\2M\26\3\2\2\2NO\7u\2\2OP\7w\2"+
		"\2PQ\7d\2\2QR\7v\2\2RS\7t\2\2ST\7c\2\2TU\7e\2\2UV\7v\2\2V\30\3\2\2\2W"+
		"X\7z\2\2X\32\3\2\2\2YZ\7o\2\2Z[\7w\2\2[\\\7n\2\2\\]\7v\2\2]^\7k\2\2^_"+
		"\7r\2\2_`\7n\2\2`a\7{\2\2a\34\3\2\2\2bc\7\61\2\2c\36\3\2\2\2de\7f\2\2"+
		"ef\7k\2\2fg\7x\2\2gh\7k\2\2hi\7f\2\2ij\7g\2\2j \3\2\2\2kl\7?\2\2l\"\3"+
		"\2\2\2mn\7?\2\2no\7?\2\2o$\3\2\2\2pq\7h\2\2qr\7k\2\2rs\7n\2\2st\7g\2\2"+
		"tu\7Q\2\2uv\7r\2\2vw\7g\2\2wx\7p\2\2x&\3\2\2\2y{\t\2\2\2zy\3\2\2\2{|\3"+
		"\2\2\2|z\3\2\2\2|}\3\2\2\2}(\3\2\2\2~\u0080\4\62;\2\177~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0087\7\60\2\2\u0084\u0086\4\62;\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088*\3\2\2\2"+
		"\u0089\u0087\3\2\2\2\u008a\u008c\4\62;\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0093\7\60\2\2\u0090\u0092\4\62;\2\u0091\u0090\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094,\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0096\u0098\4\62;\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009f\7\60"+
		"\2\2\u009c\u009e\4\62;\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0.\3\2\2\2\u00a1\u009f\3\2\2\2"+
		"\u00a2\u00a6\7$\2\2\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\7$\2\2\u00aa\60\3\2\2\2\u00ab\u00af\t\4\2\2"+
		"\u00ac\u00ae\t\5\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\62\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b4\t\6\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\b\32\2\2\u00b8"+
		"\64\3\2\2\2\r\2|\u0081\u0087\u008d\u0093\u0099\u009f\u00a6\u00af\u00b5"+
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