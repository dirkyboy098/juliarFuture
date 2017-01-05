// Generated from C:\Users\AndreiM\Desktop\juliarFuture\src\com\juliar\parser\juliar.g4 by ANTLR 4.6
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
		T__24=25, T__25=26, INT=27, FLOAT=28, DOUBLE=29, LONG=30, STRING=31, ID=32, 
		WS=33, COMMENT=34, LINE_COMMENT=35;
	public static final int
		RULE_compileUnit = 0, RULE_statement = 1, RULE_endLine = 2, RULE_semiColon = 3, 
		RULE_expression = 4, RULE_assignmentExpression = 5, RULE_booleanExpression = 6, 
		RULE_primitives = 7, RULE_command = 8, RULE_ifExpr = 9, RULE_nifExpr = 10, 
		RULE_variable = 11, RULE_absolute = 12, RULE_acos = 13, RULE_acosh = 14, 
		RULE_add = 15, RULE_summation = 16, RULE_subtract = 17, RULE_subtraction = 18, 
		RULE_multiply = 19, RULE_multiplication = 20, RULE_divide = 21, RULE_division = 22, 
		RULE_types = 23, RULE_equalsign = 24, RULE_equalequal = 25, RULE_arrowsign = 26;
	public static final String[] ruleNames = {
		"compileUnit", "statement", "endLine", "semiColon", "expression", "assignmentExpression", 
		"booleanExpression", "primitives", "command", "ifExpr", "nifExpr", "variable", 
		"absolute", "acos", "acosh", "add", "summation", "subtract", "subtraction", 
		"multiply", "multiplication", "divide", "division", "types", "equalsign", 
		"equalequal", "arrowsign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'fileOpen'", "'('", "')'", "'printLine'", "'printInt'", 
		"'printFloat'", "'printDouble'", "'if'", "'{'", "'}'", "'nif'", "'absolute'", 
		"'acos'", "'acosh'", "'+'", "'add'", "'-'", "'subtract'", "'*'", "'multiply'", 
		"'/'", "'divide'", "'='", "'=='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "ID", "WS", 
		"COMMENT", "LINE_COMMENT"
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << ID))) != 0)) {
				{
				{
				setState(54);
				statement();
				}
				}
				setState(59);
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
			setState(60);
			expression();
			}
			setState(61);
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
			setState(63);
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
			setState(65);
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
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public NifExprContext nifExpr() {
			return getRuleContext(NifExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) {
					{
					{
					setState(67);
					command();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(73);
					command();
					}
					break;
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) {
					{
					{
					setState(76);
					command();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				assignmentExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				booleanExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				ifExpr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				nifExpr();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignmentExpression);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				variable();
				setState(89);
				equalsign();
				setState(90);
				command();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public EqualequalContext equalequal() {
			return getRuleContext(EqualequalContext.class,0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_booleanExpression);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				variable();
				{
				setState(99);
				equalequal();
				}
				setState(100);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				variable();
				{
				setState(103);
				equalequal();
				}
				setState(104);
				command();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				command();
				{
				setState(107);
				equalequal();
				}
				setState(108);
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
		public TerminalNode INT() { return getToken(juliarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(juliarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(juliarParser.DOUBLE, 0); }
		public PrimitivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitives; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitPrimitives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivesContext primitives() throws RecognitionException {
		PrimitivesContext _localctx = new PrimitivesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primitives);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T__1);
				setState(113);
				match(T__2);
				setState(114);
				match(STRING);
				setState(115);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__4);
				setState(117);
				match(T__2);
				setState(118);
				match(STRING);
				setState(119);
				match(T__3);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				match(T__5);
				setState(121);
				match(T__2);
				setState(122);
				match(INT);
				setState(123);
				match(T__3);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(T__6);
				setState(125);
				match(T__2);
				setState(126);
				match(FLOAT);
				setState(127);
				match(T__3);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(T__7);
				setState(129);
				match(T__2);
				setState(130);
				match(DOUBLE);
				setState(131);
				match(T__3);
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
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
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
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public NifExprContext nifExpr() {
			return getRuleContext(NifExprContext.class,0);
		}
		public AbsoluteContext absolute() {
			return getRuleContext(AbsoluteContext.class,0);
		}
		public AcosContext acos() {
			return getRuleContext(AcosContext.class,0);
		}
		public AcoshContext acosh() {
			return getRuleContext(AcoshContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				primitives();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				add();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				subtract();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				multiply();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				divide();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				ifExpr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140);
				nifExpr();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				absolute();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(142);
				acos();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(143);
				acosh();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(144);
				absolute();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(145);
				acos();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(146);
				acosh();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(147);
				add();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(148);
				subtract();
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

	public static class IfExprContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__8);
			setState(152);
			match(T__2);
			setState(153);
			booleanExpression();
			setState(154);
			match(T__3);
			setState(155);
			match(T__9);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << ID))) != 0)) {
				{
				{
				setState(156);
				statement();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(T__10);
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

	public static class NifExprContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public NifExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nifExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitNifExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NifExprContext nifExpr() throws RecognitionException {
		NifExprContext _localctx = new NifExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nifExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__11);
			setState(165);
			match(T__2);
			setState(166);
			booleanExpression();
			setState(167);
			match(T__3);
			setState(168);
			match(T__9);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << ID))) != 0)) {
				{
				{
				setState(169);
				statement();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			match(T__10);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
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
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public AbsoluteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolute; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAbsolute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsoluteContext absolute() throws RecognitionException {
		AbsoluteContext _localctx = new AbsoluteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_absolute);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__12);
				setState(180);
				types();
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(181);
					types();
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__12);
				setState(188);
				types();
				setState(189);
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

	public static class AcosContext extends ParserRuleContext {
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public AcosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAcos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcosContext acos() throws RecognitionException {
		AcosContext _localctx = new AcosContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_acos);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(T__13);
				setState(194);
				types();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(195);
					types();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(T__13);
				setState(202);
				types();
				setState(203);
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

	public static class AcoshContext extends ParserRuleContext {
		public List<TypesContext> types() {
			return getRuleContexts(TypesContext.class);
		}
		public TypesContext types(int i) {
			return getRuleContext(TypesContext.class,i);
		}
		public AcoshContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acosh; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAcosh(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcoshContext acosh() throws RecognitionException {
		AcoshContext _localctx = new AcoshContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_acosh);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(T__14);
				setState(208);
				types();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(209);
					types();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__14);
				setState(216);
				types();
				setState(217);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_add);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				summation();
				setState(222);
				types();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(223);
					types();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				summation();
				setState(230);
				types();
				setState(231);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSummation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummationContext summation() throws RecognitionException {
		SummationContext _localctx = new SummationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractContext subtract() throws RecognitionException {
		SubtractContext _localctx = new SubtractContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subtract);
		int _la;
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				subtraction();
				setState(238);
				types();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(239);
					types();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				subtraction();
				setState(246);
				types();
				setState(247);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractionContext subtraction() throws RecognitionException {
		SubtractionContext _localctx = new SubtractionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subtraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multiply);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				multiplication();
				setState(254);
				types();
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(255);
					types();
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				multiplication();
				setState(262);
				types();
				setState(263);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_divide);
		int _la;
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				division();
				setState(270);
				types();
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) {
					{
					{
					setState(271);
					types();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				division();
				setState(278);
				types();
				setState(279);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisionContext division() throws RecognitionException {
		DivisionContext _localctx = new DivisionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_division);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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
		public TerminalNode INT() { return getToken(juliarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(juliarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(juliarParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(juliarParser.LONG, 0); }
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitEqualsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualsignContext equalsign() throws RecognitionException {
		EqualsignContext _localctx = new EqualsignContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitEqualequal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualequalContext equalequal() throws RecognitionException {
		EqualequalContext _localctx = new EqualequalContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_equalequal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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

	public static class ArrowsignContext extends ParserRuleContext {
		public ArrowsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrowsign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof juliarVisitor ) return ((juliarVisitor<? extends T>)visitor).visitArrowsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrowsignContext arrowsign() throws RecognitionException {
		ArrowsignContext _localctx = new ArrowsignContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arrowsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\3\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\7\6G\n\6\f\6\16\6J\13\6\3\6\5\6M\n\6\3\6\7\6P\n\6"+
		"\f\6\16\6S\13\6\3\6\3\6\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7c\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bq\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u0087\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0098\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a0\n"+
		"\13\f\13\16\13\u00a3\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ad"+
		"\n\f\f\f\16\f\u00b0\13\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u00b9\n\16"+
		"\f\16\16\16\u00bc\13\16\3\16\3\16\3\16\3\16\5\16\u00c2\n\16\3\17\3\17"+
		"\3\17\7\17\u00c7\n\17\f\17\16\17\u00ca\13\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00d0\n\17\3\20\3\20\3\20\7\20\u00d5\n\20\f\20\16\20\u00d8\13\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00de\n\20\3\21\3\21\3\21\7\21\u00e3\n\21\f\21\16"+
		"\21\u00e6\13\21\3\21\3\21\3\21\3\21\5\21\u00ec\n\21\3\22\3\22\3\23\3\23"+
		"\3\23\7\23\u00f3\n\23\f\23\16\23\u00f6\13\23\3\23\3\23\3\23\3\23\5\23"+
		"\u00fc\n\23\3\24\3\24\3\25\3\25\3\25\7\25\u0103\n\25\f\25\16\25\u0106"+
		"\13\25\3\25\3\25\3\25\3\25\5\25\u010c\n\25\3\26\3\26\3\27\3\27\3\27\7"+
		"\27\u0113\n\27\f\27\16\27\u0116\13\27\3\27\3\27\3\27\3\27\5\27\u011c\n"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\2\2\35\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\7\3\2\22\23"+
		"\3\2\24\25\3\2\26\27\3\2\30\31\3\2\35 \u013a\2;\3\2\2\2\4>\3\2\2\2\6A"+
		"\3\2\2\2\bC\3\2\2\2\nX\3\2\2\2\fb\3\2\2\2\16p\3\2\2\2\20\u0086\3\2\2\2"+
		"\22\u0097\3\2\2\2\24\u0099\3\2\2\2\26\u00a6\3\2\2\2\30\u00b3\3\2\2\2\32"+
		"\u00c1\3\2\2\2\34\u00cf\3\2\2\2\36\u00dd\3\2\2\2 \u00eb\3\2\2\2\"\u00ed"+
		"\3\2\2\2$\u00fb\3\2\2\2&\u00fd\3\2\2\2(\u010b\3\2\2\2*\u010d\3\2\2\2,"+
		"\u011b\3\2\2\2.\u011d\3\2\2\2\60\u011f\3\2\2\2\62\u0121\3\2\2\2\64\u0123"+
		"\3\2\2\2\66\u0125\3\2\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3"+
		"\2\2\2<\3\3\2\2\2=;\3\2\2\2>?\5\n\6\2?@\5\6\4\2@\5\3\2\2\2AB\5\b\5\2B"+
		"\7\3\2\2\2CD\7\3\2\2D\t\3\2\2\2EG\5\22\n\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2"+
		"\2HI\3\2\2\2IY\3\2\2\2JH\3\2\2\2KM\5\22\n\2LK\3\2\2\2LM\3\2\2\2MQ\3\2"+
		"\2\2NP\5\22\n\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RY\3\2\2\2SQ\3"+
		"\2\2\2TY\5\f\7\2UY\5\16\b\2VY\5\24\13\2WY\5\26\f\2XH\3\2\2\2XL\3\2\2\2"+
		"XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\13\3\2\2\2Z[\5\30\r\2[\\\5\62"+
		"\32\2\\]\5\22\n\2]c\3\2\2\2^_\5\30\r\2_`\5\62\32\2`a\5\30\r\2ac\3\2\2"+
		"\2bZ\3\2\2\2b^\3\2\2\2c\r\3\2\2\2de\5\30\r\2ef\5\64\33\2fg\5\30\r\2gq"+
		"\3\2\2\2hi\5\30\r\2ij\5\64\33\2jk\5\22\n\2kq\3\2\2\2lm\5\22\n\2mn\5\64"+
		"\33\2no\5\22\n\2oq\3\2\2\2pd\3\2\2\2ph\3\2\2\2pl\3\2\2\2q\17\3\2\2\2r"+
		"s\7\4\2\2st\7\5\2\2tu\7!\2\2u\u0087\7\6\2\2vw\7\7\2\2wx\7\5\2\2xy\7!\2"+
		"\2y\u0087\7\6\2\2z{\7\b\2\2{|\7\5\2\2|}\7\35\2\2}\u0087\7\6\2\2~\177\7"+
		"\t\2\2\177\u0080\7\5\2\2\u0080\u0081\7\36\2\2\u0081\u0087\7\6\2\2\u0082"+
		"\u0083\7\n\2\2\u0083\u0084\7\5\2\2\u0084\u0085\7\37\2\2\u0085\u0087\7"+
		"\6\2\2\u0086r\3\2\2\2\u0086v\3\2\2\2\u0086z\3\2\2\2\u0086~\3\2\2\2\u0086"+
		"\u0082\3\2\2\2\u0087\21\3\2\2\2\u0088\u0098\5\20\t\2\u0089\u0098\5 \21"+
		"\2\u008a\u0098\5$\23\2\u008b\u0098\5(\25\2\u008c\u0098\5,\27\2\u008d\u0098"+
		"\5\24\13\2\u008e\u0098\5\26\f\2\u008f\u0098\5\32\16\2\u0090\u0098\5\34"+
		"\17\2\u0091\u0098\5\36\20\2\u0092\u0098\5\32\16\2\u0093\u0098\5\34\17"+
		"\2\u0094\u0098\5\36\20\2\u0095\u0098\5 \21\2\u0096\u0098\5$\23\2\u0097"+
		"\u0088\3\2\2\2\u0097\u0089\3\2\2\2\u0097\u008a\3\2\2\2\u0097\u008b\3\2"+
		"\2\2\u0097\u008c\3\2\2\2\u0097\u008d\3\2\2\2\u0097\u008e\3\2\2\2\u0097"+
		"\u008f\3\2\2\2\u0097\u0090\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0092\3\2"+
		"\2\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\23\3\2\2\2\u0099\u009a\7\13\2\2\u009a\u009b\7\5\2"+
		"\2\u009b\u009c\5\16\b\2\u009c\u009d\7\6\2\2\u009d\u00a1\7\f\2\2\u009e"+
		"\u00a0\5\4\3\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\7\r\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\16\2\2\u00a7\u00a8\7\5\2"+
		"\2\u00a8\u00a9\5\16\b\2\u00a9\u00aa\7\6\2\2\u00aa\u00ae\7\f\2\2\u00ab"+
		"\u00ad\5\4\3\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7\r\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\7\"\2\2\u00b4\31\3\2\2\2\u00b5"+
		"\u00b6\7\17\2\2\u00b6\u00ba\5\60\31\2\u00b7\u00b9\5\60\31\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00c2\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\17\2\2\u00be\u00bf\5"+
		"\60\31\2\u00bf\u00c0\5\60\31\2\u00c0\u00c2\3\2\2\2\u00c1\u00b5\3\2\2\2"+
		"\u00c1\u00bd\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c4\7\20\2\2\u00c4\u00c8"+
		"\5\60\31\2\u00c5\u00c7\5\60\31\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2"+
		"\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00d0\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00cb\u00cc\7\20\2\2\u00cc\u00cd\5\60\31\2\u00cd\u00ce\5\60\31"+
		"\2\u00ce\u00d0\3\2\2\2\u00cf\u00c3\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0\35"+
		"\3\2\2\2\u00d1\u00d2\7\21\2\2\u00d2\u00d6\5\60\31\2\u00d3\u00d5\5\60\31"+
		"\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00de\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\21\2\2"+
		"\u00da\u00db\5\60\31\2\u00db\u00dc\5\60\31\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00d1\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\37\3\2\2\2\u00df\u00e0\5\"\22"+
		"\2\u00e0\u00e4\5\60\31\2\u00e1\u00e3\5\60\31\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00ec\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\5\"\22\2\u00e8\u00e9\5\60\31\2\u00e9"+
		"\u00ea\5\60\31\2\u00ea\u00ec\3\2\2\2\u00eb\u00df\3\2\2\2\u00eb\u00e7\3"+
		"\2\2\2\u00ec!\3\2\2\2\u00ed\u00ee\t\2\2\2\u00ee#\3\2\2\2\u00ef\u00f0\5"+
		"&\24\2\u00f0\u00f4\5\60\31\2\u00f1\u00f3\5\60\31\2\u00f2\u00f1\3\2\2\2"+
		"\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00fc"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\5&\24\2\u00f8\u00f9\5\60\31\2"+
		"\u00f9\u00fa\5\60\31\2\u00fa\u00fc\3\2\2\2\u00fb\u00ef\3\2\2\2\u00fb\u00f7"+
		"\3\2\2\2\u00fc%\3\2\2\2\u00fd\u00fe\t\3\2\2\u00fe\'\3\2\2\2\u00ff\u0100"+
		"\5*\26\2\u0100\u0104\5\60\31\2\u0101\u0103\5\60\31\2\u0102\u0101\3\2\2"+
		"\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u010c"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\5*\26\2\u0108\u0109\5\60\31\2"+
		"\u0109\u010a\5\60\31\2\u010a\u010c\3\2\2\2\u010b\u00ff\3\2\2\2\u010b\u0107"+
		"\3\2\2\2\u010c)\3\2\2\2\u010d\u010e\t\4\2\2\u010e+\3\2\2\2\u010f\u0110"+
		"\5.\30\2\u0110\u0114\5\60\31\2\u0111\u0113\5\60\31\2\u0112\u0111\3\2\2"+
		"\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011c"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\5.\30\2\u0118\u0119\5\60\31\2"+
		"\u0119\u011a\5\60\31\2\u011a\u011c\3\2\2\2\u011b\u010f\3\2\2\2\u011b\u0117"+
		"\3\2\2\2\u011c-\3\2\2\2\u011d\u011e\t\5\2\2\u011e/\3\2\2\2\u011f\u0120"+
		"\t\6\2\2\u0120\61\3\2\2\2\u0121\u0122\7\32\2\2\u0122\63\3\2\2\2\u0123"+
		"\u0124\7\33\2\2\u0124\65\3\2\2\2\u0125\u0126\7\34\2\2\u0126\67\3\2\2\2"+
		"\33;HLQXbp\u0086\u0097\u00a1\u00ae\u00ba\u00c1\u00c8\u00cf\u00d6\u00dd"+
		"\u00e4\u00eb\u00f4\u00fb\u0104\u010b\u0114\u011b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}