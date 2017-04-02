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
		T__31=32, T__32=33, T__33=34, NULL=35, BOOLEAN=36, INT=37, FLOAT=38, DOUBLE=39, 
		LONG=40, STRING=41, ID=42, WS=43, COMMENT=44, LINE_COMMENT=45;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_endLine = 2, RULE_semiColon = 3, 
		RULE_expression = 4, RULE_assignmentExpression = 5, RULE_reassignmentExpression = 6, 
		RULE_functionCall = 7, RULE_functionDeclaration = 8, RULE_funcName = 9, 
		RULE_returnValue = 10, RULE_leftParen = 11, RULE_rightParen = 12, RULE_booleanExpression = 13, 
		RULE_primitives = 14, RULE_command = 15, RULE_variable = 16, RULE_variabledeclartion = 17, 
		RULE_add = 18, RULE_summation = 19, RULE_subtract = 20, RULE_subtraction = 21, 
		RULE_multiply = 22, RULE_multiplication = 23, RULE_divide = 24, RULE_division = 25, 
		RULE_modulo = 26, RULE_moduli = 27, RULE_types = 28, RULE_primitiveTypes = 29, 
		RULE_numericTypes = 30, RULE_equalsign = 31, RULE_comparisonOperator = 32, 
		RULE_equalequal = 33, RULE_lessthan = 34, RULE_greaterthan = 35, RULE_lessthanorequalto = 36, 
		RULE_greaterthanorequalto = 37, RULE_threeway = 38, RULE_keywords = 39, 
		RULE_arrowsign = 40;
	public static final String[] ruleNames = {
		"compileUnit", "statement", "endLine", "semiColon", "expression", "assignmentExpression", 
		"reassignmentExpression", "functionCall", "functionDeclaration", "funcName", 
		"returnValue", "leftParen", "rightParen", "booleanExpression", "primitives", 
		"command", "variable", "variabledeclartion", "add", "summation", "subtract", 
		"subtraction", "multiply", "multiplication", "divide", "division", "modulo", 
		"moduli", "types", "primitiveTypes", "numericTypes", "equalsign", "comparisonOperator", 
		"equalequal", "lessthan", "greaterthan", "lessthanorequalto", "greaterthanorequalto", 
		"threeway", "keywords", "arrowsign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'()'", "','", "'function'", "'{'", "'}'", "'return'", "'('", 
		"')'", "'printLine'", "'fileOpen'", "'+'", "'add'", "'-'", "'subtract'", 
		"'*'", "'multiply'", "'/'", "'divide'", "'%'", "'modulo'", "'='", "'=='", 
		"'<'", "'>'", "'<='", "'>='", "'<=>'", "'int'", "'float'", "'double'", 
		"'long'", "'object'", "'boolean'", "'null'"
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(82);
				functionDeclaration();
				}
				}
				setState(87);
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
			setState(88);
			expression();
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
			setState(90);
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
			setState(92);
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
		public VariabledeclartionContext variabledeclartion() {
			return getRuleContext(VariabledeclartionContext.class,0);
		}
		public EndLineContext endLine() {
			return getRuleContext(EndLineContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ReassignmentExpressionContext reassignmentExpression() {
			return getRuleContext(ReassignmentExpressionContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
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
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				variabledeclartion();
				setState(95);
				endLine();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				assignmentExpression();
				setState(98);
				endLine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				reassignmentExpression();
				setState(101);
				endLine();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				booleanExpression();
				setState(104);
				endLine();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				primitives();
				setState(107);
				endLine();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				functionCall();
				setState(110);
				endLine();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(112);
				returnValue();
				setState(113);
				endLine();
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
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
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				variabledeclartion();
				setState(118);
				equalsign();
				setState(119);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				variabledeclartion();
				setState(122);
				equalsign();
				setState(123);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				variabledeclartion();
				setState(126);
				equalsign();
				setState(127);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				variabledeclartion();
				setState(130);
				equalsign();
				setState(131);
				primitiveTypes();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				variabledeclartion();
				setState(134);
				equalsign();
				setState(135);
				booleanExpression();
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

	public static class ReassignmentExpressionContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public EqualsignContext equalsign() {
			return getRuleContext(EqualsignContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public ReassignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reassignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterReassignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitReassignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitReassignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReassignmentExpressionContext reassignmentExpression() throws RecognitionException {
		ReassignmentExpressionContext _localctx = new ReassignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_reassignmentExpression);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				variable();
				setState(140);
				equalsign();
				setState(141);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				variable();
				setState(144);
				equalsign();
				setState(145);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				variable();
				setState(148);
				equalsign();
				setState(149);
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
		enterRule(_localctx, 14, RULE_functionCall);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				funcName();
				setState(154);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				funcName();
				{
				setState(157);
				leftParen();
				}
				setState(158);
				variable();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(159);
					match(T__2);
					setState(160);
					variable();
					}
				}

				{
				setState(163);
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
		enterRule(_localctx, 16, RULE_functionDeclaration);
		int _la;
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__3);
				setState(168);
				funcName();
				setState(169);
				match(T__1);
				setState(170);
				equalsign();
				setState(171);
				match(T__4);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << ID))) != 0)) {
					{
					{
					setState(172);
					statement();
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(178);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(T__3);
				setState(181);
				funcName();
				setState(182);
				leftParen();
				setState(183);
				variabledeclartion();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(184);
					match(T__2);
					setState(185);
					variabledeclartion();
					}
				}

				setState(188);
				rightParen();
				setState(189);
				equalsign();
				setState(190);
				match(T__4);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << ID))) != 0)) {
					{
					{
					setState(191);
					statement();
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
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
		enterRule(_localctx, 18, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_returnValue);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(T__6);
				setState(205);
				types();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(T__6);
				{
				setState(207);
				variable();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				match(T__6);
				{
				setState(209);
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
		enterRule(_localctx, 22, RULE_leftParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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
		enterRule(_localctx, 24, RULE_rightParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
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
		enterRule(_localctx, 26, RULE_booleanExpression);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				variable();
				{
				setState(217);
				comparisonOperator();
				}
				setState(218);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				variable();
				{
				setState(221);
				comparisonOperator();
				}
				setState(222);
				primitiveTypes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				variable();
				{
				setState(225);
				comparisonOperator();
				}
				setState(226);
				command();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				command();
				{
				setState(229);
				comparisonOperator();
				}
				setState(230);
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
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
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
		enterRule(_localctx, 28, RULE_primitives);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__9);
				setState(235);
				match(T__7);
				setState(236);
				types();
				setState(237);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(T__9);
				setState(240);
				match(T__7);
				setState(241);
				variable();
				setState(242);
				match(T__8);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				match(T__10);
				setState(245);
				match(T__7);
				setState(246);
				match(STRING);
				setState(247);
				match(T__8);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(T__10);
				setState(249);
				match(T__7);
				setState(250);
				variable();
				setState(251);
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
		enterRule(_localctx, 30, RULE_command);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				add();
				}
				break;
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				primitives();
				}
				break;
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				subtract();
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 4);
				{
				setState(258);
				multiply();
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(259);
				divide();
				}
				break;
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 6);
				{
				setState(260);
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
		enterRule(_localctx, 32, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 34, RULE_variabledeclartion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			keywords();
			setState(266);
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
		enterRule(_localctx, 36, RULE_add);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				summation();
				setState(269);
				types();
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(270);
					types();
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				summation();
				setState(277);
				types();
				setState(278);
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
		enterRule(_localctx, 38, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
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
		enterRule(_localctx, 40, RULE_subtract);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				subtraction();
				setState(285);
				types();
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(286);
					types();
					}
					}
					setState(291);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				subtraction();
				setState(293);
				types();
				setState(294);
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
		enterRule(_localctx, 42, RULE_subtraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
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
		enterRule(_localctx, 44, RULE_multiply);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				multiplication();
				setState(301);
				types();
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(302);
					types();
					}
					}
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				multiplication();
				setState(309);
				types();
				setState(310);
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
		enterRule(_localctx, 46, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
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
		enterRule(_localctx, 48, RULE_divide);
		int _la;
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				division();
				setState(317);
				types();
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(318);
					types();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				division();
				setState(325);
				types();
				setState(326);
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
		enterRule(_localctx, 50, RULE_division);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
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
		enterRule(_localctx, 52, RULE_modulo);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				moduli();
				setState(333);
				types();
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOLEAN) | (1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << STRING))) != 0)) {
					{
					{
					setState(334);
					types();
					}
					}
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				moduli();
				setState(341);
				types();
				setState(342);
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
		enterRule(_localctx, 54, RULE_moduli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
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
		enterRule(_localctx, 56, RULE_types);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
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
		enterRule(_localctx, 58, RULE_primitiveTypes);
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				numericTypes();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(351);
				match(STRING);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(352);
				match(BOOLEAN);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
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
		enterRule(_localctx, 60, RULE_numericTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
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
		enterRule(_localctx, 62, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(T__21);
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
		enterRule(_localctx, 64, RULE_comparisonOperator);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				equalequal();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				lessthan();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				greaterthan();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				lessthanorequalto();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 5);
				{
				setState(364);
				greaterthanorequalto();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(365);
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
		enterRule(_localctx, 66, RULE_equalequal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
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
		enterRule(_localctx, 68, RULE_lessthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
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
		enterRule(_localctx, 70, RULE_greaterthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		enterRule(_localctx, 72, RULE_lessthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		enterRule(_localctx, 74, RULE_greaterthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
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
		enterRule(_localctx, 76, RULE_threeway);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
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
		enterRule(_localctx, 78, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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
		enterRule(_localctx, 80, RULE_arrowsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u0183\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\7\2"+
		"V\n\2\f\2\16\2Y\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6v\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u008c\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\b\u009a\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a4\n\t\3\t\3\t\5"+
		"\t\u00a8\n\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00b0\n\n\f\n\16\n\u00b3\13\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\n\3\n\3\n\3\n\7\n\u00c3"+
		"\n\n\f\n\16\n\u00c6\13\n\3\n\3\n\5\n\u00ca\n\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00d5\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00eb\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0100\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u0108\n\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0112\n"+
		"\24\f\24\16\24\u0115\13\24\3\24\3\24\3\24\3\24\5\24\u011b\n\24\3\25\3"+
		"\25\3\26\3\26\3\26\7\26\u0122\n\26\f\26\16\26\u0125\13\26\3\26\3\26\3"+
		"\26\3\26\5\26\u012b\n\26\3\27\3\27\3\30\3\30\3\30\7\30\u0132\n\30\f\30"+
		"\16\30\u0135\13\30\3\30\3\30\3\30\3\30\5\30\u013b\n\30\3\31\3\31\3\32"+
		"\3\32\3\32\7\32\u0142\n\32\f\32\16\32\u0145\13\32\3\32\3\32\3\32\3\32"+
		"\5\32\u014b\n\32\3\33\3\33\3\34\3\34\3\34\7\34\u0152\n\34\f\34\16\34\u0155"+
		"\13\34\3\34\3\34\3\34\3\34\5\34\u015b\n\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\5\37\u0165\n\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\""+
		"\u0171\n\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\2\2+\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL"+
		"NPR\2\t\3\2\16\17\3\2\20\21\3\2\22\23\3\2\24\25\3\2\26\27\3\2\'*\3\2\37"+
		"$\u018c\2W\3\2\2\2\4Z\3\2\2\2\6\\\3\2\2\2\b^\3\2\2\2\nu\3\2\2\2\f\u008b"+
		"\3\2\2\2\16\u0099\3\2\2\2\20\u00a7\3\2\2\2\22\u00c9\3\2\2\2\24\u00cb\3"+
		"\2\2\2\26\u00d4\3\2\2\2\30\u00d6\3\2\2\2\32\u00d8\3\2\2\2\34\u00ea\3\2"+
		"\2\2\36\u00ff\3\2\2\2 \u0107\3\2\2\2\"\u0109\3\2\2\2$\u010b\3\2\2\2&\u011a"+
		"\3\2\2\2(\u011c\3\2\2\2*\u012a\3\2\2\2,\u012c\3\2\2\2.\u013a\3\2\2\2\60"+
		"\u013c\3\2\2\2\62\u014a\3\2\2\2\64\u014c\3\2\2\2\66\u015a\3\2\2\28\u015c"+
		"\3\2\2\2:\u015e\3\2\2\2<\u0164\3\2\2\2>\u0166\3\2\2\2@\u0168\3\2\2\2B"+
		"\u0170\3\2\2\2D\u0172\3\2\2\2F\u0174\3\2\2\2H\u0176\3\2\2\2J\u0178\3\2"+
		"\2\2L\u017a\3\2\2\2N\u017c\3\2\2\2P\u017e\3\2\2\2R\u0180\3\2\2\2TV\5\22"+
		"\n\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\3\3\2\2\2YW\3\2\2\2Z[\5"+
		"\n\6\2[\5\3\2\2\2\\]\5\b\5\2]\7\3\2\2\2^_\7\3\2\2_\t\3\2\2\2`a\5$\23\2"+
		"ab\5\6\4\2bv\3\2\2\2cd\5\f\7\2de\5\6\4\2ev\3\2\2\2fg\5\16\b\2gh\5\6\4"+
		"\2hv\3\2\2\2ij\5\34\17\2jk\5\6\4\2kv\3\2\2\2lm\5\36\20\2mn\5\6\4\2nv\3"+
		"\2\2\2op\5\20\t\2pq\5\6\4\2qv\3\2\2\2rs\5\26\f\2st\5\6\4\2tv\3\2\2\2u"+
		"`\3\2\2\2uc\3\2\2\2uf\3\2\2\2ui\3\2\2\2ul\3\2\2\2uo\3\2\2\2ur\3\2\2\2"+
		"v\13\3\2\2\2wx\5$\23\2xy\5@!\2yz\5 \21\2z\u008c\3\2\2\2{|\5$\23\2|}\5"+
		"@!\2}~\5\"\22\2~\u008c\3\2\2\2\177\u0080\5$\23\2\u0080\u0081\5@!\2\u0081"+
		"\u0082\5\20\t\2\u0082\u008c\3\2\2\2\u0083\u0084\5$\23\2\u0084\u0085\5"+
		"@!\2\u0085\u0086\5<\37\2\u0086\u008c\3\2\2\2\u0087\u0088\5$\23\2\u0088"+
		"\u0089\5@!\2\u0089\u008a\5\34\17\2\u008a\u008c\3\2\2\2\u008bw\3\2\2\2"+
		"\u008b{\3\2\2\2\u008b\177\3\2\2\2\u008b\u0083\3\2\2\2\u008b\u0087\3\2"+
		"\2\2\u008c\r\3\2\2\2\u008d\u008e\5\"\22\2\u008e\u008f\5@!\2\u008f\u0090"+
		"\5\"\22\2\u0090\u009a\3\2\2\2\u0091\u0092\5\"\22\2\u0092\u0093\5@!\2\u0093"+
		"\u0094\5\20\t\2\u0094\u009a\3\2\2\2\u0095\u0096\5\"\22\2\u0096\u0097\5"+
		"@!\2\u0097\u0098\5<\37\2\u0098\u009a\3\2\2\2\u0099\u008d\3\2\2\2\u0099"+
		"\u0091\3\2\2\2\u0099\u0095\3\2\2\2\u009a\17\3\2\2\2\u009b\u009c\5\24\13"+
		"\2\u009c\u009d\7\4\2\2\u009d\u00a8\3\2\2\2\u009e\u009f\5\24\13\2\u009f"+
		"\u00a0\5\30\r\2\u00a0\u00a3\5\"\22\2\u00a1\u00a2\7\5\2\2\u00a2\u00a4\5"+
		"\"\22\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\5\32\16\2\u00a6\u00a8\3\2\2\2\u00a7\u009b\3\2\2\2\u00a7\u009e\3"+
		"\2\2\2\u00a8\21\3\2\2\2\u00a9\u00aa\7\6\2\2\u00aa\u00ab\5\24\13\2\u00ab"+
		"\u00ac\7\4\2\2\u00ac\u00ad\5@!\2\u00ad\u00b1\7\7\2\2\u00ae\u00b0\5\4\3"+
		"\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\b\2\2\u00b5"+
		"\u00ca\3\2\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00b8\5\24\13\2\u00b8\u00b9\5"+
		"\30\r\2\u00b9\u00bc\5$\23\2\u00ba\u00bb\7\5\2\2\u00bb\u00bd\5$\23\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\32"+
		"\16\2\u00bf\u00c0\5@!\2\u00c0\u00c4\7\7\2\2\u00c1\u00c3\5\4\3\2\u00c2"+
		"\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\b\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00a9\3\2\2\2\u00c9\u00b6\3\2\2\2\u00ca\23\3\2\2"+
		"\2\u00cb\u00cc\7,\2\2\u00cc\25\3\2\2\2\u00cd\u00d5\7\t\2\2\u00ce\u00cf"+
		"\7\t\2\2\u00cf\u00d5\5:\36\2\u00d0\u00d1\7\t\2\2\u00d1\u00d5\5\"\22\2"+
		"\u00d2\u00d3\7\t\2\2\u00d3\u00d5\5\20\t\2\u00d4\u00cd\3\2\2\2\u00d4\u00ce"+
		"\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\27\3\2\2\2\u00d6"+
		"\u00d7\7\n\2\2\u00d7\31\3\2\2\2\u00d8\u00d9\7\13\2\2\u00d9\33\3\2\2\2"+
		"\u00da\u00db\5\"\22\2\u00db\u00dc\5B\"\2\u00dc\u00dd\5\"\22\2\u00dd\u00eb"+
		"\3\2\2\2\u00de\u00df\5\"\22\2\u00df\u00e0\5B\"\2\u00e0\u00e1\5<\37\2\u00e1"+
		"\u00eb\3\2\2\2\u00e2\u00e3\5\"\22\2\u00e3\u00e4\5B\"\2\u00e4\u00e5\5 "+
		"\21\2\u00e5\u00eb\3\2\2\2\u00e6\u00e7\5 \21\2\u00e7\u00e8\5B\"\2\u00e8"+
		"\u00e9\5 \21\2\u00e9\u00eb\3\2\2\2\u00ea\u00da\3\2\2\2\u00ea\u00de\3\2"+
		"\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00e6\3\2\2\2\u00eb\35\3\2\2\2\u00ec\u00ed"+
		"\7\f\2\2\u00ed\u00ee\7\n\2\2\u00ee\u00ef\5:\36\2\u00ef\u00f0\7\13\2\2"+
		"\u00f0\u0100\3\2\2\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\7\n\2\2\u00f3\u00f4"+
		"\5\"\22\2\u00f4\u00f5\7\13\2\2\u00f5\u0100\3\2\2\2\u00f6\u00f7\7\r\2\2"+
		"\u00f7\u00f8\7\n\2\2\u00f8\u00f9\7+\2\2\u00f9\u0100\7\13\2\2\u00fa\u00fb"+
		"\7\r\2\2\u00fb\u00fc\7\n\2\2\u00fc\u00fd\5\"\22\2\u00fd\u00fe\7\13\2\2"+
		"\u00fe\u0100\3\2\2\2\u00ff\u00ec\3\2\2\2\u00ff\u00f1\3\2\2\2\u00ff\u00f6"+
		"\3\2\2\2\u00ff\u00fa\3\2\2\2\u0100\37\3\2\2\2\u0101\u0108\5&\24\2\u0102"+
		"\u0108\5\36\20\2\u0103\u0108\5*\26\2\u0104\u0108\5.\30\2\u0105\u0108\5"+
		"\62\32\2\u0106\u0108\5\66\34\2\u0107\u0101\3\2\2\2\u0107\u0102\3\2\2\2"+
		"\u0107\u0103\3\2\2\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106"+
		"\3\2\2\2\u0108!\3\2\2\2\u0109\u010a\7,\2\2\u010a#\3\2\2\2\u010b\u010c"+
		"\5P)\2\u010c\u010d\5\"\22\2\u010d%\3\2\2\2\u010e\u010f\5(\25\2\u010f\u0113"+
		"\5:\36\2\u0110\u0112\5:\36\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u011b\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0116\u0117\5(\25\2\u0117\u0118\5:\36\2\u0118\u0119\5:\36\2\u0119"+
		"\u011b\3\2\2\2\u011a\u010e\3\2\2\2\u011a\u0116\3\2\2\2\u011b\'\3\2\2\2"+
		"\u011c\u011d\t\2\2\2\u011d)\3\2\2\2\u011e\u011f\5,\27\2\u011f\u0123\5"+
		":\36\2\u0120\u0122\5:\36\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u012b\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0126\u0127\5,\27\2\u0127\u0128\5:\36\2\u0128\u0129\5:\36\2\u0129"+
		"\u012b\3\2\2\2\u012a\u011e\3\2\2\2\u012a\u0126\3\2\2\2\u012b+\3\2\2\2"+
		"\u012c\u012d\t\3\2\2\u012d-\3\2\2\2\u012e\u012f\5\60\31\2\u012f\u0133"+
		"\5:\36\2\u0130\u0132\5:\36\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u013b\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0136\u0137\5\60\31\2\u0137\u0138\5:\36\2\u0138\u0139\5:\36\2\u0139"+
		"\u013b\3\2\2\2\u013a\u012e\3\2\2\2\u013a\u0136\3\2\2\2\u013b/\3\2\2\2"+
		"\u013c\u013d\t\4\2\2\u013d\61\3\2\2\2\u013e\u013f\5\64\33\2\u013f\u0143"+
		"\5:\36\2\u0140\u0142\5:\36\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u014b\3\2\2\2\u0145\u0143\3\2"+
		"\2\2\u0146\u0147\5\64\33\2\u0147\u0148\5:\36\2\u0148\u0149\5:\36\2\u0149"+
		"\u014b\3\2\2\2\u014a\u013e\3\2\2\2\u014a\u0146\3\2\2\2\u014b\63\3\2\2"+
		"\2\u014c\u014d\t\5\2\2\u014d\65\3\2\2\2\u014e\u014f\58\35\2\u014f\u0153"+
		"\5:\36\2\u0150\u0152\5:\36\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u015b\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156\u0157\58\35\2\u0157\u0158\5:\36\2\u0158\u0159\5:\36\2\u0159"+
		"\u015b\3\2\2\2\u015a\u014e\3\2\2\2\u015a\u0156\3\2\2\2\u015b\67\3\2\2"+
		"\2\u015c\u015d\t\6\2\2\u015d9\3\2\2\2\u015e\u015f\5<\37\2\u015f;\3\2\2"+
		"\2\u0160\u0165\5> \2\u0161\u0165\7+\2\2\u0162\u0165\7&\2\2\u0163\u0165"+
		"\7%\2\2\u0164\u0160\3\2\2\2\u0164\u0161\3\2\2\2\u0164\u0162\3\2\2\2\u0164"+
		"\u0163\3\2\2\2\u0165=\3\2\2\2\u0166\u0167\t\7\2\2\u0167?\3\2\2\2\u0168"+
		"\u0169\7\30\2\2\u0169A\3\2\2\2\u016a\u0171\5D#\2\u016b\u0171\5F$\2\u016c"+
		"\u0171\5H%\2\u016d\u0171\5J&\2\u016e\u0171\5L\'\2\u016f\u0171\5N(\2\u0170"+
		"\u016a\3\2\2\2\u0170\u016b\3\2\2\2\u0170\u016c\3\2\2\2\u0170\u016d\3\2"+
		"\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171C\3\2\2\2\u0172\u0173"+
		"\7\31\2\2\u0173E\3\2\2\2\u0174\u0175\7\32\2\2\u0175G\3\2\2\2\u0176\u0177"+
		"\7\33\2\2\u0177I\3\2\2\2\u0178\u0179\7\34\2\2\u0179K\3\2\2\2\u017a\u017b"+
		"\7\35\2\2\u017bM\3\2\2\2\u017c\u017d\7\36\2\2\u017dO\3\2\2\2\u017e\u017f"+
		"\t\b\2\2\u017fQ\3\2\2\2\u0180\u0181\7\34\2\2\u0181S\3\2\2\2\34Wu\u008b"+
		"\u0099\u00a3\u00a7\u00b1\u00bc\u00c4\u00c9\u00d4\u00ea\u00ff\u0107\u0113"+
		"\u011a\u0123\u012a\u0133\u013a\u0143\u014a\u0153\u015a\u0164\u0170";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}