// Generated from /Users/don/Desktop/repos/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.6
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
	 * Visit a parse tree produced by {@link juliarParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(juliarParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(juliarParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(juliarParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#returnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(juliarParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#leftParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftParen(juliarParser.LeftParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#rightParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightParen(juliarParser.RightParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(juliarParser.BooleanExpressionContext ctx);
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
	 * Visit a parse tree produced by {@link juliarParser#variabledeclartion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledeclartion(juliarParser.VariabledeclartionContext ctx);
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
	 * Visit a parse tree produced by {@link juliarParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(juliarParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(juliarParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#divide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(juliarParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(juliarParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#modulo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(juliarParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#moduli}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuli(juliarParser.ModuliContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(juliarParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#primitiveTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveTypes(juliarParser.PrimitiveTypesContext ctx);
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
	 * Visit a parse tree produced by {@link juliarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(juliarParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#equalequal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualequal(juliarParser.EqualequalContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#lessthan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthan(juliarParser.LessthanContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#greaterthan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthan(juliarParser.GreaterthanContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#lessthanorequalto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthanorequalto(juliarParser.LessthanorequaltoContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#greaterthanorequalto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthanorequalto(juliarParser.GreaterthanorequaltoContext ctx);
	/**
	 * Visit a parse tree produced by {@link juliarParser#threeway}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreeway(juliarParser.ThreewayContext ctx);
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