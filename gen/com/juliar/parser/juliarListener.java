// Generated from /Users/don/Desktop/repos/juliarFuture/src/com/juliar/parser/juliar.g4 by ANTLR 4.6
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
	 * Enter a parse tree produced by {@link juliarParser#semiColon}.
	 * @param ctx the parse tree
	 */
	void enterSemiColon(juliarParser.SemiColonContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#semiColon}.
	 * @param ctx the parse tree
	 */
	void exitSemiColon(juliarParser.SemiColonContext ctx);
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
	 * Enter a parse tree produced by {@link juliarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(juliarParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(juliarParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(juliarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(juliarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(juliarParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(juliarParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(juliarParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(juliarParser.ReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void enterLeftParen(juliarParser.LeftParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void exitLeftParen(juliarParser.LeftParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void enterRightParen(juliarParser.RightParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void exitRightParen(juliarParser.RightParenContext ctx);
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
	 * Enter a parse tree produced by {@link juliarParser#primitives}.
	 * @param ctx the parse tree
	 */
	void enterPrimitives(juliarParser.PrimitivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#primitives}.
	 * @param ctx the parse tree
	 */
	void exitPrimitives(juliarParser.PrimitivesContext ctx);
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
	 * Enter a parse tree produced by {@link juliarParser#variabledeclartion}.
	 * @param ctx the parse tree
	 */
	void enterVariabledeclartion(juliarParser.VariabledeclartionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#variabledeclartion}.
	 * @param ctx the parse tree
	 */
	void exitVariabledeclartion(juliarParser.VariabledeclartionContext ctx);
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
	 * Enter a parse tree produced by {@link juliarParser#subtraction}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(juliarParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#subtraction}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(juliarParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#multiply}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(juliarParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#multiply}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(juliarParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(juliarParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(juliarParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#divide}.
	 * @param ctx the parse tree
	 */
	void enterDivide(juliarParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#divide}.
	 * @param ctx the parse tree
	 */
	void exitDivide(juliarParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#division}.
	 * @param ctx the parse tree
	 */
	void enterDivision(juliarParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#division}.
	 * @param ctx the parse tree
	 */
	void exitDivision(juliarParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#modulo}.
	 * @param ctx the parse tree
	 */
	void enterModulo(juliarParser.ModuloContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#modulo}.
	 * @param ctx the parse tree
	 */
	void exitModulo(juliarParser.ModuloContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#moduli}.
	 * @param ctx the parse tree
	 */
	void enterModuli(juliarParser.ModuliContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#moduli}.
	 * @param ctx the parse tree
	 */
	void exitModuli(juliarParser.ModuliContext ctx);
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
	 * Enter a parse tree produced by {@link juliarParser#primitiveTypes}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveTypes(juliarParser.PrimitiveTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#primitiveTypes}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveTypes(juliarParser.PrimitiveTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#numericTypes}.
	 * @param ctx the parse tree
	 */
	void enterNumericTypes(juliarParser.NumericTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#numericTypes}.
	 * @param ctx the parse tree
	 */
	void exitNumericTypes(juliarParser.NumericTypesContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link juliarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(juliarParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(juliarParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#equalequal}.
	 * @param ctx the parse tree
	 */
	void enterEqualequal(juliarParser.EqualequalContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#equalequal}.
	 * @param ctx the parse tree
	 */
	void exitEqualequal(juliarParser.EqualequalContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#lessthan}.
	 * @param ctx the parse tree
	 */
	void enterLessthan(juliarParser.LessthanContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#lessthan}.
	 * @param ctx the parse tree
	 */
	void exitLessthan(juliarParser.LessthanContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#greaterthan}.
	 * @param ctx the parse tree
	 */
	void enterGreaterthan(juliarParser.GreaterthanContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#greaterthan}.
	 * @param ctx the parse tree
	 */
	void exitGreaterthan(juliarParser.GreaterthanContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#lessthanorequalto}.
	 * @param ctx the parse tree
	 */
	void enterLessthanorequalto(juliarParser.LessthanorequaltoContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#lessthanorequalto}.
	 * @param ctx the parse tree
	 */
	void exitLessthanorequalto(juliarParser.LessthanorequaltoContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#greaterthanorequalto}.
	 * @param ctx the parse tree
	 */
	void enterGreaterthanorequalto(juliarParser.GreaterthanorequaltoContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#greaterthanorequalto}.
	 * @param ctx the parse tree
	 */
	void exitGreaterthanorequalto(juliarParser.GreaterthanorequaltoContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#threeway}.
	 * @param ctx the parse tree
	 */
	void enterThreeway(juliarParser.ThreewayContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#threeway}.
	 * @param ctx the parse tree
	 */
	void exitThreeway(juliarParser.ThreewayContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#keywords}.
	 * @param ctx the parse tree
	 */
	void enterKeywords(juliarParser.KeywordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#keywords}.
	 * @param ctx the parse tree
	 */
	void exitKeywords(juliarParser.KeywordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link juliarParser#arrowsign}.
	 * @param ctx the parse tree
	 */
	void enterArrowsign(juliarParser.ArrowsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link juliarParser#arrowsign}.
	 * @param ctx the parse tree
	 */
	void exitArrowsign(juliarParser.ArrowsignContext ctx);
}