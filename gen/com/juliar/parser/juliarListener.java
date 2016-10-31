// Generated from /Users/donreamey/github/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.5.3
package com.juliar.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link juliarParser}.
 */
public interface juliarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link juliarParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(juliarParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(juliarParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(juliarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(juliarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#startLine}.
	 * @param ctx the parse tree
	 */
	void enterStartLine(juliarParser.StartLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#startLine}.
	 * @param ctx the parse tree
	 */
	void exitStartLine(juliarParser.StartLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#endLine}.
	 * @param ctx the parse tree
	 */
	void enterEndLine(juliarParser.EndLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#endLine}.
	 * @param ctx the parse tree
	 */
	void exitEndLine(juliarParser.EndLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#asterisk}.
	 * @param ctx the parse tree
	 */
	void enterAsterisk(juliarParser.AsteriskContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#asterisk}.
	 * @param ctx the parse tree
	 */
	void exitAsterisk(juliarParser.AsteriskContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(juliarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(juliarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(juliarParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(juliarParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(juliarParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(juliarParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(juliarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(juliarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(juliarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(juliarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#absolute}.
	 * @param ctx the parse tree
	 */
	void enterAbsolute(juliarParser.AbsoluteContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#absolute}.
	 * @param ctx the parse tree
	 */
	void exitAbsolute(juliarParser.AbsoluteContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#acos}.
	 * @param ctx the parse tree
	 */
	void enterAcos(juliarParser.AcosContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#acos}.
	 * @param ctx the parse tree
	 */
	void exitAcos(juliarParser.AcosContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#acosh}.
	 * @param ctx the parse tree
	 */
	void enterAcosh(juliarParser.AcoshContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#acosh}.
	 * @param ctx the parse tree
	 */
	void exitAcosh(juliarParser.AcoshContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(juliarParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(juliarParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#summation}.
	 * @param ctx the parse tree
	 */
	void enterSummation(juliarParser.SummationContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#summation}.
	 * @param ctx the parse tree
	 */
	void exitSummation(juliarParser.SummationContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#minus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(juliarParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#minus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(juliarParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#subtract}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(juliarParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#subtract}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(juliarParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(juliarParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(juliarParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#equalsign}.
	 * @param ctx the parse tree
	 */
	void enterEqualsign(juliarParser.EqualsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#equalsign}.
	 * @param ctx the parse tree
	 */
	void exitEqualsign(juliarParser.EqualsignContext ctx);
}