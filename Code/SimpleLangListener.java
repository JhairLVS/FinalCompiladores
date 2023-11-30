// Generated from SimpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(SimpleLangParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(SimpleLangParser.OperatorContext ctx);
}