// Generated from src/com/juliar/juliargrammar.g4 by ANTLR 4.5.3
package com.juliar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link juliargrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface juliargrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(juliargrammarParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(juliargrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#startLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartLine(juliargrammarParser.StartLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#endLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndLine(juliargrammarParser.EndLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#asterisk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsterisk(juliargrammarParser.AsteriskContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(juliargrammarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#absolute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolute(juliargrammarParser.AbsoluteContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#acos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcos(juliargrammarParser.AcosContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#acosh}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcosh(juliargrammarParser.AcoshContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliargrammarParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(juliargrammarParser.AddContext ctx);
}