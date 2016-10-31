// Generated from src/com/juliar/parser/juliar.g4 by ANTLR 4.5.3
package com.juliar.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link juliarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface juliarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link juliarParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(juliarParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(juliarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#startLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartLine(juliarParser.StartLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#endLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndLine(juliarParser.EndLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#asterisk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsterisk(juliarParser.AsteriskContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(juliarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(juliarParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(juliarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(juliarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#absolute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolute(juliarParser.AbsoluteContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#acos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcos(juliarParser.AcosContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#acosh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcosh(juliarParser.AcoshContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(juliarParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#summation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummation(juliarParser.SummationContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(juliarParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#subtract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(juliarParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(juliarParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#equalsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsign(juliarParser.EqualsignContext ctx);
}