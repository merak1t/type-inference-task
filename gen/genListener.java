// Generated from /home/merak1t/IdeaProjects/type-inference-task/src/main/java/gen.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link genParser}.
 */
public interface genListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link genParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(genParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(genParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(genParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(genParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#func_command}.
	 * @param ctx the parse tree
	 */
	void enterFunc_command(genParser.Func_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#func_command}.
	 * @param ctx the parse tree
	 */
	void exitFunc_command(genParser.Func_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(genParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(genParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(genParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(genParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(genParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(genParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void enterReturnValue(genParser.ReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#returnValue}.
	 * @param ctx the parse tree
	 */
	void exitReturnValue(genParser.ReturnValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(genParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(genParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(genParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(genParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link genParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(genParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link genParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(genParser.TupleContext ctx);
}