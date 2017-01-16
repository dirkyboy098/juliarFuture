// Generated from D:/source/juliarFuture/src/com/juliar/parser\juliar.g4 by ANTLR 4.6
package com.juliar.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class juliarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		NULL=32, BOOLEAN=33, INT=34, FLOAT=35, DOUBLE=36, LONG=37, STRING=38, 
		ID=39, WS=40, COMMENT=41, LINE_COMMENT=42;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_endLine = 2, RULE_semiColon = 3, 
		RULE_expressions = 4, RULE_expression = 5, RULE_assignmentExpression = 6, 
		RULE_functionCallKeyword = 7, RULE_functionCall = 8, RULE_functionDeclaration = 9, 
		RULE_funcName = 10, RULE_primitives = 11, RULE_command = 12, RULE_variable = 13, 
		RULE_add = 14, RULE_summation = 15, RULE_subtract = 16, RULE_subtraction = 17, 
		RULE_multiply = 18, RULE_multiplication = 19, RULE_divide = 20, RULE_division = 21, 
		RULE_modulo = 22, RULE_moduli = 23, RULE_types = 24, RULE_primitiveTypes = 25, 
		RULE_numericTypes = 26, RULE_equalsign = 27, RULE_equalequal = 28, RULE_keywords = 29, 
		RULE_arrowsign = 30;
	public static final String[] ruleNames = {
		"compileUnit", "statement", "endLine", "semiColon", "expressions", "expression", 
		"assignmentExpression", "functionCallKeyword", "functionCall", "functionDeclaration", 
		"funcName", "primitives", "command", "variable", "add", "summation", "subtract", 
		"subtraction", "multiply", "multiplication", "divide", "division", "modulo", 
		"moduli", "types", "primitiveTypes", "numericTypes", "equalsign", "equalequal", 
		"keywords", "arrowsign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'call'", "'()'", "'function'", "'{'", "'}'", "'fileOpen'", 
		"'('", "')'", "'printLine'", "'printInt'", "'printFloat'", "'printDouble'", 
		"'+'", "'add'", "'-'", "'subtract'", "'*'", "'multiply'", "'/'", "'divide'", 
		"'%'", "'modulo'", "'='", "'=='", "'int'", "'float'", "'double'", "'long'", 
		"'object'", "'<='", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "NULL", "BOOLEAN", "INT", 
		"FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "juliar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public juliarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompileUnitContext extends ParserRuleContext {
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterCompileUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitCompileUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(62);
				functionDeclaration();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public EndLineContext endLine() {
			return getRuleContext(EndLineContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(68);
			expression();
			}
			setState(69);
			endLine();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndLineContext extends ParserRuleContext {
		public SemiColonContext semiColon() {
			return getRuleContext(SemiColonContext.class,0);
		}
		public EndLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterEndLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitEndLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitEndLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndLineContext endLine() throws RecognitionException {
		EndLineContext _localctx = new EndLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_endLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			semiColon();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SemiColonContext extends ParserRuleContext {
		public SemiColonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semiColon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterSemiColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitSemiColon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSemiColon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemiColonContext semiColon() throws RecognitionException {
		SemiColonContext _localctx = new SemiColonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_semiColon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) {
				{
				{
				setState(75);
				expression();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				assignmentExpression();
				}
				break;
			case T__6:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				primitives();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				functionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public EqualsignContext equalsign() {
			return getRuleContext(EqualsignContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignmentExpression);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				keywords();
				setState(87);
				variable();
				setState(88);
				equalsign();
				setState(89);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				keywords();
				setState(92);
				variable();
				setState(93);
				equalsign();
				setState(94);
				variable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallKeywordContext extends ParserRuleContext {
		public FunctionCallKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterFunctionCallKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitFunctionCallKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitFunctionCallKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallKeywordContext functionCallKeyword() throws RecognitionException {
		FunctionCallKeywordContext _localctx = new FunctionCallKeywordContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionCallKeyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallKeywordContext functionCallKeyword() {
			return getRuleContext(FunctionCallKeywordContext.class,0);
		}
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(100);
			functionCallKeyword();
			}
			{
			setState(101);
			funcName();
			}
			setState(102);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public EqualsignContext equalsign() {
			return getRuleContext(EqualsignContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__3);
			setState(105);
			funcName();
			setState(106);
			match(T__2);
			setState(107);
			equalsign();
			setState(108);
			match(T__4);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) {
				{
				{
				setState(109);
				statement();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitivesContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(juliarParser.STRING, 0); }
		public PrimitivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterPrimitives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitPrimitives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitPrimitives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivesContext primitives() throws RecognitionException {
		PrimitivesContext _localctx = new PrimitivesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primitives);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__6);
				setState(120);
				match(T__7);
				setState(121);
				match(STRING);
				setState(122);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(T__9);
				setState(124);
				match(T__7);
				setState(125);
				match(STRING);
				setState(126);
				match(T__8);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(127);
				match(T__10);
				}
				{
				setState(128);
				match(T__7);
				}
				{
				setState(129);
				match(T__8);
				}
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(T__11);
				setState(131);
				match(T__7);
				setState(132);
				match(T__8);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(T__12);
				setState(134);
				match(T__7);
				setState(135);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public SubtractContext subtract() {
			return getRuleContext(SubtractContext.class,0);
		}
		public MultiplyContext multiply() {
			return getRuleContext(MultiplyContext.class,0);
		}
		public DivideContext divide() {
			return getRuleContext(DivideContext.class,0);
		}
		public ModuloContext modulo() {
			return getRuleContext(ModuloContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_command);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				add();
				}
				break;
			case T__6:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				primitives();
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				subtract();
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				multiply();
				}
				break;
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				divide();
				}
				break;
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 6);
				{
				setState(143);
				modulo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public SummationContext summation() {
			return getRuleContext(SummationContext.class,0);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_add);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				summation();
				setState(149);
				types();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(150);
					types();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				summation();
				setState(157);
				types();
				setState(158);
				types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SummationContext extends ParserRuleContext {
		public SummationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterSummation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitSummation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSummation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummationContext summation() throws RecognitionException {
		SummationContext _localctx = new SummationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtractContext extends ParserRuleContext {
		public SubtractionContext subtraction() {
			return getRuleContext(SubtractionContext.class,0);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public SubtractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtract; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterSubtract(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitSubtract(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractContext subtract() throws RecognitionException {
		SubtractContext _localctx = new SubtractContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_subtract);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				subtraction();
				setState(165);
				types();
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(166);
					types();
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				subtraction();
				setState(173);
				types();
				setState(174);
				types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtractionContext extends ParserRuleContext {
		public SubtractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractionContext subtraction() throws RecognitionException {
		SubtractionContext _localctx = new SubtractionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subtraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyContext extends ParserRuleContext {
		public MultiplicationContext multiplication() {
			return getRuleContext(MultiplicationContext.class,0);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public MultiplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterMultiply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitMultiply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiply);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				multiplication();
				setState(181);
				types();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(182);
					types();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				multiplication();
				setState(189);
				types();
				setState(190);
				types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicationContext extends ParserRuleContext {
		public MultiplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplication; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivideContext extends ParserRuleContext {
		public DivisionContext division() {
			return getRuleContext(DivisionContext.class,0);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public DivideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitDivide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_divide);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				division();
				setState(197);
				types();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(198);
					types();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				division();
				setState(205);
				types();
				setState(206);
				types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivisionContext extends ParserRuleContext {
		public DivisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_division; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisionContext division() throws RecognitionException {
		DivisionContext _localctx = new DivisionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_division);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuloContext extends ParserRuleContext {
		public ModuliContext moduli() {
			return getRuleContext(ModuliContext.class,0);
		}
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public ModuloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modulo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuloContext modulo() throws RecognitionException {
		ModuloContext _localctx = new ModuloContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_modulo);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				moduli();
				setState(213);
				types();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(214);
					types();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				moduli();
				setState(221);
				types();
				setState(222);
				types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuliContext extends ParserRuleContext {
		public ModuliContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduli; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterModuli(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitModuli(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitModuli(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuliContext moduli() throws RecognitionException {
		ModuliContext _localctx = new ModuliContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_moduli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_types);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			primitiveTypes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypesContext extends ParserRuleContext {
		public NumericTypesContext numericTypes() {
			return getRuleContext(NumericTypesContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(juliarParser.BOOLEAN, 0); }
		public TerminalNode NULL() { return getToken(juliarParser.NULL, 0); }
		public PrimitiveTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterPrimitiveTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitPrimitiveTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitPrimitiveTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypesContext primitiveTypes() throws RecognitionException {
		PrimitiveTypesContext _localctx = new PrimitiveTypesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_primitiveTypes);
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				numericTypes();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(BOOLEAN);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypesContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(juliarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(juliarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(juliarParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(juliarParser.LONG, 0); }
		public NumericTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterNumericTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitNumericTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitNumericTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypesContext numericTypes() throws RecognitionException {
		NumericTypesContext _localctx = new NumericTypesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_numericTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualsignContext extends ParserRuleContext {
		public EqualsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalsign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterEqualsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitEqualsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitEqualsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualsignContext equalsign() throws RecognitionException {
		EqualsignContext _localctx = new EqualsignContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualequalContext extends ParserRuleContext {
		public EqualequalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalequal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterEqualequal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitEqualequal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitEqualequal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualequalContext equalequal() throws RecognitionException {
		EqualequalContext _localctx = new EqualequalContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equalequal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordsContext extends ParserRuleContext {
		public KeywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterKeywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitKeywords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitKeywords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordsContext keywords() throws RecognitionException {
		KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrowsignContext extends ParserRuleContext {
		public ArrowsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowsign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterArrowsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitArrowsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitArrowsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowsignContext arrowsign() throws RecognitionException {
		ArrowsignContext _localctx = new ArrowsignContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrowsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\7\6O\n\6\f\6"+
		"\16\6R\13\6\3\7\3\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bc\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"q\n\13\f\13\16\13t\13\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u008b\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0093\n\16\3\17\3\17\3\20\3\20\3\20\7\20\u009a\n"+
		"\20\f\20\16\20\u009d\13\20\3\20\3\20\3\20\3\20\5\20\u00a3\n\20\3\21\3"+
		"\21\3\22\3\22\3\22\7\22\u00aa\n\22\f\22\16\22\u00ad\13\22\3\22\3\22\3"+
		"\22\3\22\5\22\u00b3\n\22\3\23\3\23\3\24\3\24\3\24\7\24\u00ba\n\24\f\24"+
		"\16\24\u00bd\13\24\3\24\3\24\3\24\3\24\5\24\u00c3\n\24\3\25\3\25\3\26"+
		"\3\26\3\26\7\26\u00ca\n\26\f\26\16\26\u00cd\13\26\3\26\3\26\3\26\3\26"+
		"\5\26\u00d3\n\26\3\27\3\27\3\30\3\30\3\30\7\30\u00da\n\30\f\30\16\30\u00dd"+
		"\13\30\3\30\3\30\3\30\3\30\5\30\u00e3\n\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\33\5\33\u00ec\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>\2\t\3\2\20\21\3\2\22\23\3\2\24\25\3\2\26\27\3\2\30\31\3\2$\'\3\2"+
		"\34 \u00f3\2C\3\2\2\2\4F\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\nP\3\2\2\2\fV\3"+
		"\2\2\2\16b\3\2\2\2\20d\3\2\2\2\22f\3\2\2\2\24j\3\2\2\2\26w\3\2\2\2\30"+
		"\u008a\3\2\2\2\32\u0092\3\2\2\2\34\u0094\3\2\2\2\36\u00a2\3\2\2\2 \u00a4"+
		"\3\2\2\2\"\u00b2\3\2\2\2$\u00b4\3\2\2\2&\u00c2\3\2\2\2(\u00c4\3\2\2\2"+
		"*\u00d2\3\2\2\2,\u00d4\3\2\2\2.\u00e2\3\2\2\2\60\u00e4\3\2\2\2\62\u00e6"+
		"\3\2\2\2\64\u00eb\3\2\2\2\66\u00ed\3\2\2\28\u00ef\3\2\2\2:\u00f1\3\2\2"+
		"\2<\u00f3\3\2\2\2>\u00f5\3\2\2\2@B\5\24\13\2A@\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2D\3\3\2\2\2EC\3\2\2\2FG\5\f\7\2GH\5\6\4\2H\5\3\2\2\2IJ\5"+
		"\b\5\2J\7\3\2\2\2KL\7\3\2\2L\t\3\2\2\2MO\5\f\7\2NM\3\2\2\2OR\3\2\2\2P"+
		"N\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2RP\3\2\2\2SW\5\16\b\2TW\5\30\r\2UW\5\22"+
		"\n\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\r\3\2\2\2XY\5<\37\2YZ\5\34\17\2Z["+
		"\58\35\2[\\\5\32\16\2\\c\3\2\2\2]^\5<\37\2^_\5\34\17\2_`\58\35\2`a\5\34"+
		"\17\2ac\3\2\2\2bX\3\2\2\2b]\3\2\2\2c\17\3\2\2\2de\7\4\2\2e\21\3\2\2\2"+
		"fg\5\20\t\2gh\5\26\f\2hi\7\5\2\2i\23\3\2\2\2jk\7\6\2\2kl\5\26\f\2lm\7"+
		"\5\2\2mn\58\35\2nr\7\7\2\2oq\5\4\3\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\b\2\2v\25\3\2\2\2wx\7)\2\2x\27\3\2\2\2"+
		"yz\7\t\2\2z{\7\n\2\2{|\7(\2\2|\u008b\7\13\2\2}~\7\f\2\2~\177\7\n\2\2\177"+
		"\u0080\7(\2\2\u0080\u008b\7\13\2\2\u0081\u0082\7\r\2\2\u0082\u0083\7\n"+
		"\2\2\u0083\u008b\7\13\2\2\u0084\u0085\7\16\2\2\u0085\u0086\7\n\2\2\u0086"+
		"\u008b\7\13\2\2\u0087\u0088\7\17\2\2\u0088\u0089\7\n\2\2\u0089\u008b\7"+
		"\13\2\2\u008ay\3\2\2\2\u008a}\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0084"+
		"\3\2\2\2\u008a\u0087\3\2\2\2\u008b\31\3\2\2\2\u008c\u0093\5\36\20\2\u008d"+
		"\u0093\5\30\r\2\u008e\u0093\5\"\22\2\u008f\u0093\5&\24\2\u0090\u0093\5"+
		"*\26\2\u0091\u0093\5.\30\2\u0092\u008c\3\2\2\2\u0092\u008d\3\2\2\2\u0092"+
		"\u008e\3\2\2\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\33\3\2\2\2\u0094\u0095\7)\2\2\u0095\35\3\2\2\2\u0096\u0097"+
		"\5 \21\2\u0097\u009b\5\62\32\2\u0098\u009a\5\62\32\2\u0099\u0098\3\2\2"+
		"\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a3"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\5 \21\2\u009f\u00a0\5\62\32\2"+
		"\u00a0\u00a1\5\62\32\2\u00a1\u00a3\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u009e"+
		"\3\2\2\2\u00a3\37\3\2\2\2\u00a4\u00a5\t\2\2\2\u00a5!\3\2\2\2\u00a6\u00a7"+
		"\5$\23\2\u00a7\u00ab\5\62\32\2\u00a8\u00aa\5\62\32\2\u00a9\u00a8\3\2\2"+
		"\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b3"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\5$\23\2\u00af\u00b0\5\62\32\2"+
		"\u00b0\u00b1\5\62\32\2\u00b1\u00b3\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b2\u00ae"+
		"\3\2\2\2\u00b3#\3\2\2\2\u00b4\u00b5\t\3\2\2\u00b5%\3\2\2\2\u00b6\u00b7"+
		"\5(\25\2\u00b7\u00bb\5\62\32\2\u00b8\u00ba\5\62\32\2\u00b9\u00b8\3\2\2"+
		"\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c3"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\5(\25\2\u00bf\u00c0\5\62\32\2"+
		"\u00c0\u00c1\5\62\32\2\u00c1\u00c3\3\2\2\2\u00c2\u00b6\3\2\2\2\u00c2\u00be"+
		"\3\2\2\2\u00c3\'\3\2\2\2\u00c4\u00c5\t\4\2\2\u00c5)\3\2\2\2\u00c6\u00c7"+
		"\5,\27\2\u00c7\u00cb\5\62\32\2\u00c8\u00ca\5\62\32\2\u00c9\u00c8\3\2\2"+
		"\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d3"+
		"\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\5,\27\2\u00cf\u00d0\5\62\32\2"+
		"\u00d0\u00d1\5\62\32\2\u00d1\u00d3\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d2\u00ce"+
		"\3\2\2\2\u00d3+\3\2\2\2\u00d4\u00d5\t\5\2\2\u00d5-\3\2\2\2\u00d6\u00d7"+
		"\5\60\31\2\u00d7\u00db\5\62\32\2\u00d8\u00da\5\62\32\2\u00d9\u00d8\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00e3\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\5\60\31\2\u00df\u00e0\5"+
		"\62\32\2\u00e0\u00e1\5\62\32\2\u00e1\u00e3\3\2\2\2\u00e2\u00d6\3\2\2\2"+
		"\u00e2\u00de\3\2\2\2\u00e3/\3\2\2\2\u00e4\u00e5\t\6\2\2\u00e5\61\3\2\2"+
		"\2\u00e6\u00e7\5\64\33\2\u00e7\63\3\2\2\2\u00e8\u00ec\5\66\34\2\u00e9"+
		"\u00ec\7#\2\2\u00ea\u00ec\7\"\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ea\3\2\2\2\u00ec\65\3\2\2\2\u00ed\u00ee\t\7\2\2\u00ee\67"+
		"\3\2\2\2\u00ef\u00f0\7\32\2\2\u00f09\3\2\2\2\u00f1\u00f2\7\33\2\2\u00f2"+
		";\3\2\2\2\u00f3\u00f4\t\b\2\2\u00f4=\3\2\2\2\u00f5\u00f6\7!\2\2\u00f6"+
		"?\3\2\2\2\24CPVbr\u008a\u0092\u009b\u00a2\u00ab\u00b2\u00bb\u00c2\u00cb"+
		"\u00d2\u00db\u00e2\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}