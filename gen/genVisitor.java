// Generated from /home/merak1t/IdeaProjects/type-inference-task/src/main/java/gen.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link genParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface genVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link genParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(genParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(genParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#func_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_command(genParser.Func_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(genParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(genParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(genParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#returnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValue(genParser.ReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(genParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(genParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link genParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(genParser.TupleContext ctx);
}