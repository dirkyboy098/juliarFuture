// Generated from /Users/donreamey/github/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT=6, FLOAT=7, DOUBLE=8, LONG=9, 
		STRING=10, ID=11, WS=12;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_startLine = 2, RULE_endLine = 3, 
		RULE_asterisk = 4, RULE_expression = 5, RULE_assignmentExpression = 6, 
		RULE_booleanExpression = 7, RULE_command = 8, RULE_variable = 9, RULE_absolute = 10, 
		RULE_acos = 11, RULE_acosh = 12, RULE_add = 13, RULE_summation = 14, RULE_minus = 15, 
		RULE_subtract = 16, RULE_types = 17, RULE_equalsign = 18;
	public static final String[] ruleNames = {
		"compileUnit", "statement", "startLine", "endLine", "asterisk", "expression", 
		"assignmentExpression", "booleanExpression", "command", "variable", "absolute", 
		"acos", "acosh", "add", "summation", "minus", "subtract", "types", "equalsign"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(38);
				statement();
				}
				}
				setState(43);
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
		public StartLineContext startLine() {
			return getRuleContext(StartLineContext.class,0);
		}
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
			setState(44);
			startLine();
			{
			setState(45);
			expression();
			}
			setState(46);
			endLine();
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

	public static class StartLineContext extends ParserRuleContext {
		public AsteriskContext asterisk() {
			return getRuleContext(AsteriskContext.class,0);
		}
		public StartLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterStartLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitStartLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitStartLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartLineContext startLine() throws RecognitionException {
		StartLineContext _localctx = new StartLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_startLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			asterisk();
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
		public AsteriskContext asterisk() {
			return getRuleContext(AsteriskContext.class,0);
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
		enterRule(_localctx, 6, RULE_endLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			asterisk();
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

	public static class AsteriskContext extends ParserRuleContext {
		public AsteriskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asterisk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAsterisk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAsterisk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAsterisk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsteriskContext asterisk() throws RecognitionException {
		AsteriskContext _localctx = new AsteriskContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asterisk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
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
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
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
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1 || _la==T__2) {
					{
					{
					setState(54);
					command();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(60);
					assignmentExpression();
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(66);
					booleanExpression();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			variable();
			setState(75);
			equalsign();
			setState(76);
			command();
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
		public List<EqualsignContext> equalsign() {
			return getRuleContexts(EqualsignContext.class);
		}
		public EqualsignContext equalsign(int i) {
			return getRuleContext(EqualsignContext.class,i);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
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
		enterRule(_localctx, 14, RULE_booleanExpression);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				variable();
				{
				setState(79);
				equalsign();
				}
				{
				setState(80);
				equalsign();
				}
				setState(81);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				variable();
				{
				setState(84);
				equalsign();
				}
				{
				setState(85);
				equalsign();
				}
				setState(86);
				command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				variable();
				{
				setState(89);
				equalsign();
				}
				{
				setState(90);
				equalsign();
				}
				setState(91);
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

	public static class CommandContext extends ParserRuleContext {
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
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
		enterRule(_localctx, 16, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			add();
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
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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

	public static class AbsoluteContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(juliarParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(juliarParser.FLOAT, i);
		}
		public AbsoluteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAbsolute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAbsolute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAbsolute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsoluteContext absolute() throws RecognitionException {
		AbsoluteContext _localctx = new AbsoluteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_absolute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FLOAT) {
				{
				{
				setState(100);
				match(FLOAT);
				}
				}
				setState(105);
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

	public static class AcosContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(juliarParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(juliarParser.FLOAT, i);
		}
		public AcosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAcos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAcos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAcos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcosContext acos() throws RecognitionException {
		AcosContext _localctx = new AcosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_acos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(ID);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FLOAT) {
				{
				{
				setState(107);
				match(FLOAT);
				}
				}
				setState(112);
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

	public static class AcoshContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(juliarParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(juliarParser.FLOAT, i);
		}
		public AcoshContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acosh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterAcosh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitAcosh(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAcosh(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcoshContext acosh() throws RecognitionException {
		AcoshContext _localctx = new AcoshContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_acosh);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FLOAT) {
				{
				{
				setState(114);
				match(FLOAT);
				}
				}
				setState(119);
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
		enterRule(_localctx, 26, RULE_add);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				summation();
				setState(121);
				types();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(122);
					types();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				summation();
				setState(129);
				types();
				setState(130);
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
		enterRule(_localctx, 28, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class MinusContext extends ParserRuleContext {
		public MinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof juliarListener ) ((juliarListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MinusContext minus() throws RecognitionException {
		MinusContext _localctx = new MinusContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_minus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__3);
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
		public TerminalNode ID() { return getToken(juliarParser.ID, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(juliarParser.FLOAT); }
		public TerminalNode FLOAT(int i) {
			return getToken(juliarParser.FLOAT, i);
		}
		public List<TerminalNode> INT() { return getTokens(juliarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(juliarParser.INT, i);
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
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(ID);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FLOAT) {
					{
					{
					setState(139);
					match(FLOAT);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(ID);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT) {
					{
					{
					setState(146);
					match(INT);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(ID);
				setState(153);
				match(INT);
				setState(154);
				match(INT);
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

	public static class TypesContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(juliarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(juliarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(juliarParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(juliarParser.LONG, 0); }
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
		enterRule(_localctx, 34, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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
		enterRule(_localctx, 36, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__4);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\u00a4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\7\7:\n\7\f\7\16\7=\13\7\3\7\7\7@\n\7\f\7\16\7C"+
		"\13\7\3\7\7\7F\n\7\f\7\16\7I\13\7\5\7K\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\7\fh\n\f\f\f\16\fk\13\f\3\r\3\r\7\ro\n\r\f\r\16\rr\13\r"+
		"\3\16\3\16\7\16v\n\16\f\16\16\16y\13\16\3\17\3\17\3\17\7\17~\n\17\f\17"+
		"\16\17\u0081\13\17\3\17\3\17\3\17\3\17\5\17\u0087\n\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\7\22\u008f\n\22\f\22\16\22\u0092\13\22\3\22\3\22\7\22"+
		"\u0096\n\22\f\22\16\22\u0099\13\22\3\22\3\22\3\22\5\22\u009e\n\22\3\23"+
		"\3\23\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&\2\4\3\2\4\5\3\2\b\13\u00a1\2+\3\2\2\2\4.\3\2\2\2\6\62\3\2\2\2\b\64"+
		"\3\2\2\2\n\66\3\2\2\2\fJ\3\2\2\2\16L\3\2\2\2\20_\3\2\2\2\22a\3\2\2\2\24"+
		"c\3\2\2\2\26e\3\2\2\2\30l\3\2\2\2\32s\3\2\2\2\34\u0086\3\2\2\2\36\u0088"+
		"\3\2\2\2 \u008a\3\2\2\2\"\u009d\3\2\2\2$\u009f\3\2\2\2&\u00a1\3\2\2\2"+
		"(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2"+
		"\2./\5\6\4\2/\60\5\f\7\2\60\61\5\b\5\2\61\5\3\2\2\2\62\63\5\n\6\2\63\7"+
		"\3\2\2\2\64\65\5\n\6\2\65\t\3\2\2\2\66\67\7\3\2\2\67\13\3\2\2\28:\5\22"+
		"\n\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<K\3\2\2\2=;\3\2\2\2>@\5\16"+
		"\b\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BK\3\2\2\2CA\3\2\2\2DF\5\20"+
		"\t\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2J;\3\2"+
		"\2\2JA\3\2\2\2JG\3\2\2\2K\r\3\2\2\2LM\5\24\13\2MN\5&\24\2NO\5\22\n\2O"+
		"\17\3\2\2\2PQ\5\24\13\2QR\5&\24\2RS\5&\24\2ST\5\24\13\2T`\3\2\2\2UV\5"+
		"\24\13\2VW\5&\24\2WX\5&\24\2XY\5\22\n\2Y`\3\2\2\2Z[\5\24\13\2[\\\5&\24"+
		"\2\\]\5&\24\2]^\5\24\13\2^`\3\2\2\2_P\3\2\2\2_U\3\2\2\2_Z\3\2\2\2`\21"+
		"\3\2\2\2ab\5\34\17\2b\23\3\2\2\2cd\7\r\2\2d\25\3\2\2\2ei\7\r\2\2fh\7\t"+
		"\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\27\3\2\2\2ki\3\2\2\2lp\7"+
		"\r\2\2mo\7\t\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\31\3\2\2\2r"+
		"p\3\2\2\2sw\7\r\2\2tv\7\t\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2"+
		"x\33\3\2\2\2yw\3\2\2\2z{\5\36\20\2{\177\5$\23\2|~\5$\23\2}|\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0087\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\u0083\5\36\20\2\u0083\u0084\5$\23\2\u0084\u0085\5$\23\2"+
		"\u0085\u0087\3\2\2\2\u0086z\3\2\2\2\u0086\u0082\3\2\2\2\u0087\35\3\2\2"+
		"\2\u0088\u0089\t\2\2\2\u0089\37\3\2\2\2\u008a\u008b\7\6\2\2\u008b!\3\2"+
		"\2\2\u008c\u0090\7\r\2\2\u008d\u008f\7\t\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009e\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0097\7\r\2\2\u0094\u0096\7\b\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009e\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\r\2\2\u009b"+
		"\u009c\7\b\2\2\u009c\u009e\7\b\2\2\u009d\u008c\3\2\2\2\u009d\u0093\3\2"+
		"\2\2\u009d\u009a\3\2\2\2\u009e#\3\2\2\2\u009f\u00a0\t\3\2\2\u00a0%\3\2"+
		"\2\2\u00a1\u00a2\7\7\2\2\u00a2\'\3\2\2\2\20+;AGJ_ipw\177\u0086\u0090\u0097"+
		"\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}