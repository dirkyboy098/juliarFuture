// Generated from src\com\juliar\parser\Juliar.g4 by ANTLR 4.7
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
public class JuliarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, Break=61, Do=62, Instanceof=63, Typeof=64, Case=65, Else=66, 
		New=67, Var=68, Catch=69, Finally=70, Return=71, Void=72, Continue=73, 
		For=74, Switch=75, While=76, Debugger=77, Function=78, This=79, With=80, 
		Default=81, If=82, Throw=83, Delete=84, In=85, Try=86, DecimalLiteral=87, 
		NULL=88, BOOLEAN=89, INT=90, FLOAT=91, DOUBLE=92, LONG=93, ESC_CHARS=94, 
		STRING=95, ID=96, WS=97, COMMENT=98, LINE_COMMENT=99, StringLiteral=100, 
		LineTerminator=101;
	public static final int
		RULE_compileUnit = 0, RULE_classifications = 1, RULE_statement = 2, RULE_endLine = 3, 
		RULE_semiColon = 4, RULE_expression = 5, RULE_functionCall = 6, RULE_functionDeclaration = 7, 
		RULE_funcName = 8, RULE_returnValue = 9, RULE_leftParen = 10, RULE_rightParen = 11, 
		RULE_booleanExpression = 12, RULE_primitives = 13, RULE_command = 14, 
		RULE_userDefinedTypeDecl = 15, RULE_userDefinedTypeKeyWord = 16, RULE_userDefinedTypeName = 17, 
		RULE_variable = 18, RULE_variableDeclaration = 19, RULE_userDefinedTypeVariableDecl = 20, 
		RULE_userDefinedTypeVariableReference = 21, RULE_userDefinedTypeFunctionReference = 22, 
		RULE_add = 23, RULE_summation = 24, RULE_subtract = 25, RULE_subtraction = 26, 
		RULE_multiply = 27, RULE_multiplication = 28, RULE_breakKeyWord = 29, 
		RULE_divide = 30, RULE_division = 31, RULE_modulo = 32, RULE_moduli = 33, 
		RULE_types = 34, RULE_primitiveTypes = 35, RULE_numericTypes = 36, RULE_equalsign = 37, 
		RULE_comparisonOperator = 38, RULE_bitWiseOperators = 39, RULE_equalequal = 40, 
		RULE_lessthan = 41, RULE_greaterthan = 42, RULE_lessthanorequalto = 43, 
		RULE_greaterthanorequalto = 44, RULE_booleanAndOperator = 45, RULE_booleanOrOperator = 46, 
		RULE_notOperator = 47, RULE_bitAnd = 48, RULE_bitOr = 49, RULE_bitXor = 50, 
		RULE_bitNot = 51, RULE_bitLeftShift = 52, RULE_bitRigthShift = 53, RULE_keywords = 54, 
		RULE_ifExpr = 55, RULE_whileExpression = 56, RULE_doWhileExpr = 57, RULE_userDefinedTypeResolutionOperator = 58, 
		RULE_expressionSequence = 59, RULE_identifierName = 60, RULE_singleExpression = 61, 
		RULE_assignmentExpression = 62, RULE_reassignmentExpression = 63, RULE_assignmentOperator = 64, 
		RULE_literal = 65;
	public static final String[] ruleNames = {
		"compileUnit", "classifications", "statement", "endLine", "semiColon", 
		"expression", "functionCall", "functionDeclaration", "funcName", "returnValue", 
		"leftParen", "rightParen", "booleanExpression", "primitives", "command", 
		"userDefinedTypeDecl", "userDefinedTypeKeyWord", "userDefinedTypeName", 
		"variable", "variableDeclaration", "userDefinedTypeVariableDecl", "userDefinedTypeVariableReference", 
		"userDefinedTypeFunctionReference", "add", "summation", "subtract", "subtraction", 
		"multiply", "multiplication", "breakKeyWord", "divide", "division", "modulo", 
		"moduli", "types", "primitiveTypes", "numericTypes", "equalsign", "comparisonOperator", 
		"bitWiseOperators", "equalequal", "lessthan", "greaterthan", "lessthanorequalto", 
		"greaterthanorequalto", "booleanAndOperator", "booleanOrOperator", "notOperator", 
		"bitAnd", "bitOr", "bitXor", "bitNot", "bitLeftShift", "bitRigthShift", 
		"keywords", "ifExpr", "whileExpression", "doWhileExpr", "userDefinedTypeResolutionOperator", 
		"expressionSequence", "identifierName", "singleExpression", "assignmentExpression", 
		"reassignmentExpression", "assignmentOperator", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'()'", "','", "'{'", "'}'", "'('", "')'", "'sysExec'", "'class'", 
		"'+'", "'add'", "'-'", "'subtract'", "'*'", "'multiply'", "'/'", "'divide'", 
		"'%'", "'modulo'", "'='", "'=='", "'<'", "'>'", "'<='", "'>='", "'&&'", 
		"'||'", "'!'", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'int'", "'float'", 
		"'double'", "'long'", "'object'", "'boolean'", "'string'", "'::'", "'['", 
		"']'", "'.'", "'++'", "'--'", "'?'", "':'", "'*='", "'/='", "'%='", "'+='", 
		"'-='", "'<<='", "'>>='", "'>>>='", "'&='", "'^='", "'|='", "'break'", 
		"'do'", "'instanceof'", "'typeof'", "'case'", "'else'", "'new'", "'var'", 
		"'catch'", "'finally'", "'return'", "'void'", "'continue'", "'for'", "'switch'", 
		"'while'", "'debugger'", "'function'", "'this'", "'with'", "'default'", 
		"'if'", "'throw'", "'delete'", "'in'", "'try'", null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "Break", "Do", "Instanceof", "Typeof", "Case", "Else", "New", "Var", 
		"Catch", "Finally", "Return", "Void", "Continue", "For", "Switch", "While", 
		"Debugger", "Function", "This", "With", "Default", "If", "Throw", "Delete", 
		"In", "Try", "DecimalLiteral", "NULL", "BOOLEAN", "INT", "FLOAT", "DOUBLE", 
		"LONG", "ESC_CHARS", "STRING", "ID", "WS", "COMMENT", "LINE_COMMENT", 
		"StringLiteral", "LineTerminator"
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
	public String getGrammarFileName() { return "Juliar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JuliarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompileUnitContext extends ParserRuleContext {
		public List<ClassificationsContext> classifications() {
			return getRuleContexts(ClassificationsContext.class);
		}
		public ClassificationsContext classifications(int i) {
			return getRuleContext(ClassificationsContext.class,i);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitCompileUnit(this);
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
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==Function) {
				{
				{
				setState(132);
				classifications();
				}
				}
				setState(137);
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

	public static class ClassificationsContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public UserDefinedTypeDeclContext userDefinedTypeDecl() {
			return getRuleContext(UserDefinedTypeDeclContext.class,0);
		}
		public ClassificationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classifications; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitClassifications(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassificationsContext classifications() throws RecognitionException {
		ClassificationsContext _localctx = new ClassificationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classifications);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Function:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				functionDeclaration();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				userDefinedTypeDecl();
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

	public static class StatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(142);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitEndLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndLineContext endLine() throws RecognitionException {
		EndLineContext _localctx = new EndLineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_endLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitSemiColon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemiColonContext semiColon() throws RecognitionException {
		SemiColonContext _localctx = new SemiColonContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_semiColon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
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
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public EndLineContext endLine() {
			return getRuleContext(EndLineContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public WhileExpressionContext whileExpression() {
			return getRuleContext(WhileExpressionContext.class,0);
		}
		public DoWhileExprContext doWhileExpr() {
			return getRuleContext(DoWhileExprContext.class,0);
		}
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public UserDefinedTypeFunctionReferenceContext userDefinedTypeFunctionReference() {
			return getRuleContext(UserDefinedTypeFunctionReferenceContext.class,0);
		}
		public UserDefinedTypeVariableReferenceContext userDefinedTypeVariableReference() {
			return getRuleContext(UserDefinedTypeVariableReferenceContext.class,0);
		}
		public ReturnValueContext returnValue() {
			return getRuleContext(ReturnValueContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				singleExpression(0);
				setState(149);
				endLine();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				ifExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				whileExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				doWhileExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				primitives();
				setState(155);
				endLine();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				functionCall();
				setState(158);
				endLine();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(160);
				userDefinedTypeFunctionReference();
				setState(161);
				endLine();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				userDefinedTypeVariableReference();
				setState(164);
				endLine();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(166);
				returnValue();
				setState(167);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public LeftParenContext leftParen() {
			return getRuleContext(LeftParenContext.class,0);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(JuliarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JuliarParser.WS, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode STRING() { return getToken(JuliarParser.STRING, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionCall);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				funcName();
				setState(172);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				funcName();
				{
				setState(175);
				leftParen();
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(176);
					match(WS);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(182);
				rightParen();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				funcName();
				{
				setState(185);
				leftParen();
				}
				setState(186);
				variable();
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(187);
					match(T__2);
					setState(188);
					variable();
					}
				}

				{
				setState(191);
				rightParen();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				funcName();
				{
				setState(194);
				leftParen();
				}
				setState(195);
				match(STRING);
				{
				setState(196);
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
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public RightParenContext rightParen() {
			return getRuleContext(RightParenContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(Function);
				setState(201);
				funcName();
				setState(202);
				match(T__1);
				setState(203);
				equalsign();
				setState(204);
				match(T__3);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
					{
					{
					setState(205);
					statement();
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(Function);
				setState(214);
				funcName();
				setState(215);
				leftParen();
				setState(216);
				variableDeclaration();
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(217);
					match(T__2);
					setState(218);
					variableDeclaration();
					}
				}

				setState(221);
				rightParen();
				setState(222);
				equalsign();
				setState(223);
				match(T__3);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
					{
					{
					setState(224);
					statement();
					}
					}
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(230);
				match(T__4);
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
		public TerminalNode ID() { return getToken(JuliarParser.ID, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitReturnValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnValueContext returnValue() throws RecognitionException {
		ReturnValueContext _localctx = new ReturnValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnValue);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(Return);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(Return);
				setState(238);
				types();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(Return);
				{
				setState(240);
				variable();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				match(Return);
				{
				setState(242);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitLeftParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftParenContext leftParen() throws RecognitionException {
		LeftParenContext _localctx = new LeftParenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_leftParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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

	public static class RightParenContext extends ParserRuleContext {
		public RightParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightParen; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitRightParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightParenContext rightParen() throws RecognitionException {
		RightParenContext _localctx = new RightParenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rightParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__6);
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
		public TerminalNode BOOLEAN() { return getToken(JuliarParser.BOOLEAN, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public UserDefinedTypeVariableReferenceContext userDefinedTypeVariableReference() {
			return getRuleContext(UserDefinedTypeVariableReferenceContext.class,0);
		}
		public UserDefinedTypeFunctionReferenceContext userDefinedTypeFunctionReference() {
			return getRuleContext(UserDefinedTypeFunctionReferenceContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				{
				setState(249);
				match(BOOLEAN);
				}
				break;
			case ID:
				{
				setState(250);
				variable();
				}
				break;
			case T__7:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				{
				setState(251);
				command();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			{
			setState(254);
			comparisonOperator();
			}
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(255);
				variable();
				}
				break;
			case 2:
				{
				setState(256);
				primitiveTypes();
				}
				break;
			case 3:
				{
				setState(257);
				command();
				}
				break;
			case 4:
				{
				setState(258);
				userDefinedTypeVariableReference();
				}
				break;
			case 5:
				{
				setState(259);
				userDefinedTypeFunctionReference();
				}
				break;
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

	public static class PrimitivesContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JuliarParser.STRING, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PrimitivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitives; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitPrimitives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivesContext primitives() throws RecognitionException {
		PrimitivesContext _localctx = new PrimitivesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitives);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(T__7);
				setState(263);
				match(T__5);
				setState(264);
				match(STRING);
				setState(265);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(T__7);
				setState(267);
				match(T__5);
				setState(268);
				variable();
				setState(269);
				match(T__6);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_command);
		try {
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				add();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				primitives();
				}
				break;
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				subtract();
				}
				break;
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				multiply();
				}
				break;
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(277);
				divide();
				}
				break;
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 6);
				{
				setState(278);
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

	public static class UserDefinedTypeDeclContext extends ParserRuleContext {
		public UserDefinedTypeKeyWordContext userDefinedTypeKeyWord() {
			return getRuleContext(UserDefinedTypeKeyWordContext.class,0);
		}
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
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
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public UserDefinedTypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeDeclContext userDefinedTypeDecl() throws RecognitionException {
		UserDefinedTypeDeclContext _localctx = new UserDefinedTypeDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_userDefinedTypeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			userDefinedTypeKeyWord();
			setState(282);
			userDefinedTypeName();
			setState(283);
			equalsign();
			setState(284);
			match(T__3);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
				{
				{
				setState(285);
				statement();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Function) {
				{
				{
				setState(291);
				functionDeclaration();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
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

	public static class UserDefinedTypeKeyWordContext extends ParserRuleContext {
		public UserDefinedTypeKeyWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeKeyWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeKeyWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeKeyWordContext userDefinedTypeKeyWord() throws RecognitionException {
		UserDefinedTypeKeyWordContext _localctx = new UserDefinedTypeKeyWordContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_userDefinedTypeKeyWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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

	public static class UserDefinedTypeNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JuliarParser.ID, 0); }
		public UserDefinedTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeNameContext userDefinedTypeName() throws RecognitionException {
		UserDefinedTypeNameContext _localctx = new UserDefinedTypeNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_userDefinedTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JuliarParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public UserDefinedTypeVariableDeclContext userDefinedTypeVariableDecl() {
			return getRuleContext(UserDefinedTypeVariableDeclContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variableDeclaration);
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				keywords();
				setState(306);
				variable();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				userDefinedTypeVariableDecl();
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

	public static class UserDefinedTypeVariableDeclContext extends ParserRuleContext {
		public List<UserDefinedTypeNameContext> userDefinedTypeName() {
			return getRuleContexts(UserDefinedTypeNameContext.class);
		}
		public UserDefinedTypeNameContext userDefinedTypeName(int i) {
			return getRuleContext(UserDefinedTypeNameContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(JuliarParser.ID, 0); }
		public EqualsignContext equalsign() {
			return getRuleContext(EqualsignContext.class,0);
		}
		public TerminalNode New() { return getToken(JuliarParser.New, 0); }
		public UserDefinedTypeVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeVariableDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeVariableDeclContext userDefinedTypeVariableDecl() throws RecognitionException {
		UserDefinedTypeVariableDeclContext _localctx = new UserDefinedTypeVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_userDefinedTypeVariableDecl);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				userDefinedTypeName();
				setState(312);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				userDefinedTypeName();
				setState(315);
				match(ID);
				setState(316);
				equalsign();
				{
				setState(317);
				match(New);
				setState(318);
				userDefinedTypeName();
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

	public static class UserDefinedTypeVariableReferenceContext extends ParserRuleContext {
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public UserDefinedTypeResolutionOperatorContext userDefinedTypeResolutionOperator() {
			return getRuleContext(UserDefinedTypeResolutionOperatorContext.class,0);
		}
		public UserDefinedTypeVariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeVariableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeVariableReferenceContext userDefinedTypeVariableReference() throws RecognitionException {
		UserDefinedTypeVariableReferenceContext _localctx = new UserDefinedTypeVariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_userDefinedTypeVariableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			userDefinedTypeName();
			{
			setState(323);
			userDefinedTypeResolutionOperator();
			}
			setState(324);
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

	public static class UserDefinedTypeFunctionReferenceContext extends ParserRuleContext {
		public UserDefinedTypeNameContext userDefinedTypeName() {
			return getRuleContext(UserDefinedTypeNameContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public UserDefinedTypeResolutionOperatorContext userDefinedTypeResolutionOperator() {
			return getRuleContext(UserDefinedTypeResolutionOperatorContext.class,0);
		}
		public UserDefinedTypeFunctionReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeFunctionReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeFunctionReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeFunctionReferenceContext userDefinedTypeFunctionReference() throws RecognitionException {
		UserDefinedTypeFunctionReferenceContext _localctx = new UserDefinedTypeFunctionReferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_userDefinedTypeFunctionReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			userDefinedTypeName();
			{
			setState(327);
			userDefinedTypeResolutionOperator();
			}
			setState(328);
			functionCall();
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_add);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				summation();
				setState(331);
				types();
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0)) {
					{
					{
					setState(332);
					types();
					}
					}
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				summation();
				setState(339);
				types();
				setState(340);
				types();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				summation();
				setState(343);
				variable();
				setState(345); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(344);
					types();
					}
					}
					setState(347); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0) );
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitSummation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummationContext summation() throws RecognitionException {
		SummationContext _localctx = new SummationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_summation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitSubtract(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractContext subtract() throws RecognitionException {
		SubtractContext _localctx = new SubtractContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_subtract);
		int _la;
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				subtraction();
				setState(354);
				types();
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0)) {
					{
					{
					setState(355);
					types();
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				subtraction();
				setState(362);
				types();
				setState(363);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtractionContext subtraction() throws RecognitionException {
		SubtractionContext _localctx = new SubtractionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_subtraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyContext multiply() throws RecognitionException {
		MultiplyContext _localctx = new MultiplyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_multiply);
		int _la;
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				multiplication();
				setState(370);
				types();
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0)) {
					{
					{
					setState(371);
					types();
					}
					}
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				multiplication();
				setState(378);
				types();
				setState(379);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationContext multiplication() throws RecognitionException {
		MultiplicationContext _localctx = new MultiplicationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
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

	public static class BreakKeyWordContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(JuliarParser.Break, 0); }
		public BreakKeyWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakKeyWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBreakKeyWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakKeyWordContext breakKeyWord() throws RecognitionException {
		BreakKeyWordContext _localctx = new BreakKeyWordContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_breakKeyWord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(Break);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitDivide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivideContext divide() throws RecognitionException {
		DivideContext _localctx = new DivideContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_divide);
		int _la;
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				division();
				setState(388);
				types();
				setState(392);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0)) {
					{
					{
					setState(389);
					types();
					}
					}
					setState(394);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				division();
				setState(396);
				types();
				setState(397);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivisionContext division() throws RecognitionException {
		DivisionContext _localctx = new DivisionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_division);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitModulo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuloContext modulo() throws RecognitionException {
		ModuloContext _localctx = new ModuloContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_modulo);
		int _la;
		try {
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				moduli();
				setState(404);
				types();
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (NULL - 88)) | (1L << (BOOLEAN - 88)) | (1L << (INT - 88)) | (1L << (FLOAT - 88)) | (1L << (DOUBLE - 88)) | (1L << (LONG - 88)) | (1L << (STRING - 88)))) != 0)) {
					{
					{
					setState(405);
					types();
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				moduli();
				setState(412);
				types();
				setState(413);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitModuli(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuliContext moduli() throws RecognitionException {
		ModuliContext _localctx = new ModuliContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_moduli);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
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

	public static class TypesContext extends ParserRuleContext {
		public PrimitiveTypesContext primitiveTypes() {
			return getRuleContext(PrimitiveTypesContext.class,0);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_types);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
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
		public TerminalNode STRING() { return getToken(JuliarParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(JuliarParser.BOOLEAN, 0); }
		public TerminalNode NULL() { return getToken(JuliarParser.NULL, 0); }
		public PrimitiveTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveTypes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitPrimitiveTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypesContext primitiveTypes() throws RecognitionException {
		PrimitiveTypesContext _localctx = new PrimitiveTypesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_primitiveTypes);
		try {
			setState(425);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				numericTypes();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(STRING);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(423);
				match(BOOLEAN);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(424);
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
		public TerminalNode INT() { return getToken(JuliarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(JuliarParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(JuliarParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(JuliarParser.LONG, 0); }
		public NumericTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericTypes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitNumericTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypesContext numericTypes() throws RecognitionException {
		NumericTypesContext _localctx = new NumericTypesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_numericTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (INT - 90)) | (1L << (FLOAT - 90)) | (1L << (DOUBLE - 90)) | (1L << (LONG - 90)))) != 0)) ) {
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitEqualsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualsignContext equalsign() throws RecognitionException {
		EqualsignContext _localctx = new EqualsignContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_equalsign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(T__19);
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
		public BooleanAndOperatorContext booleanAndOperator() {
			return getRuleContext(BooleanAndOperatorContext.class,0);
		}
		public BooleanOrOperatorContext booleanOrOperator() {
			return getRuleContext(BooleanOrOperatorContext.class,0);
		}
		public NotOperatorContext notOperator() {
			return getRuleContext(NotOperatorContext.class,0);
		}
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_comparisonOperator);
		try {
			setState(439);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				equalequal();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				lessthan();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				greaterthan();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(434);
				lessthanorequalto();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(435);
				greaterthanorequalto();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(436);
				booleanAndOperator();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 7);
				{
				setState(437);
				booleanOrOperator();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 8);
				{
				setState(438);
				notOperator();
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

	public static class BitWiseOperatorsContext extends ParserRuleContext {
		public BitAndContext bitAnd() {
			return getRuleContext(BitAndContext.class,0);
		}
		public BitOrContext bitOr() {
			return getRuleContext(BitOrContext.class,0);
		}
		public BitXorContext bitXor() {
			return getRuleContext(BitXorContext.class,0);
		}
		public BitNotContext bitNot() {
			return getRuleContext(BitNotContext.class,0);
		}
		public BitLeftShiftContext bitLeftShift() {
			return getRuleContext(BitLeftShiftContext.class,0);
		}
		public BitRigthShiftContext bitRigthShift() {
			return getRuleContext(BitRigthShiftContext.class,0);
		}
		public BitWiseOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitWiseOperators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitWiseOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitWiseOperatorsContext bitWiseOperators() throws RecognitionException {
		BitWiseOperatorsContext _localctx = new BitWiseOperatorsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_bitWiseOperators);
		try {
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				bitAnd();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				bitOr();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(443);
				bitXor();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(444);
				bitNot();
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 5);
				{
				setState(445);
				bitLeftShift();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 6);
				{
				setState(446);
				bitRigthShift();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitEqualequal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualequalContext equalequal() throws RecognitionException {
		EqualequalContext _localctx = new EqualequalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_equalequal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(T__20);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitLessthan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessthanContext lessthan() throws RecognitionException {
		LessthanContext _localctx = new LessthanContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_lessthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
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

	public static class GreaterthanContext extends ParserRuleContext {
		public GreaterthanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterthan; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitGreaterthan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterthanContext greaterthan() throws RecognitionException {
		GreaterthanContext _localctx = new GreaterthanContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_greaterthan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
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

	public static class LessthanorequaltoContext extends ParserRuleContext {
		public LessthanorequaltoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessthanorequalto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitLessthanorequalto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessthanorequaltoContext lessthanorequalto() throws RecognitionException {
		LessthanorequaltoContext _localctx = new LessthanorequaltoContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_lessthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
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

	public static class GreaterthanorequaltoContext extends ParserRuleContext {
		public GreaterthanorequaltoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterthanorequalto; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitGreaterthanorequalto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterthanorequaltoContext greaterthanorequalto() throws RecognitionException {
		GreaterthanorequaltoContext _localctx = new GreaterthanorequaltoContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_greaterthanorequalto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
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

	public static class BooleanAndOperatorContext extends ParserRuleContext {
		public BooleanAndOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanAndOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBooleanAndOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanAndOperatorContext booleanAndOperator() throws RecognitionException {
		BooleanAndOperatorContext _localctx = new BooleanAndOperatorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_booleanAndOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
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

	public static class BooleanOrOperatorContext extends ParserRuleContext {
		public BooleanOrOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOrOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBooleanOrOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanOrOperatorContext booleanOrOperator() throws RecognitionException {
		BooleanOrOperatorContext _localctx = new BooleanOrOperatorContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_booleanOrOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
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

	public static class NotOperatorContext extends ParserRuleContext {
		public NotOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitNotOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotOperatorContext notOperator() throws RecognitionException {
		NotOperatorContext _localctx = new NotOperatorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_notOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
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

	public static class BitAndContext extends ParserRuleContext {
		public BitAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAnd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitAndContext bitAnd() throws RecognitionException {
		BitAndContext _localctx = new BitAndContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_bitAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
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

	public static class BitOrContext extends ParserRuleContext {
		public BitOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitOrContext bitOr() throws RecognitionException {
		BitOrContext _localctx = new BitOrContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_bitOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(T__29);
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

	public static class BitXorContext extends ParserRuleContext {
		public BitXorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitXor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitXor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitXorContext bitXor() throws RecognitionException {
		BitXorContext _localctx = new BitXorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_bitXor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
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

	public static class BitNotContext extends ParserRuleContext {
		public BitNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitNot; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitNotContext bitNot() throws RecognitionException {
		BitNotContext _localctx = new BitNotContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_bitNot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(T__31);
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

	public static class BitLeftShiftContext extends ParserRuleContext {
		public BitLeftShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitLeftShift; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitLeftShift(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitLeftShiftContext bitLeftShift() throws RecognitionException {
		BitLeftShiftContext _localctx = new BitLeftShiftContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_bitLeftShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(T__32);
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

	public static class BitRigthShiftContext extends ParserRuleContext {
		public BitRigthShiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitRigthShift; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitRigthShift(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitRigthShiftContext bitRigthShift() throws RecognitionException {
		BitRigthShiftContext _localctx = new BitRigthShiftContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_bitRigthShift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(T__33);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitKeywords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordsContext keywords() throws RecognitionException {
		KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0)) ) {
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

	public static class IfExprContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(JuliarParser.If, 0); }
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
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
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_ifExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(If);
			setState(480);
			match(T__5);
			setState(482); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(481);
				singleExpression(0);
				}
				}
				setState(484); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Void - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0) );
			setState(486);
			match(T__6);
			setState(487);
			match(T__3);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
				{
				{
				setState(488);
				statement();
				}
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(494);
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

	public static class WhileExpressionContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(JuliarParser.While, 0); }
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitWhileExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileExpressionContext whileExpression() throws RecognitionException {
		WhileExpressionContext _localctx = new WhileExpressionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_whileExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(While);
			setState(497);
			match(T__5);
			setState(499); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(498);
				singleExpression(0);
				}
				}
				setState(501); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Void - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0) );
			setState(503);
			match(T__6);
			setState(504);
			match(T__3);
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
				{
				{
				setState(505);
				statement();
				}
				}
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(511);
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

	public static class DoWhileExprContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(JuliarParser.Do, 0); }
		public TerminalNode While() { return getToken(JuliarParser.While, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public DoWhileExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitDoWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileExprContext doWhileExpr() throws RecognitionException {
		DoWhileExprContext _localctx = new DoWhileExprContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_doWhileExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(Do);
			setState(514);
			match(T__3);
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46) | (1L << Do))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Return - 64)) | (1L << (Void - 64)) | (1L << (While - 64)) | (1L << (This - 64)) | (1L << (If - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0)) {
				{
				{
				setState(515);
				statement();
				}
				}
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(521);
			match(T__4);
			setState(522);
			match(While);
			setState(523);
			match(T__5);
			setState(525); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(524);
				singleExpression(0);
				}
				}
				setState(527); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__45) | (1L << T__46))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (Typeof - 64)) | (1L << (Void - 64)) | (1L << (This - 64)) | (1L << (Delete - 64)) | (1L << (DecimalLiteral - 64)) | (1L << (NULL - 64)) | (1L << (BOOLEAN - 64)) | (1L << (INT - 64)) | (1L << (STRING - 64)) | (1L << (ID - 64)) | (1L << (StringLiteral - 64)))) != 0) );
			setState(529);
			match(T__6);
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

	public static class UserDefinedTypeResolutionOperatorContext extends ParserRuleContext {
		public UserDefinedTypeResolutionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedTypeResolutionOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUserDefinedTypeResolutionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedTypeResolutionOperatorContext userDefinedTypeResolutionOperator() throws RecognitionException {
		UserDefinedTypeResolutionOperatorContext _localctx = new UserDefinedTypeResolutionOperatorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_userDefinedTypeResolutionOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(T__41);
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

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			singleExpression(0);
			setState(538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(534);
				match(T__2);
				setState(535);
				singleExpression(0);
				}
				}
				setState(540);
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

	public static class IdentifierNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JuliarParser.ID, 0); }
		public IdentifierNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitIdentifierName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierNameContext identifierName() throws RecognitionException {
		IdentifierNameContext _localctx = new IdentifierNameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_identifierName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
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

	public static class SingleExpressionContext extends ParserRuleContext {
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
	 
		public SingleExpressionContext() { }
		public void copyFrom(SingleExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TernaryExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TernaryExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreIncrementExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public PreIncrementExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitPreIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TerminalNode In() { return getToken(JuliarParser.In, 0); }
		public InExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitInExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends SingleExpressionContext {
		public NotOperatorContext notOperator() {
			return getRuleContext(NotOperatorContext.class,0);
		}
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public NotExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreDecreaseExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public PreDecreaseExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitPreDecreaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends SingleExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExpressionContext extends SingleExpressionContext {
		public TerminalNode This() { return getToken(JuliarParser.This, 0); }
		public ThisExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitThisExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public UnaryMinusExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUnaryMinusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeofExpressionContext extends SingleExpressionContext {
		public TerminalNode Typeof() { return getToken(JuliarParser.Typeof, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public TypeofExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitTypeofExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceofExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public TerminalNode Instanceof() { return getToken(JuliarParser.Instanceof, 0); }
		public InstanceofExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitInstanceofExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryPlusExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public UnaryPlusExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitUnaryPlusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteExpressionContext extends SingleExpressionContext {
		public TerminalNode Delete() { return getToken(JuliarParser.Delete, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public DeleteExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitDeleteExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public EqualityExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicativeExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public MultiplicativeExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitShiftExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public BitLeftShiftContext bitLeftShift() {
			return getRuleContext(BitLeftShiftContext.class,0);
		}
		public BitRigthShiftContext bitRigthShift() {
			return getRuleContext(BitRigthShiftContext.class,0);
		}
		public BitShiftExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExpressionContext extends SingleExpressionContext {
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public ParenthesizedExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public AdditiveExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitNotExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public BitNotExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclarationExpressionContext extends SingleExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public List<AssignmentOperatorContext> assignmentOperator() {
			return getRuleContexts(AssignmentOperatorContext.class);
		}
		public AssignmentOperatorContext assignmentOperator(int i) {
			return getRuleContext(AssignmentOperatorContext.class,i);
		}
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public VariableDeclarationExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitVariableDeclarationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExpressionContext extends SingleExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberDotExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public IdentifierNameContext identifierName() {
			return getRuleContext(IdentifierNameContext.class,0);
		}
		public MemberDotExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitMemberDotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpressionContext extends SingleExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberIndexExpressionContext extends SingleExpressionContext {
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public ExpressionSequenceContext expressionSequence() {
			return getRuleContext(ExpressionSequenceContext.class,0);
		}
		public MemberIndexExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitMemberIndexExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitAndExpressionContext extends SingleExpressionContext {
		public List<SingleExpressionContext> singleExpression() {
			return getRuleContexts(SingleExpressionContext.class);
		}
		public SingleExpressionContext singleExpression(int i) {
			return getRuleContext(SingleExpressionContext.class,i);
		}
		public BitWiseOperatorsContext bitWiseOperators() {
			return getRuleContext(BitWiseOperatorsContext.class,0);
		}
		public BitAndExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitBitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentOperatorExpressionContext extends SingleExpressionContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public AssignmentOperatorExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitAssignmentOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidExpressionContext extends SingleExpressionContext {
		public TerminalNode Void() { return getToken(JuliarParser.Void, 0); }
		public SingleExpressionContext singleExpression() {
			return getRuleContext(SingleExpressionContext.class,0);
		}
		public VoidExpressionContext(SingleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitVoidExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		return singleExpression(0);
	}

	private SingleExpressionContext singleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, _parentState);
		SingleExpressionContext _prevctx = _localctx;
		int _startState = 122;
		enterRecursionRule(_localctx, 122, RULE_singleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new DeleteExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(544);
				match(Delete);
				setState(545);
				singleExpression(26);
				}
				break;
			case 2:
				{
				_localctx = new VoidExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(546);
				match(Void);
				setState(547);
				singleExpression(25);
				}
				break;
			case 3:
				{
				_localctx = new TypeofExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(548);
				match(Typeof);
				setState(549);
				singleExpression(24);
				}
				break;
			case 4:
				{
				_localctx = new PreIncrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(550);
				match(T__45);
				setState(551);
				singleExpression(21);
				}
				break;
			case 5:
				{
				_localctx = new PreDecreaseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(552);
				match(T__46);
				setState(553);
				singleExpression(20);
				}
				break;
			case 6:
				{
				_localctx = new UnaryPlusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(554);
				match(T__9);
				setState(555);
				singleExpression(19);
				}
				break;
			case 7:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(556);
				match(T__11);
				setState(557);
				singleExpression(18);
				}
				break;
			case 8:
				{
				_localctx = new BitNotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(558);
				match(T__31);
				setState(559);
				singleExpression(17);
				}
				break;
			case 9:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(560);
				notOperator();
				setState(561);
				singleExpression(16);
				}
				break;
			case 10:
				{
				_localctx = new VariableDeclarationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(563);
				keywords();
				}
				setState(564);
				variable();
				setState(570);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(565);
						assignmentOperator();
						setState(566);
						singleExpression(0);
						}
						} 
					}
					setState(572);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				}
				break;
			case 11:
				{
				_localctx = new AssignmentOperatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(573);
				variable();
				setState(574);
				assignmentOperator();
				setState(575);
				singleExpression(6);
				}
				break;
			case 12:
				{
				_localctx = new ThisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(577);
				match(This);
				}
				break;
			case 13:
				{
				_localctx = new LiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(578);
				literal();
				}
				break;
			case 14:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(579);
				variable();
				}
				break;
			case 15:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(580);
				functionCall();
				}
				break;
			case 16:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(581);
				match(T__5);
				setState(582);
				expressionSequence();
				setState(583);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(630);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(628);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(587);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(588);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__15) | (1L << T__17))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(589);
						singleExpression(16);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(590);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(591);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(592);
						singleExpression(15);
						}
						break;
					case 3:
						{
						_localctx = new EqualityExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(593);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(594);
						comparisonOperator();
						setState(595);
						singleExpression(14);
						}
						break;
					case 4:
						{
						_localctx = new BitAndExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(597);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(598);
						bitWiseOperators();
						setState(599);
						singleExpression(13);
						}
						break;
					case 5:
						{
						_localctx = new BitShiftExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(601);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(604);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__32:
							{
							setState(602);
							bitLeftShift();
							}
							break;
						case T__33:
							{
							setState(603);
							bitRigthShift();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(606);
						singleExpression(12);
						}
						break;
					case 6:
						{
						_localctx = new InstanceofExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(608);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(609);
						match(Instanceof);
						setState(610);
						singleExpression(11);
						}
						break;
					case 7:
						{
						_localctx = new InExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(611);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(612);
						match(In);
						setState(613);
						singleExpression(10);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(614);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(615);
						match(T__47);
						setState(616);
						singleExpression(0);
						setState(617);
						match(T__48);
						setState(618);
						singleExpression(9);
						}
						break;
					case 9:
						{
						_localctx = new MemberIndexExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(620);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(621);
						match(T__42);
						setState(622);
						expressionSequence();
						setState(623);
						match(T__43);
						}
						break;
					case 10:
						{
						_localctx = new MemberDotExpressionContext(new SingleExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_singleExpression);
						setState(625);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(626);
						match(T__44);
						setState(627);
						identifierName();
						}
						break;
					}
					} 
				}
				setState(632);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
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
		public UserDefinedTypeVariableReferenceContext userDefinedTypeVariableReference() {
			return getRuleContext(UserDefinedTypeVariableReferenceContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_assignmentExpression);
		try {
			setState(650);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				variableDeclaration();
				setState(634);
				equalsign();
				setState(642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(635);
					command();
					}
					break;
				case 2:
					{
					setState(636);
					variable();
					}
					break;
				case 3:
					{
					setState(637);
					functionCall();
					}
					break;
				case 4:
					{
					setState(638);
					primitiveTypes();
					}
					break;
				case 5:
					{
					setState(639);
					booleanExpression();
					}
					break;
				case 6:
					{
					setState(640);
					userDefinedTypeVariableReference();
					}
					break;
				case 7:
					{
					setState(641);
					userDefinedTypeVariableReference();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				userDefinedTypeVariableReference();
				setState(645);
				equalsign();
				setState(648);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(646);
					variable();
					}
					break;
				case NULL:
				case BOOLEAN:
				case INT:
				case FLOAT:
				case DOUBLE:
				case LONG:
				case STRING:
					{
					setState(647);
					primitiveTypes();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public UserDefinedTypeVariableReferenceContext userDefinedTypeVariableReference() {
			return getRuleContext(UserDefinedTypeVariableReferenceContext.class,0);
		}
		public UserDefinedTypeFunctionReferenceContext userDefinedTypeFunctionReference() {
			return getRuleContext(UserDefinedTypeFunctionReferenceContext.class,0);
		}
		public ReassignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reassignmentExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitReassignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReassignmentExpressionContext reassignmentExpression() throws RecognitionException {
		ReassignmentExpressionContext _localctx = new ReassignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_reassignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			variable();
			setState(653);
			equalsign();
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(654);
				variable();
				}
				break;
			case 2:
				{
				setState(655);
				functionCall();
				}
				break;
			case 3:
				{
				setState(656);
				primitiveTypes();
				}
				break;
			case 4:
				{
				setState(657);
				command();
				}
				break;
			case 5:
				{
				setState(658);
				userDefinedTypeVariableReference();
				}
				break;
			case 6:
				{
				setState(659);
				userDefinedTypeFunctionReference();
				}
				break;
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0)) ) {
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(JuliarParser.BOOLEAN, 0); }
		public TerminalNode NULL() { return getToken(JuliarParser.NULL, 0); }
		public TerminalNode DecimalLiteral() { return getToken(JuliarParser.DecimalLiteral, 0); }
		public TerminalNode INT() { return getToken(JuliarParser.INT, 0); }
		public TerminalNode STRING() { return getToken(JuliarParser.STRING, 0); }
		public TerminalNode StringLiteral() { return getToken(JuliarParser.StringLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JuliarVisitor ) return ((JuliarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_literal);
		int _la;
		try {
			setState(669);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(664);
				_la = _input.LA(1);
				if ( !(_la==NULL || _la==BOOLEAN) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				match(DecimalLiteral);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(666);
				match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(667);
				match(STRING);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 5);
				{
				setState(668);
				match(StringLiteral);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 61:
			return singleExpression_sempred((SingleExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean singleExpression_sempred(SingleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 23);
		case 9:
			return precpred(_ctx, 22);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3g\u02a2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\7\2\u0088\n\2\f\2\16\2\u008b"+
		"\13\2\3\3\3\3\5\3\u008f\n\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"\u00ac\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00b4\n\b\f\b\16\b\u00b7\13\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c0\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u00c9\n\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d1\n\t\f\t\16\t\u00d4\13\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00de\n\t\3\t\3\t\3\t\3\t\7\t\u00e4"+
		"\n\t\f\t\16\t\u00e7\13\t\3\t\3\t\5\t\u00eb\n\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00f6\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\5"+
		"\16\u00ff\n\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0107\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0112\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u011a\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u0121\n\21\f"+
		"\21\16\21\u0124\13\21\3\21\7\21\u0127\n\21\f\21\16\21\u012a\13\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u0138\n\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0143\n\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u0150\n\31\f\31\16"+
		"\31\u0153\13\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u015c\n\31\r\31"+
		"\16\31\u015d\5\31\u0160\n\31\3\32\3\32\3\33\3\33\3\33\7\33\u0167\n\33"+
		"\f\33\16\33\u016a\13\33\3\33\3\33\3\33\3\33\5\33\u0170\n\33\3\34\3\34"+
		"\3\35\3\35\3\35\7\35\u0177\n\35\f\35\16\35\u017a\13\35\3\35\3\35\3\35"+
		"\3\35\5\35\u0180\n\35\3\36\3\36\3\37\3\37\3 \3 \3 \7 \u0189\n \f \16 "+
		"\u018c\13 \3 \3 \3 \3 \5 \u0192\n \3!\3!\3\"\3\"\3\"\7\"\u0199\n\"\f\""+
		"\16\"\u019c\13\"\3\"\3\"\3\"\3\"\5\"\u01a2\n\"\3#\3#\3$\3$\3%\3%\3%\3"+
		"%\5%\u01ac\n%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01ba\n(\3)\3)"+
		"\3)\3)\3)\3)\5)\u01c2\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67"+
		"\38\38\39\39\39\69\u01e5\n9\r9\169\u01e6\39\39\39\79\u01ec\n9\f9\169\u01ef"+
		"\139\39\39\3:\3:\3:\6:\u01f6\n:\r:\16:\u01f7\3:\3:\3:\7:\u01fd\n:\f:\16"+
		":\u0200\13:\3:\3:\3;\3;\3;\7;\u0207\n;\f;\16;\u020a\13;\3;\3;\3;\3;\6"+
		";\u0210\n;\r;\16;\u0211\3;\3;\3<\3<\3=\3=\3=\7=\u021b\n=\f=\16=\u021e"+
		"\13=\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\3?\3?\7?\u023b\n?\f?\16?\u023e\13?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3?\3?\3?\3?\5?\u024c\n?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3?\3?\5?\u025f\n?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3?\3?\3?\3?\3?\7?\u0277\n?\f?\16?\u027a\13?\3@\3@\3@\3@\3@\3@\3@\3@\3"+
		"@\5@\u0285\n@\3@\3@\3@\3@\5@\u028b\n@\5@\u028d\n@\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\5A\u0297\nA\3B\3B\3C\3C\3C\3C\3C\5C\u02a0\nC\3C\2\3|D\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"`bdfhjlnprtvxz|~\u0080\u0082\u0084\2\r\3\2\f\r\3\2\16\17\3\2\20\21\3\2"+
		"\22\23\3\2\24\25\3\2\\_\4\2\13\13%+\5\2\20\20\22\22\24\24\4\2\f\f\16\16"+
		"\4\2\26\26\64>\3\2Z[\2\u02d3\2\u0089\3\2\2\2\4\u008e\3\2\2\2\6\u0090\3"+
		"\2\2\2\b\u0092\3\2\2\2\n\u0094\3\2\2\2\f\u00ab\3\2\2\2\16\u00c8\3\2\2"+
		"\2\20\u00ea\3\2\2\2\22\u00ec\3\2\2\2\24\u00f5\3\2\2\2\26\u00f7\3\2\2\2"+
		"\30\u00f9\3\2\2\2\32\u00fe\3\2\2\2\34\u0111\3\2\2\2\36\u0119\3\2\2\2 "+
		"\u011b\3\2\2\2\"\u012d\3\2\2\2$\u012f\3\2\2\2&\u0131\3\2\2\2(\u0137\3"+
		"\2\2\2*\u0142\3\2\2\2,\u0144\3\2\2\2.\u0148\3\2\2\2\60\u015f\3\2\2\2\62"+
		"\u0161\3\2\2\2\64\u016f\3\2\2\2\66\u0171\3\2\2\28\u017f\3\2\2\2:\u0181"+
		"\3\2\2\2<\u0183\3\2\2\2>\u0191\3\2\2\2@\u0193\3\2\2\2B\u01a1\3\2\2\2D"+
		"\u01a3\3\2\2\2F\u01a5\3\2\2\2H\u01ab\3\2\2\2J\u01ad\3\2\2\2L\u01af\3\2"+
		"\2\2N\u01b9\3\2\2\2P\u01c1\3\2\2\2R\u01c3\3\2\2\2T\u01c5\3\2\2\2V\u01c7"+
		"\3\2\2\2X\u01c9\3\2\2\2Z\u01cb\3\2\2\2\\\u01cd\3\2\2\2^\u01cf\3\2\2\2"+
		"`\u01d1\3\2\2\2b\u01d3\3\2\2\2d\u01d5\3\2\2\2f\u01d7\3\2\2\2h\u01d9\3"+
		"\2\2\2j\u01db\3\2\2\2l\u01dd\3\2\2\2n\u01df\3\2\2\2p\u01e1\3\2\2\2r\u01f2"+
		"\3\2\2\2t\u0203\3\2\2\2v\u0215\3\2\2\2x\u0217\3\2\2\2z\u021f\3\2\2\2|"+
		"\u024b\3\2\2\2~\u028c\3\2\2\2\u0080\u028e\3\2\2\2\u0082\u0298\3\2\2\2"+
		"\u0084\u029f\3\2\2\2\u0086\u0088\5\4\3\2\u0087\u0086\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\3\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008f\5\20\t\2\u008d\u008f\5 \21\2\u008e\u008c\3"+
		"\2\2\2\u008e\u008d\3\2\2\2\u008f\5\3\2\2\2\u0090\u0091\5\f\7\2\u0091\7"+
		"\3\2\2\2\u0092\u0093\5\n\6\2\u0093\t\3\2\2\2\u0094\u0095\7\3\2\2\u0095"+
		"\13\3\2\2\2\u0096\u0097\5|?\2\u0097\u0098\5\b\5\2\u0098\u00ac\3\2\2\2"+
		"\u0099\u00ac\5p9\2\u009a\u00ac\5r:\2\u009b\u00ac\5t;\2\u009c\u009d\5\34"+
		"\17\2\u009d\u009e\5\b\5\2\u009e\u00ac\3\2\2\2\u009f\u00a0\5\16\b\2\u00a0"+
		"\u00a1\5\b\5\2\u00a1\u00ac\3\2\2\2\u00a2\u00a3\5.\30\2\u00a3\u00a4\5\b"+
		"\5\2\u00a4\u00ac\3\2\2\2\u00a5\u00a6\5,\27\2\u00a6\u00a7\5\b\5\2\u00a7"+
		"\u00ac\3\2\2\2\u00a8\u00a9\5\24\13\2\u00a9\u00aa\5\b\5\2\u00aa\u00ac\3"+
		"\2\2\2\u00ab\u0096\3\2\2\2\u00ab\u0099\3\2\2\2\u00ab\u009a\3\2\2\2\u00ab"+
		"\u009b\3\2\2\2\u00ab\u009c\3\2\2\2\u00ab\u009f\3\2\2\2\u00ab\u00a2\3\2"+
		"\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\r\3\2\2\2\u00ad\u00ae"+
		"\5\22\n\2\u00ae\u00af\7\4\2\2\u00af\u00c9\3\2\2\2\u00b0\u00b1\5\22\n\2"+
		"\u00b1\u00b5\5\26\f\2\u00b2\u00b4\7c\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00b9\5\30\r\2\u00b9\u00c9\3\2\2\2\u00ba\u00bb\5"+
		"\22\n\2\u00bb\u00bc\5\26\f\2\u00bc\u00bf\5&\24\2\u00bd\u00be\7\5\2\2\u00be"+
		"\u00c0\5&\24\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c2\5\30\r\2\u00c2\u00c9\3\2\2\2\u00c3\u00c4\5\22\n\2\u00c4"+
		"\u00c5\5\26\f\2\u00c5\u00c6\7a\2\2\u00c6\u00c7\5\30\r\2\u00c7\u00c9\3"+
		"\2\2\2\u00c8\u00ad\3\2\2\2\u00c8\u00b0\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c8"+
		"\u00c3\3\2\2\2\u00c9\17\3\2\2\2\u00ca\u00cb\7P\2\2\u00cb\u00cc\5\22\n"+
		"\2\u00cc\u00cd\7\4\2\2\u00cd\u00ce\5L\'\2\u00ce\u00d2\7\6\2\2\u00cf\u00d1"+
		"\5\6\4\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\7"+
		"\2\2\u00d6\u00eb\3\2\2\2\u00d7\u00d8\7P\2\2\u00d8\u00d9\5\22\n\2\u00d9"+
		"\u00da\5\26\f\2\u00da\u00dd\5(\25\2\u00db\u00dc\7\5\2\2\u00dc\u00de\5"+
		"(\25\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\5\30\r\2\u00e0\u00e1\5L\'\2\u00e1\u00e5\7\6\2\2\u00e2\u00e4\5\6"+
		"\4\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\7\7"+
		"\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00ca\3\2\2\2\u00ea\u00d7\3\2\2\2\u00eb"+
		"\21\3\2\2\2\u00ec\u00ed\7b\2\2\u00ed\23\3\2\2\2\u00ee\u00f6\7I\2\2\u00ef"+
		"\u00f0\7I\2\2\u00f0\u00f6\5F$\2\u00f1\u00f2\7I\2\2\u00f2\u00f6\5&\24\2"+
		"\u00f3\u00f4\7I\2\2\u00f4\u00f6\5\16\b\2\u00f5\u00ee\3\2\2\2\u00f5\u00ef"+
		"\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\25\3\2\2\2\u00f7"+
		"\u00f8\7\b\2\2\u00f8\27\3\2\2\2\u00f9\u00fa\7\t\2\2\u00fa\31\3\2\2\2\u00fb"+
		"\u00ff\7[\2\2\u00fc\u00ff\5&\24\2\u00fd\u00ff\5\36\20\2\u00fe\u00fb\3"+
		"\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0106\5N(\2\u0101\u0107\5&\24\2\u0102\u0107\5H%\2\u0103\u0107\5\36\20"+
		"\2\u0104\u0107\5,\27\2\u0105\u0107\5.\30\2\u0106\u0101\3\2\2\2\u0106\u0102"+
		"\3\2\2\2\u0106\u0103\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107"+
		"\33\3\2\2\2\u0108\u0109\7\n\2\2\u0109\u010a\7\b\2\2\u010a\u010b\7a\2\2"+
		"\u010b\u0112\7\t\2\2\u010c\u010d\7\n\2\2\u010d\u010e\7\b\2\2\u010e\u010f"+
		"\5&\24\2\u010f\u0110\7\t\2\2\u0110\u0112\3\2\2\2\u0111\u0108\3\2\2\2\u0111"+
		"\u010c\3\2\2\2\u0112\35\3\2\2\2\u0113\u011a\5\60\31\2\u0114\u011a\5\34"+
		"\17\2\u0115\u011a\5\64\33\2\u0116\u011a\58\35\2\u0117\u011a\5> \2\u0118"+
		"\u011a\5B\"\2\u0119\u0113\3\2\2\2\u0119\u0114\3\2\2\2\u0119\u0115\3\2"+
		"\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\37\3\2\2\2\u011b\u011c\5\"\22\2\u011c\u011d\5$\23\2\u011d\u011e\5L\'"+
		"\2\u011e\u0122\7\6\2\2\u011f\u0121\5\6\4\2\u0120\u011f\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0128\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0127\5\20\t\2\u0126\u0125\3\2\2\2\u0127\u012a\3"+
		"\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012c\7\7\2\2\u012c!\3\2\2\2\u012d\u012e\7\13\2\2"+
		"\u012e#\3\2\2\2\u012f\u0130\7b\2\2\u0130%\3\2\2\2\u0131\u0132\7b\2\2\u0132"+
		"\'\3\2\2\2\u0133\u0134\5n8\2\u0134\u0135\5&\24\2\u0135\u0138\3\2\2\2\u0136"+
		"\u0138\5*\26\2\u0137\u0133\3\2\2\2\u0137\u0136\3\2\2\2\u0138)\3\2\2\2"+
		"\u0139\u013a\5$\23\2\u013a\u013b\5&\24\2\u013b\u0143\3\2\2\2\u013c\u013d"+
		"\5$\23\2\u013d\u013e\7b\2\2\u013e\u013f\5L\'\2\u013f\u0140\7E\2\2\u0140"+
		"\u0141\5$\23\2\u0141\u0143\3\2\2\2\u0142\u0139\3\2\2\2\u0142\u013c\3\2"+
		"\2\2\u0143+\3\2\2\2\u0144\u0145\5$\23\2\u0145\u0146\5v<\2\u0146\u0147"+
		"\5&\24\2\u0147-\3\2\2\2\u0148\u0149\5$\23\2\u0149\u014a\5v<\2\u014a\u014b"+
		"\5\16\b\2\u014b/\3\2\2\2\u014c\u014d\5\62\32\2\u014d\u0151\5F$\2\u014e"+
		"\u0150\5F$\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2"+
		"\2\u0151\u0152\3\2\2\2\u0152\u0160\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155"+
		"\5\62\32\2\u0155\u0156\5F$\2\u0156\u0157\5F$\2\u0157\u0160\3\2\2\2\u0158"+
		"\u0159\5\62\32\2\u0159\u015b\5&\24\2\u015a\u015c\5F$\2\u015b\u015a\3\2"+
		"\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u0160\3\2\2\2\u015f\u014c\3\2\2\2\u015f\u0154\3\2\2\2\u015f\u0158\3\2"+
		"\2\2\u0160\61\3\2\2\2\u0161\u0162\t\2\2\2\u0162\63\3\2\2\2\u0163\u0164"+
		"\5\66\34\2\u0164\u0168\5F$\2\u0165\u0167\5F$\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0170\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016b\u016c\5\66\34\2\u016c\u016d\5F$\2\u016d"+
		"\u016e\5F$\2\u016e\u0170\3\2\2\2\u016f\u0163\3\2\2\2\u016f\u016b\3\2\2"+
		"\2\u0170\65\3\2\2\2\u0171\u0172\t\3\2\2\u0172\67\3\2\2\2\u0173\u0174\5"+
		":\36\2\u0174\u0178\5F$\2\u0175\u0177\5F$\2\u0176\u0175\3\2\2\2\u0177\u017a"+
		"\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u0180\3\2\2\2\u017a"+
		"\u0178\3\2\2\2\u017b\u017c\5:\36\2\u017c\u017d\5F$\2\u017d\u017e\5F$\2"+
		"\u017e\u0180\3\2\2\2\u017f\u0173\3\2\2\2\u017f\u017b\3\2\2\2\u01809\3"+
		"\2\2\2\u0181\u0182\t\4\2\2\u0182;\3\2\2\2\u0183\u0184\7?\2\2\u0184=\3"+
		"\2\2\2\u0185\u0186\5@!\2\u0186\u018a\5F$\2\u0187\u0189\5F$\2\u0188\u0187"+
		"\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u0192\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\5@!\2\u018e\u018f\5F$\2"+
		"\u018f\u0190\5F$\2\u0190\u0192\3\2\2\2\u0191\u0185\3\2\2\2\u0191\u018d"+
		"\3\2\2\2\u0192?\3\2\2\2\u0193\u0194\t\5\2\2\u0194A\3\2\2\2\u0195\u0196"+
		"\5D#\2\u0196\u019a\5F$\2\u0197\u0199\5F$\2\u0198\u0197\3\2\2\2\u0199\u019c"+
		"\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01a2\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019d\u019e\5D#\2\u019e\u019f\5F$\2\u019f\u01a0\5F$\2\u01a0"+
		"\u01a2\3\2\2\2\u01a1\u0195\3\2\2\2\u01a1\u019d\3\2\2\2\u01a2C\3\2\2\2"+
		"\u01a3\u01a4\t\6\2\2\u01a4E\3\2\2\2\u01a5\u01a6\5H%\2\u01a6G\3\2\2\2\u01a7"+
		"\u01ac\5J&\2\u01a8\u01ac\7a\2\2\u01a9\u01ac\7[\2\2\u01aa\u01ac\7Z\2\2"+
		"\u01ab\u01a7\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa"+
		"\3\2\2\2\u01acI\3\2\2\2\u01ad\u01ae\t\7\2\2\u01aeK\3\2\2\2\u01af\u01b0"+
		"\7\26\2\2\u01b0M\3\2\2\2\u01b1\u01ba\5R*\2\u01b2\u01ba\5T+\2\u01b3\u01ba"+
		"\5V,\2\u01b4\u01ba\5X-\2\u01b5\u01ba\5Z.\2\u01b6\u01ba\5\\/\2\u01b7\u01ba"+
		"\5^\60\2\u01b8\u01ba\5`\61\2\u01b9\u01b1\3\2\2\2\u01b9\u01b2\3\2\2\2\u01b9"+
		"\u01b3\3\2\2\2\u01b9\u01b4\3\2\2\2\u01b9\u01b5\3\2\2\2\u01b9\u01b6\3\2"+
		"\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01baO\3\2\2\2\u01bb\u01c2"+
		"\5b\62\2\u01bc\u01c2\5d\63\2\u01bd\u01c2\5f\64\2\u01be\u01c2\5h\65\2\u01bf"+
		"\u01c2\5j\66\2\u01c0\u01c2\5l\67\2\u01c1\u01bb\3\2\2\2\u01c1\u01bc\3\2"+
		"\2\2\u01c1\u01bd\3\2\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c0\3\2\2\2\u01c2Q\3\2\2\2\u01c3\u01c4\7\27\2\2\u01c4S\3\2\2\2\u01c5"+
		"\u01c6\7\30\2\2\u01c6U\3\2\2\2\u01c7\u01c8\7\31\2\2\u01c8W\3\2\2\2\u01c9"+
		"\u01ca\7\32\2\2\u01caY\3\2\2\2\u01cb\u01cc\7\33\2\2\u01cc[\3\2\2\2\u01cd"+
		"\u01ce\7\34\2\2\u01ce]\3\2\2\2\u01cf\u01d0\7\35\2\2\u01d0_\3\2\2\2\u01d1"+
		"\u01d2\7\36\2\2\u01d2a\3\2\2\2\u01d3\u01d4\7\37\2\2\u01d4c\3\2\2\2\u01d5"+
		"\u01d6\7 \2\2\u01d6e\3\2\2\2\u01d7\u01d8\7!\2\2\u01d8g\3\2\2\2\u01d9\u01da"+
		"\7\"\2\2\u01dai\3\2\2\2\u01db\u01dc\7#\2\2\u01dck\3\2\2\2\u01dd\u01de"+
		"\7$\2\2\u01dem\3\2\2\2\u01df\u01e0\t\b\2\2\u01e0o\3\2\2\2\u01e1\u01e2"+
		"\7T\2\2\u01e2\u01e4\7\b\2\2\u01e3\u01e5\5|?\2\u01e4\u01e3\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01e9\7\t\2\2\u01e9\u01ed\7\6\2\2\u01ea\u01ec\5\6\4\2\u01eb"+
		"\u01ea\3\2\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f1\7\7\2\2\u01f1"+
		"q\3\2\2\2\u01f2\u01f3\7N\2\2\u01f3\u01f5\7\b\2\2\u01f4\u01f6\5|?\2\u01f5"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2"+
		"\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\7\t\2\2\u01fa\u01fe\7\6\2\2\u01fb"+
		"\u01fd\5\6\4\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2"+
		"\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200\u01fe\3\2\2\2\u0201"+
		"\u0202\7\7\2\2\u0202s\3\2\2\2\u0203\u0204\7@\2\2\u0204\u0208\7\6\2\2\u0205"+
		"\u0207\5\6\4\2\u0206\u0205\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2"+
		"\2\2\u0208\u0209\3\2\2\2\u0209\u020b\3\2\2\2\u020a\u0208\3\2\2\2\u020b"+
		"\u020c\7\7\2\2\u020c\u020d\7N\2\2\u020d\u020f\7\b\2\2\u020e\u0210\5|?"+
		"\2\u020f\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212"+
		"\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7\t\2\2\u0214u\3\2\2\2\u0215"+
		"\u0216\7,\2\2\u0216w\3\2\2\2\u0217\u021c\5|?\2\u0218\u0219\7\5\2\2\u0219"+
		"\u021b\5|?\2\u021a\u0218\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2"+
		"\2\u021c\u021d\3\2\2\2\u021dy\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0220"+
		"\7b\2\2\u0220{\3\2\2\2\u0221\u0222\b?\1\2\u0222\u0223\7V\2\2\u0223\u024c"+
		"\5|?\34\u0224\u0225\7J\2\2\u0225\u024c\5|?\33\u0226\u0227\7B\2\2\u0227"+
		"\u024c\5|?\32\u0228\u0229\7\60\2\2\u0229\u024c\5|?\27\u022a\u022b\7\61"+
		"\2\2\u022b\u024c\5|?\26\u022c\u022d\7\f\2\2\u022d\u024c\5|?\25\u022e\u022f"+
		"\7\16\2\2\u022f\u024c\5|?\24\u0230\u0231\7\"\2\2\u0231\u024c\5|?\23\u0232"+
		"\u0233\5`\61\2\u0233\u0234\5|?\22\u0234\u024c\3\2\2\2\u0235\u0236\5n8"+
		"\2\u0236\u023c\5&\24\2\u0237\u0238\5\u0082B\2\u0238\u0239\5|?\2\u0239"+
		"\u023b\3\2\2\2\u023a\u0237\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2"+
		"\2\2\u023c\u023d\3\2\2\2\u023d\u024c\3\2\2\2\u023e\u023c\3\2\2\2\u023f"+
		"\u0240\5&\24\2\u0240\u0241\5\u0082B\2\u0241\u0242\5|?\b\u0242\u024c\3"+
		"\2\2\2\u0243\u024c\7Q\2\2\u0244\u024c\5\u0084C\2\u0245\u024c\5&\24\2\u0246"+
		"\u024c\5\16\b\2\u0247\u0248\7\b\2\2\u0248\u0249\5x=\2\u0249\u024a\7\t"+
		"\2\2\u024a\u024c\3\2\2\2\u024b\u0221\3\2\2\2\u024b\u0224\3\2\2\2\u024b"+
		"\u0226\3\2\2\2\u024b\u0228\3\2\2\2\u024b\u022a\3\2\2\2\u024b\u022c\3\2"+
		"\2\2\u024b\u022e\3\2\2\2\u024b\u0230\3\2\2\2\u024b\u0232\3\2\2\2\u024b"+
		"\u0235\3\2\2\2\u024b\u023f\3\2\2\2\u024b\u0243\3\2\2\2\u024b\u0244\3\2"+
		"\2\2\u024b\u0245\3\2\2\2\u024b\u0246\3\2\2\2\u024b\u0247\3\2\2\2\u024c"+
		"\u0278\3\2\2\2\u024d\u024e\f\21\2\2\u024e\u024f\t\t\2\2\u024f\u0277\5"+
		"|?\22\u0250\u0251\f\20\2\2\u0251\u0252\t\n\2\2\u0252\u0277\5|?\21\u0253"+
		"\u0254\f\17\2\2\u0254\u0255\5N(\2\u0255\u0256\5|?\20\u0256\u0277\3\2\2"+
		"\2\u0257\u0258\f\16\2\2\u0258\u0259\5P)\2\u0259\u025a\5|?\17\u025a\u0277"+
		"\3\2\2\2\u025b\u025e\f\r\2\2\u025c\u025f\5j\66\2\u025d\u025f\5l\67\2\u025e"+
		"\u025c\3\2\2\2\u025e\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\5|"+
		"?\16\u0261\u0277\3\2\2\2\u0262\u0263\f\f\2\2\u0263\u0264\7A\2\2\u0264"+
		"\u0277\5|?\r\u0265\u0266\f\13\2\2\u0266\u0267\7W\2\2\u0267\u0277\5|?\f"+
		"\u0268\u0269\f\n\2\2\u0269\u026a\7\62\2\2\u026a\u026b\5|?\2\u026b\u026c"+
		"\7\63\2\2\u026c\u026d\5|?\13\u026d\u0277\3\2\2\2\u026e\u026f\f\31\2\2"+
		"\u026f\u0270\7-\2\2\u0270\u0271\5x=\2\u0271\u0272\7.\2\2\u0272\u0277\3"+
		"\2\2\2\u0273\u0274\f\30\2\2\u0274\u0275\7/\2\2\u0275\u0277\5z>\2\u0276"+
		"\u024d\3\2\2\2\u0276\u0250\3\2\2\2\u0276\u0253\3\2\2\2\u0276\u0257\3\2"+
		"\2\2\u0276\u025b\3\2\2\2\u0276\u0262\3\2\2\2\u0276\u0265\3\2\2\2\u0276"+
		"\u0268\3\2\2\2\u0276\u026e\3\2\2\2\u0276\u0273\3\2\2\2\u0277\u027a\3\2"+
		"\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279}\3\2\2\2\u027a\u0278"+
		"\3\2\2\2\u027b\u027c\5(\25\2\u027c\u0284\5L\'\2\u027d\u0285\5\36\20\2"+
		"\u027e\u0285\5&\24\2\u027f\u0285\5\16\b\2\u0280\u0285\5H%\2\u0281\u0285"+
		"\5\32\16\2\u0282\u0285\5,\27\2\u0283\u0285\5,\27\2\u0284\u027d\3\2\2\2"+
		"\u0284\u027e\3\2\2\2\u0284\u027f\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0281"+
		"\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0285\u028d\3\2\2\2\u0286"+
		"\u0287\5,\27\2\u0287\u028a\5L\'\2\u0288\u028b\5&\24\2\u0289\u028b\5H%"+
		"\2\u028a\u0288\3\2\2\2\u028a\u0289\3\2\2\2\u028b\u028d\3\2\2\2\u028c\u027b"+
		"\3\2\2\2\u028c\u0286\3\2\2\2\u028d\177\3\2\2\2\u028e\u028f\5&\24\2\u028f"+
		"\u0296\5L\'\2\u0290\u0297\5&\24\2\u0291\u0297\5\16\b\2\u0292\u0297\5H"+
		"%\2\u0293\u0297\5\36\20\2\u0294\u0297\5,\27\2\u0295\u0297\5.\30\2\u0296"+
		"\u0290\3\2\2\2\u0296\u0291\3\2\2\2\u0296\u0292\3\2\2\2\u0296\u0293\3\2"+
		"\2\2\u0296\u0294\3\2\2\2\u0296\u0295\3\2\2\2\u0297\u0081\3\2\2\2\u0298"+
		"\u0299\t\13\2\2\u0299\u0083\3\2\2\2\u029a\u02a0\t\f\2\2\u029b\u02a0\7"+
		"Y\2\2\u029c\u02a0\7\\\2\2\u029d\u02a0\7a\2\2\u029e\u02a0\7f\2\2\u029f"+
		"\u029a\3\2\2\2\u029f\u029b\3\2\2\2\u029f\u029c\3\2\2\2\u029f\u029d\3\2"+
		"\2\2\u029f\u029e\3\2\2\2\u02a0\u0085\3\2\2\2\64\u0089\u008e\u00ab\u00b5"+
		"\u00bf\u00c8\u00d2\u00dd\u00e5\u00ea\u00f5\u00fe\u0106\u0111\u0119\u0122"+
		"\u0128\u0137\u0142\u0151\u015d\u015f\u0168\u016f\u0178\u017f\u018a\u0191"+
		"\u019a\u01a1\u01ab\u01b9\u01c1\u01e6\u01ed\u01f7\u01fe\u0208\u0211\u021c"+
		"\u023c\u024b\u025e\u0276\u0278\u0284\u028a\u028c\u0296\u029f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}