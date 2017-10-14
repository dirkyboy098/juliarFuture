// Generated from src\com\juliar\parser\Juliar.g4 by ANTLR 4.7
package com.juliar.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JuliarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JuliarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JuliarParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(JuliarParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#classifications}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifications(JuliarParser.ClassificationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JuliarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#endLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndLine(JuliarParser.EndLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#semiColon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemiColon(JuliarParser.SemiColonContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JuliarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(JuliarParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(JuliarParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(JuliarParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#returnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(JuliarParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#leftParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftParen(JuliarParser.LeftParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#rightParen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightParen(JuliarParser.RightParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(JuliarParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#primitives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitives(JuliarParser.PrimitivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(JuliarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeDecl(JuliarParser.UserDefinedTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeKeyWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeKeyWord(JuliarParser.UserDefinedTypeKeyWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeName(JuliarParser.UserDefinedTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(JuliarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(JuliarParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeVariableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeVariableDecl(JuliarParser.UserDefinedTypeVariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeVariableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeVariableReference(JuliarParser.UserDefinedTypeVariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeFunctionReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeFunctionReference(JuliarParser.UserDefinedTypeFunctionReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(JuliarParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#summation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummation(JuliarParser.SummationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#subtract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(JuliarParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#subtraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(JuliarParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#multiply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(JuliarParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#multiplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(JuliarParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#breakKeyWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakKeyWord(JuliarParser.BreakKeyWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#divide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(JuliarParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#division}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(JuliarParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#modulo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulo(JuliarParser.ModuloContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#moduli}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuli(JuliarParser.ModuliContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(JuliarParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#primitiveTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveTypes(JuliarParser.PrimitiveTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#numericTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericTypes(JuliarParser.NumericTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#equalsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsign(JuliarParser.EqualsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(JuliarParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitWiseOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitWiseOperators(JuliarParser.BitWiseOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#equalequal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualequal(JuliarParser.EqualequalContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#lessthan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthan(JuliarParser.LessthanContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#greaterthan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthan(JuliarParser.GreaterthanContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#lessthanorequalto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthanorequalto(JuliarParser.LessthanorequaltoContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#greaterthanorequalto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthanorequalto(JuliarParser.GreaterthanorequaltoContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#booleanAndOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAndOperator(JuliarParser.BooleanAndOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#booleanOrOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOrOperator(JuliarParser.BooleanOrOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#notOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOperator(JuliarParser.NotOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAnd(JuliarParser.BitAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOr(JuliarParser.BitOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitXor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXor(JuliarParser.BitXorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitNot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitNot(JuliarParser.BitNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitLeftShift}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitLeftShift(JuliarParser.BitLeftShiftContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#bitRigthShift}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitRigthShift(JuliarParser.BitRigthShiftContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#keywords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywords(JuliarParser.KeywordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#ifExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(JuliarParser.IfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#whileExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpression(JuliarParser.WhileExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#doWhileExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileExpr(JuliarParser.DoWhileExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#userDefinedTypeResolutionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedTypeResolutionOperator(JuliarParser.UserDefinedTypeResolutionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(JuliarParser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#identifierName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierName(JuliarParser.IdentifierNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(JuliarParser.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JuliarParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(JuliarParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(JuliarParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecreaseExpression(JuliarParser.PreDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(JuliarParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(JuliarParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(JuliarParser.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeofExpression(JuliarParser.TypeofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofExpression(JuliarParser.InstanceofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlusExpression(JuliarParser.UnaryPlusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteExpression(JuliarParser.DeleteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JuliarParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JuliarParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitShiftExpression(JuliarParser.BitShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(JuliarParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JuliarParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitNotExpression(JuliarParser.BitNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclarationExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationExpression(JuliarParser.VariableDeclarationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(JuliarParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDotExpression(JuliarParser.MemberDotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(JuliarParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberIndexExpression(JuliarParser.MemberIndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndExpression(JuliarParser.BitAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperatorExpression(JuliarParser.AssignmentOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JuliarParser#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidExpression(JuliarParser.VoidExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JuliarParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#reassignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReassignmentExpression(JuliarParser.ReassignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JuliarParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JuliarParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JuliarParser.LiteralContext ctx);
}