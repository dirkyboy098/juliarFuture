// Generated from src/com/juliar/parser/juliar.g4 by ANTLR 4.6
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
	 * Visit a parse tree produced by {@link juliarParser#endLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndLine(juliarParser.EndLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#semiColon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemiColon(juliarParser.SemiColonContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(juliarParser.ExpressionsContext ctx);
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
	 * Visit a parse tree produced by {@link juliarParser#primitives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitives(juliarParser.PrimitivesContext ctx);
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
	 * Visit a parse tree produced by {@link juliarParser#subtract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(juliarParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#subtraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(juliarParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(juliarParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#numericTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericTypes(juliarParser.NumericTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#equalsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsign(juliarParser.EqualsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#equalequal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualequal(juliarParser.EqualequalContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#keywords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords(juliarParser.KeywordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#arrowsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowsign(juliarParser.ArrowsignContext ctx);
}