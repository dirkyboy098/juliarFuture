// Generated from /Users/don/Desktop/repos/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.6
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
		T__31=32, T__32=33, T__33=34, NULL=35, BOOLEAN=36, INT=37, FLOAT=38, DOUBLE=39, 
		LONG=40, STRING=41, ID=42, WS=43, COMMENT=44, LINE_COMMENT=45;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_endLine = 2, RULE_semiColon = 3, 
		RULE_expression = 4, RULE_assignmentExpression = 5, RULE_functionCall = 6, 
		RULE_functionDeclaration = 7, RULE_funcName = 8, RULE_returnValue = 9, 
		RULE_leftParen = 10, RULE_rightParen = 11, RULE_booleanExpression = 12, 
		RULE_primitives = 13, RULE_command = 14, RULE_variable = 15, RULE_variabledeclartion = 16, 
		RULE_add = 17, RULE_summation = 18, RULE_subtract = 19, RULE_subtraction = 20, 
		RULE_multiply = 21, RULE_multiplication = 22, RULE_divide = 23, RULE_division = 24, 
		RULE_modulo = 25, RULE_moduli = 26, RULE_types = 27, RULE_primitiveTypes = 28, 
		RULE_numericTypes = 29, RULE_equalsign = 30, RULE_comparisonOperator = 31, 
		RULE_equalequal = 32, RULE_lessthan = 33, RULE_greaterthan = 34, RULE_lessthanorequalto = 35, 
		RULE_greaterthanorequalto = 36, RULE_threeway = 37, RULE_keywords = 38, 
		RULE_arrowsign = 39;
	public static final String[] ruleNames = {
		"compileUnit", "statement", "endLine", "semiColon", "expression", "assignmentExpression", 
		"functionCall", "functionDeclaration", "funcName", "returnValue", "leftParen", 
		"rightParen", "booleanExpression", "primitives", "command", "variable", 
		"variabledeclartion", "add", "summation", "subtract", "subtraction", "multiply", 
		"multiplication", "divide", "division", "modulo", "moduli", "types", "primitiveTypes", 
		"numericTypes", "equalsign", "comparisonOperator", "equalequal", "lessthan", 
		"greaterthan", "lessthanorequalto", "greaterthanorequalto", "threeway", 
		"keywords", "arrowsign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'()'", "','", "'function'", "'{'", "'}'", "'return'", "'('", 
		"')'", "'fileOpen'", "'printLine'", "'print'", "'+'", "'add'", "'-'", 
		"'subtract'", "'*'", "'multiply'", "'/'", "'divide'", "'%'", "'modulo'", 
		"'='", "'=='", "'<'", "'>'", "'<='", "'>='", "'<=>'", "'int'", "'float'", 
		"'double'", "'long'", "'object'", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "NULL", 
		"BOOLEAN", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS", "COMMENT", 
		"LINE_COMMENT"
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
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(80);
				functionDeclaration();
				}
				}
				setState(85);
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
			setState(86);
			expression();
			}
			setState(87);
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
			setState(89);
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
			setState(91);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public VariabledeclartionContext variabledeclartion() {
			return getRuleContext(VariabledeclartionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(juliarParser.STRING, 0); }
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
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				primitives();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				variabledeclartion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				functionCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				returnValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				booleanExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				match(STRING);
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public VariabledeclartionContext variabledeclartion() {
			return getRuleContext(VariabledeclartionContext.class,0);
		}
		public EqualsignContext equalsign() {
			return getRuleContext(EqualsignContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public EqualequalContext equalequal() {
			return getRuleContext(EqualequalContext.class,0);
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
		enterRule(_localctx, 10, RULE_assignmentExpression);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				variabledeclartion();
				setState(103);
				equalsign();
				setState(104);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				variabledeclartion();
				setState(107);
				equalsign();
				setState(108);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				variabledeclartion();
				setState(111);
				equalsign();
				setState(112);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				variabledeclartion();
				setState(115);
				equalsign();
				setState(116);
				primitiveTypes();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				variable();
				setState(119);
				equalequal();
				setState(120);
				variable();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				variable();
				setState(123);
				equalsign();
				setState(124);
				functionCall();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				variable();
				setState(127);
				equalsign();
				setState(128);
				primitiveTypes();
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
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
		enterRule(_localctx, 12, RULE_functionCall);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				funcName();
				setState(133);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				funcName();
				{
				setState(136);
				leftParen();
				}
				setState(137);
				variable();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(138);
					match(T__2);
					setState(139);
					variable();
					}
				}

				{
				setState(142);
				rightParen();
				}
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
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public List<VariabledeclartionContext> variabledeclartion() {
			return getRuleContexts(VariabledeclartionContext.class);
		}
		public VariabledeclartionContext variabledeclartion(int i) {
			return getRuleContext(VariabledeclartionContext.class,i);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
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
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(T__3);
				setState(147);
				funcName();
				setState(148);
				match(T__1);
				setState(149);
				equalsign();
				setState(150);
				match(T__4);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					{
					setState(151);
					statement();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(T__3);
				setState(160);
				funcName();
				setState(161);
				leftParen();
				setState(162);
				variabledeclartion();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(163);
					match(T__2);
					setState(164);
					variabledeclartion();
					}
				}

				setState(167);
				rightParen();
				setState(168);
				equalsign();
				setState(169);
				match(T__4);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << STRING) | (1L << ID))) != 0)) {
					{
					{
					setState(170);
					statement();
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
				match(T__5);
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
		enterRule(_localctx, 16, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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

	public static class ReturnValueContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ReturnValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterReturnValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitReturnValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnValue);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(T__6);
				{
				setState(184);
				variable();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(T__6);
				{
				setState(186);
				functionCall();
				}
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

	public static class LeftParenContext extends ParserRuleContext {
		public LeftParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterLeftParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitLeftParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitLeftParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftParenContext leftParen() throws RecognitionException {
		LeftParenContext _localctx = new LeftParenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_leftParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__7);
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

	public static class RightParenContext extends ParserRuleContext {
		public RightParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterRightParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitRightParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitRightParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightParenContext rightParen() throws RecognitionException {
		RightParenContext _localctx = new RightParenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rightParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__8);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_booleanExpression);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				variable();
				{
				setState(194);
				comparisonOperator();
				}
				setState(195);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				variable();
				{
				setState(198);
				comparisonOperator();
				}
				setState(199);
				command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				command();
				{
				setState(202);
				comparisonOperator();
				}
				setState(203);
				command();
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

	public static class PrimitivesContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(juliarParser.STRING, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_primitives);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(T__9);
				setState(208);
				match(T__7);
				setState(209);
				match(STRING);
				setState(210);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(T__10);
				setState(212);
				match(T__7);
				setState(213);
				types();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				variable();
				setState(215);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				match(T__11);
				setState(218);
				match(T__7);
				setState(219);
				types();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				variable();
				setState(221);
				match(T__8);
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
		enterRule(_localctx, 28, RULE_command);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				add();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				primitives();
				}
				break;
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				subtract();
				}
				break;
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				multiply();
				}
				break;
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
				divide();
				}
				break;
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
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
		enterRule(_localctx, 30, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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

	public static class VariabledeclartionContext extends ParserRuleContext {
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariabledeclartionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledeclartion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterVariabledeclartion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitVariabledeclartion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitVariabledeclartion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledeclartionContext variabledeclartion() throws RecognitionException {
		VariabledeclartionContext _localctx = new VariabledeclartionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variabledeclartion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			keywords();
			setState(236);
			variable();
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
		enterRule(_localctx, 34, RULE_add);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				summation();
				setState(239);
				types();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(240);
					types();
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				summation();
				setState(247);
				types();
				setState(248);
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
		enterRule(_localctx, 36, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
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
		enterRule(_localctx, 38, RULE_subtract);
		int _la;
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				subtraction();
				setState(255);
				types();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(256);
					types();
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				subtraction();
				setState(263);
				types();
				setState(264);
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
		enterRule(_localctx, 40, RULE_subtraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
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
		enterRule(_localctx, 42, RULE_multiply);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				multiplication();
				setState(271);
				types();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(272);
					types();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				multiplication();
				setState(279);
				types();
				setState(280);
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
		enterRule(_localctx, 44, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
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
		enterRule(_localctx, 46, RULE_divide);
		int _la;
		try {
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				division();
				setState(287);
				types();
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(288);
					types();
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				division();
				setState(295);
				types();
				setState(296);
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
		enterRule(_localctx, 48, RULE_division);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
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
		enterRule(_localctx, 50, RULE_modulo);
		int _la;
		try {
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				moduli();
				setState(303);
				types();
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(304);
					types();
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				moduli();
				setState(311);
				types();
				setState(312);
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
		enterRule(_localctx, 52, RULE_moduli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__21) ) {
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
		enterRule(_localctx, 54, RULE_types);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
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
		public TerminalNode STRING() { return getToken(juliarParser.STRING, 0); }
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
		enterRule(_localctx, 56, RULE_primitiveTypes);
		try {
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				numericTypes();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(STRING);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				match(BOOLEAN);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
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
		enterRule(_localctx, 58, RULE_numericTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
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
		enterRule(_localctx, 60, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__22);
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

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public EqualequalContext equalequal() {
			return getRuleContext(EqualequalContext.class,0);
		}
		public LessthanContext lessthan() {
			return getRuleContext(LessthanContext.class,0);
		}
		public GreaterthanContext greaterthan() {
			return getRuleContext(GreaterthanContext.class,0);
		}
		public LessthanorequaltoContext lessthanorequalto() {
			return getRuleContext(LessthanorequaltoContext.class,0);
		}
		public GreaterthanorequaltoContext greaterthanorequalto() {
			return getRuleContext(GreaterthanorequaltoContext.class,0);
		}
		public ThreewayContext threeway() {
			return getRuleContext(ThreewayContext.class,0);
		}
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_comparisonOperator);
		try {
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				equalequal();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				lessthan();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				greaterthan();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				lessthanorequalto();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				greaterthanorequalto();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 6);
				{
				setState(335);
				threeway();
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
		enterRule(_localctx, 64, RULE_equalequal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
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

	public static class LessthanContext extends ParserRuleContext {
		public LessthanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessthan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterLessthan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitLessthan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitLessthan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessthanContext lessthan() throws RecognitionException {
		LessthanContext _localctx = new LessthanContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lessthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
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

	public static class GreaterthanContext extends ParserRuleContext {
		public GreaterthanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterthan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterGreaterthan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitGreaterthan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitGreaterthan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterthanContext greaterthan() throws RecognitionException {
		GreaterthanContext _localctx = new GreaterthanContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_greaterthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(T__25);
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

	public static class LessthanorequaltoContext extends ParserRuleContext {
		public LessthanorequaltoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessthanorequalto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterLessthanorequalto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitLessthanorequalto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitLessthanorequalto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessthanorequaltoContext lessthanorequalto() throws RecognitionException {
		LessthanorequaltoContext _localctx = new LessthanorequaltoContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_lessthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__26);
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

	public static class GreaterthanorequaltoContext extends ParserRuleContext {
		public GreaterthanorequaltoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterthanorequalto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterGreaterthanorequalto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitGreaterthanorequalto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitGreaterthanorequalto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterthanorequaltoContext greaterthanorequalto() throws RecognitionException {
		GreaterthanorequaltoContext _localctx = new GreaterthanorequaltoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_greaterthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__27);
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

	public static class ThreewayContext extends ParserRuleContext {
		public ThreewayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_threeway; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterThreeway(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitThreeway(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitThreeway(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThreewayContext threeway() throws RecognitionException {
		ThreewayContext _localctx = new ThreewayContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_threeway);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(T__28);
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
		enterRule(_localctx, 76, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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
		enterRule(_localctx, 78, RULE_arrowsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__26);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0165\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\7\2T\n\2\f"+
		"\2\16\2W\13\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6g\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0085\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008f\n\b\3\b\3\b\5\b\u0093\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u00a8\n\t\3\t\3\t\3\t\3\t\7\t\u00ae\n\t\f\t\16\t\u00b1"+
		"\13\t\3\t\3\t\5\t\u00b5\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00be"+
		"\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00d0\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e2\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00ea\n\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\7\23"+
		"\u00f4\n\23\f\23\16\23\u00f7\13\23\3\23\3\23\3\23\3\23\5\23\u00fd\n\23"+
		"\3\24\3\24\3\25\3\25\3\25\7\25\u0104\n\25\f\25\16\25\u0107\13\25\3\25"+
		"\3\25\3\25\3\25\5\25\u010d\n\25\3\26\3\26\3\27\3\27\3\27\7\27\u0114\n"+
		"\27\f\27\16\27\u0117\13\27\3\27\3\27\3\27\3\27\5\27\u011d\n\27\3\30\3"+
		"\30\3\31\3\31\3\31\7\31\u0124\n\31\f\31\16\31\u0127\13\31\3\31\3\31\3"+
		"\31\3\31\5\31\u012d\n\31\3\32\3\32\3\33\3\33\3\33\7\33\u0134\n\33\f\33"+
		"\16\33\u0137\13\33\3\33\3\33\3\33\3\33\5\33\u013d\n\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\5\36\u0147\n\36\3\37\3\37\3 \3 \3!\3!\3!\3!"+
		"\3!\3!\5!\u0153\n!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3)\2\2*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNP\2\t\3\2\17\20\3\2\21\22\3\2\23\24\3\2\25\26\3\2\27\30\3"+
		"\2\'*\3\2 $\u016e\2U\3\2\2\2\4X\3\2\2\2\6[\3\2\2\2\b]\3\2\2\2\nf\3\2\2"+
		"\2\f\u0084\3\2\2\2\16\u0092\3\2\2\2\20\u00b4\3\2\2\2\22\u00b6\3\2\2\2"+
		"\24\u00bd\3\2\2\2\26\u00bf\3\2\2\2\30\u00c1\3\2\2\2\32\u00cf\3\2\2\2\34"+
		"\u00e1\3\2\2\2\36\u00e9\3\2\2\2 \u00eb\3\2\2\2\"\u00ed\3\2\2\2$\u00fc"+
		"\3\2\2\2&\u00fe\3\2\2\2(\u010c\3\2\2\2*\u010e\3\2\2\2,\u011c\3\2\2\2."+
		"\u011e\3\2\2\2\60\u012c\3\2\2\2\62\u012e\3\2\2\2\64\u013c\3\2\2\2\66\u013e"+
		"\3\2\2\28\u0140\3\2\2\2:\u0146\3\2\2\2<\u0148\3\2\2\2>\u014a\3\2\2\2@"+
		"\u0152\3\2\2\2B\u0154\3\2\2\2D\u0156\3\2\2\2F\u0158\3\2\2\2H\u015a\3\2"+
		"\2\2J\u015c\3\2\2\2L\u015e\3\2\2\2N\u0160\3\2\2\2P\u0162\3\2\2\2RT\5\20"+
		"\t\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\3\3\2\2\2WU\3\2\2\2XY\5"+
		"\n\6\2YZ\5\6\4\2Z\5\3\2\2\2[\\\5\b\5\2\\\7\3\2\2\2]^\7\3\2\2^\t\3\2\2"+
		"\2_g\5\f\7\2`g\5\34\17\2ag\5\"\22\2bg\5\16\b\2cg\5\24\13\2dg\5\32\16\2"+
		"eg\7+\2\2f_\3\2\2\2f`\3\2\2\2fa\3\2\2\2fb\3\2\2\2fc\3\2\2\2fd\3\2\2\2"+
		"fe\3\2\2\2g\13\3\2\2\2hi\5\"\22\2ij\5> \2jk\5\36\20\2k\u0085\3\2\2\2l"+
		"m\5\"\22\2mn\5> \2no\5 \21\2o\u0085\3\2\2\2pq\5\"\22\2qr\5> \2rs\5\16"+
		"\b\2s\u0085\3\2\2\2tu\5\"\22\2uv\5> \2vw\5:\36\2w\u0085\3\2\2\2xy\5 \21"+
		"\2yz\5B\"\2z{\5 \21\2{\u0085\3\2\2\2|}\5 \21\2}~\5> \2~\177\5\16\b\2\177"+
		"\u0085\3\2\2\2\u0080\u0081\5 \21\2\u0081\u0082\5> \2\u0082\u0083\5:\36"+
		"\2\u0083\u0085\3\2\2\2\u0084h\3\2\2\2\u0084l\3\2\2\2\u0084p\3\2\2\2\u0084"+
		"t\3\2\2\2\u0084x\3\2\2\2\u0084|\3\2\2\2\u0084\u0080\3\2\2\2\u0085\r\3"+
		"\2\2\2\u0086\u0087\5\22\n\2\u0087\u0088\7\4\2\2\u0088\u0093\3\2\2\2\u0089"+
		"\u008a\5\22\n\2\u008a\u008b\5\26\f\2\u008b\u008e\5 \21\2\u008c\u008d\7"+
		"\5\2\2\u008d\u008f\5 \21\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\5\30\r\2\u0091\u0093\3\2\2\2\u0092\u0086\3"+
		"\2\2\2\u0092\u0089\3\2\2\2\u0093\17\3\2\2\2\u0094\u0095\7\6\2\2\u0095"+
		"\u0096\5\22\n\2\u0096\u0097\7\4\2\2\u0097\u0098\5> \2\u0098\u009c\7\7"+
		"\2\2\u0099\u009b\5\4\3\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009f\u00a0\7\b\2\2\u00a0\u00b5\3\2\2\2\u00a1\u00a2\7\6\2\2\u00a2"+
		"\u00a3\5\22\n\2\u00a3\u00a4\5\26\f\2\u00a4\u00a7\5\"\22\2\u00a5\u00a6"+
		"\7\5\2\2\u00a6\u00a8\5\"\22\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2"+
		"\u00a8\u00a9\3\2\2\2\u00a9\u00aa\5\30\r\2\u00aa\u00ab\5> \2\u00ab\u00af"+
		"\7\7\2\2\u00ac\u00ae\5\4\3\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b3\7\b\2\2\u00b3\u00b5\3\2\2\2\u00b4\u0094\3\2\2\2\u00b4"+
		"\u00a1\3\2\2\2\u00b5\21\3\2\2\2\u00b6\u00b7\7,\2\2\u00b7\23\3\2\2\2\u00b8"+
		"\u00be\7\t\2\2\u00b9\u00ba\7\t\2\2\u00ba\u00be\5 \21\2\u00bb\u00bc\7\t"+
		"\2\2\u00bc\u00be\5\16\b\2\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\25\3\2\2\2\u00bf\u00c0\7\n\2\2\u00c0\27\3\2\2\2\u00c1"+
		"\u00c2\7\13\2\2\u00c2\31\3\2\2\2\u00c3\u00c4\5 \21\2\u00c4\u00c5\5@!\2"+
		"\u00c5\u00c6\5 \21\2\u00c6\u00d0\3\2\2\2\u00c7\u00c8\5 \21\2\u00c8\u00c9"+
		"\5@!\2\u00c9\u00ca\5\36\20\2\u00ca\u00d0\3\2\2\2\u00cb\u00cc\5\36\20\2"+
		"\u00cc\u00cd\5@!\2\u00cd\u00ce\5\36\20\2\u00ce\u00d0\3\2\2\2\u00cf\u00c3"+
		"\3\2\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0\33\3\2\2\2\u00d1"+
		"\u00d2\7\f\2\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\7+\2\2\u00d4\u00e2\7\13"+
		"\2\2\u00d5\u00d6\7\r\2\2\u00d6\u00d7\7\n\2\2\u00d7\u00e2\58\35\2\u00d8"+
		"\u00d9\5 \21\2\u00d9\u00da\7\13\2\2\u00da\u00e2\3\2\2\2\u00db\u00dc\7"+
		"\16\2\2\u00dc\u00dd\7\n\2\2\u00dd\u00e2\58\35\2\u00de\u00df\5 \21\2\u00df"+
		"\u00e0\7\13\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00d1\3\2\2\2\u00e1\u00d5\3"+
		"\2\2\2\u00e1\u00d8\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2"+
		"\35\3\2\2\2\u00e3\u00ea\5$\23\2\u00e4\u00ea\5\34\17\2\u00e5\u00ea\5(\25"+
		"\2\u00e6\u00ea\5,\27\2\u00e7\u00ea\5\60\31\2\u00e8\u00ea\5\64\33\2\u00e9"+
		"\u00e3\3\2\2\2\u00e9\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9\u00e6\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\37\3\2\2\2\u00eb\u00ec"+
		"\7,\2\2\u00ec!\3\2\2\2\u00ed\u00ee\5N(\2\u00ee\u00ef\5 \21\2\u00ef#\3"+
		"\2\2\2\u00f0\u00f1\5&\24\2\u00f1\u00f5\58\35\2\u00f2\u00f4\58\35\2\u00f3"+
		"\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00fd\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\5&\24\2\u00f9"+
		"\u00fa\58\35\2\u00fa\u00fb\58\35\2\u00fb\u00fd\3\2\2\2\u00fc\u00f0\3\2"+
		"\2\2\u00fc\u00f8\3\2\2\2\u00fd%\3\2\2\2\u00fe\u00ff\t\2\2\2\u00ff\'\3"+
		"\2\2\2\u0100\u0101\5*\26\2\u0101\u0105\58\35\2\u0102\u0104\58\35\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u010d\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\5*\26\2\u0109"+
		"\u010a\58\35\2\u010a\u010b\58\35\2\u010b\u010d\3\2\2\2\u010c\u0100\3\2"+
		"\2\2\u010c\u0108\3\2\2\2\u010d)\3\2\2\2\u010e\u010f\t\3\2\2\u010f+\3\2"+
		"\2\2\u0110\u0111\5.\30\2\u0111\u0115\58\35\2\u0112\u0114\58\35\2\u0113"+
		"\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u011d\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\5.\30\2\u0119"+
		"\u011a\58\35\2\u011a\u011b\58\35\2\u011b\u011d\3\2\2\2\u011c\u0110\3\2"+
		"\2\2\u011c\u0118\3\2\2\2\u011d-\3\2\2\2\u011e\u011f\t\4\2\2\u011f/\3\2"+
		"\2\2\u0120\u0121\5\62\32\2\u0121\u0125\58\35\2\u0122\u0124\58\35\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u012d\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\5\62\32\2\u0129"+
		"\u012a\58\35\2\u012a\u012b\58\35\2\u012b\u012d\3\2\2\2\u012c\u0120\3\2"+
		"\2\2\u012c\u0128\3\2\2\2\u012d\61\3\2\2\2\u012e\u012f\t\5\2\2\u012f\63"+
		"\3\2\2\2\u0130\u0131\5\66\34\2\u0131\u0135\58\35\2\u0132\u0134\58\35\2"+
		"\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u013d\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\5\66\34\2"+
		"\u0139\u013a\58\35\2\u013a\u013b\58\35\2\u013b\u013d\3\2\2\2\u013c\u0130"+
		"\3\2\2\2\u013c\u0138\3\2\2\2\u013d\65\3\2\2\2\u013e\u013f\t\6\2\2\u013f"+
		"\67\3\2\2\2\u0140\u0141\5:\36\2\u01419\3\2\2\2\u0142\u0147\5<\37\2\u0143"+
		"\u0147\7+\2\2\u0144\u0147\7&\2\2\u0145\u0147\7%\2\2\u0146\u0142\3\2\2"+
		"\2\u0146\u0143\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0145\3\2\2\2\u0147;"+
		"\3\2\2\2\u0148\u0149\t\7\2\2\u0149=\3\2\2\2\u014a\u014b\7\31\2\2\u014b"+
		"?\3\2\2\2\u014c\u0153\5B\"\2\u014d\u0153\5D#\2\u014e\u0153\5F$\2\u014f"+
		"\u0153\5H%\2\u0150\u0153\5J&\2\u0151\u0153\5L\'\2\u0152\u014c\3\2\2\2"+
		"\u0152\u014d\3\2\2\2\u0152\u014e\3\2\2\2\u0152\u014f\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0152\u0151\3\2\2\2\u0153A\3\2\2\2\u0154\u0155\7\32\2\2\u0155"+
		"C\3\2\2\2\u0156\u0157\7\33\2\2\u0157E\3\2\2\2\u0158\u0159\7\34\2\2\u0159"+
		"G\3\2\2\2\u015a\u015b\7\35\2\2\u015bI\3\2\2\2\u015c\u015d\7\36\2\2\u015d"+
		"K\3\2\2\2\u015e\u015f\7\37\2\2\u015fM\3\2\2\2\u0160\u0161\t\b\2\2\u0161"+
		"O\3\2\2\2\u0162\u0163\7\35\2\2\u0163Q\3\2\2\2\33Uf\u0084\u008e\u0092\u009c"+
		"\u00a7\u00af\u00b4\u00bd\u00cf\u00e1\u00e9\u00f5\u00fc\u0105\u010c\u0115"+
		"\u011c\u0125\u012c\u0135\u013c\u0146\u0152";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}