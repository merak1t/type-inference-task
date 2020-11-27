import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor extends AbstractParseTreeVisitor<String> implements genVisitor<String> {

    private ArrayList<Variable> currentMainVars = new ArrayList<>();
    private HashMap<String, Function> functions = new HashMap<>();
    private String currentMainFunc;
    private String currentOperFunc;
    private ArrayList<Variable> currentOperVars = new ArrayList<>();
    private Variable currentExpression;


    private void addMainFunc() {
        var newFunc = new Function(currentMainFunc);
        for (var curVar : currentMainVars) {
            newFunc.addInputType(curVar.type);
        }
        functions.put(currentMainFunc, newFunc);
    }

    @Override
    public String visitProgram(genParser.ProgramContext ctx) {
        var res = new StringBuilder();
        for (var context : ctx.children) {
            //System.out.println(context.getText());
            //System.out.println(context instanceof genParser.FunctionContext);
            if (context instanceof genParser.FunctionContext) {
                res.append(visitFunction((genParser.FunctionContext) context));
            } else {
                res.append(context.getText());
            }
            res.append("\n");
        }
        return res.toString();
    }

    @Override
    public String visitFunction(genParser.FunctionContext ctx) {
        var res = new StringBuilder();
        res.append(visitHeader(ctx.header()));
        addMainFunc();
        res.append("\n");
        for (var context : ctx.func_command()) {
            visitFunc_command(context);
            res.append("\n");
        }
        res.append(visitReturnValue(ctx.returnValue()));
        res.append("\n");
        return res.toString();
    }

    @Override
    public String visitFunc_command(genParser.Func_commandContext ctx) {
        currentOperFunc = ctx.NAME().getText();
        if (!functions.containsKey(currentOperFunc)) {
            return "Fail: unexpected function name " + currentOperFunc;
        }
        if (currentOperFunc.equals(currentMainFunc)) {
            return "Fail: unexpected recursion found";
        }
        var res = visitArgs(ctx.args());
        // ToDo check types at @currentOperVars
        return res;
    }

    @Override
    public String visitHeader(genParser.HeaderContext ctx) {
        currentMainFunc = ctx.NAME().getText();
        var res = new StringBuilder(currentMainFunc);
        res.append("(");
        visitDeclaration(ctx.declaration());
        res.append(")\n");
        return res.toString();
    }

    private void updateInputTypeFunc() {
        var summVar = new Variable();
        for (var cur : currentMainVars) {
            summVar.add(cur);
        }
        var mainFunc = functions.get(currentMainFunc);
        mainFunc.inputType = summVar.type;
        functions.replace(currentMainFunc, mainFunc);
    }

    @Override
    public String visitDeclaration(genParser.DeclarationContext ctx) {
        var res = new StringBuilder();
        currentMainVars = new ArrayList<>();
        for (var context : ctx.NAME()) {
            var newVar = new Variable(context.getText(), currentMainFunc, false);
            currentMainVars.add(newVar);
            if (res.length() > 0) {
                res.append(", ");
            }
            res.append(newVar.getType() + ' ' + newVar.getType());
        }
        if (ctx.tail() != null) {
            res.append(visitTail(ctx.tail()));
        }
        //updateInputTypeFunc();
        return res.toString();
    }

    @Override
    public String visitTail(genParser.TailContext ctx) {
        var res = new StringBuilder();
        var context = ctx.NAME();
        var newVar = new Variable(context.getText(), currentMainFunc, true);
        if (currentMainVars.size() > 0) {
            res.append(", ");
        }
        currentMainVars.add(newVar);
        res.append(newVar.getType() + ' ' + newVar.getType());
        return res.toString();
    }

    // need to update function --Done
    @Override
    public String visitReturnValue(genParser.ReturnValueContext ctx) {
        var res = new StringBuilder();
        res.append(currentMainFunc).append(": ");
        var resFunc = functions.get(currentMainFunc);
        res.append(resFunc.getType("in")).append(" -> ");
        if (ctx.func_command() != null) {
            var resCommand = visitFunc_command(ctx.func_command());
            var curFunc = functions.get(currentOperFunc);
            resFunc.outputType = curFunc.outputType;
            functions.replace(currentMainFunc, resFunc);
            res.append(resFunc.getType("out"));
            return res.toString();
        } else if (ctx.expression() != null) {
            var resExpr = visitExpression(ctx.expression());
            res.append(currentExpression.getType());
            return res.toString();
        } else {
            return "fail: empty return";
        }
    }


    @Override
    public String visitArgs(genParser.ArgsContext ctx) {
        var res = new StringBuilder();
        currentOperVars = new ArrayList<>();
        for (var context : ctx.expression()) {
            res.append(visitExpression(context)).append(' ');
            currentOperVars.add(currentExpression);
        }
        return res.toString();
    }

    @Override
    public String visitExpression(genParser.ExpressionContext ctx) {
        currentExpression = new Variable();
        if (ctx.NAME() != null) {
            var curName = ctx.NAME().getText();
            Variable foundVar = null;
            for (var variable : currentMainVars) {
                if (variable.getName().equals(curName)) {
                    foundVar = variable;
                }
            }
            if (foundVar == null) {
                return "Fail: variable " + curName + " not declared";
            }
            currentExpression = foundVar;
            return currentExpression.getName();
        } else if (ctx.INTEGER() != null) {
            currentExpression = new Variable(ctx.INTEGER().getText(), "int", false);
            return currentExpression.getName();
        } else if (ctx.tuple() != null) {
            return visitTuple(ctx.tuple());
        } else {
            return "fail on parse expression " + ctx.getText();
        }
    }

    @Override
    public String visitTuple(genParser.TupleContext ctx) {
        var res = new StringBuilder();
        var summVar = new Variable();
        for (var context : ctx.expression()) {
            res.append(visitExpression(context)).append(' ');
            summVar.add(currentExpression);
        }
        currentExpression = summVar;
        return res.toString();
    }
}