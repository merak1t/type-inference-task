import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Visitor extends AbstractParseTreeVisitor<String> implements genVisitor<String> {

    private ArrayList<Variable> currentMainVars = new ArrayList<>();
    private final HashMap<String, Function> functions = new HashMap<>();
    private String currentMainFunc;
    private String currentOperFunc;
    private ArrayList<Expression> currentOperVars = new ArrayList<>();
    private Expression currentExpression;
    private Variable currentExpressionTuple;


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
            res.append(visitFunc_command(context)).append('\n');
        }
        res.append(visitReturnValue(ctx.returnValue()));
        res.append("\n");
        return res.toString();
    }


    @Override
    public String visitFunc_command(genParser.Func_commandContext ctx) {
        currentOperFunc = ctx.NAME().getText();
        var res = new StringBuilder(currentOperFunc);
        if (!functions.containsKey(currentOperFunc)) {
            return "Fail: unexpected function name " + currentOperFunc;
        }
        if (currentOperFunc.equals(currentMainFunc)) {
            return "Fail: unexpected recursion found";
        }
        var curFunc = functions.get(currentOperFunc);
        res.append('(').append(visitArgs(ctx.args())).append(") : ").append(curFunc.getType("in")).append(" -> ").append(curFunc.getType("out"));
        var inference = updateTypesByCurrentFunction();
        if (inference.equals("accept")) {
            return res.toString();
        } else {
            return inference;
        }
    }

    @Override
    public String visitHeader(genParser.HeaderContext ctx) {
        currentMainFunc = ctx.NAME().getText();
        var res = new StringBuilder(currentMainFunc);
        res.append("(");
        res.append(visitDeclaration(ctx.declaration()));
        res.append(")\n");
        return res.toString();
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
            res.append(newVar.getName()).append(" : ").append(newVar.getType());
        }
        if (ctx.tail() != null) {
            res.append(visitTail(ctx.tail()));
        }
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
        res.append(newVar.getName()).append(" : ").append(newVar.getType());
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
            if (resCommand.startsWith("Fail")) {
                return resCommand;
            }
            var curFunc = functions.get(currentOperFunc);
            updateOutMainFunc(curFunc.outputType);
            //resFunc.outputType = curFunc.outputType;
            //functions.replace(currentMainFunc, resFunc);
            res.append(resFunc.getType("out"));
            return res.toString();
        } else if (ctx.expression() != null) {
            var resExpr = visitExpression(ctx.expression());
            updateOutMainFunc(currentExpression.type);
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
            if (res.length() > 0) {
                res.append(", ");
            }
            res.append(visitExpression(context)).append(" : ").append(currentExpression.getType());
            currentOperVars.add(currentExpression);
        }
        return res.toString();
    }

    @Override
    public String visitExpression(genParser.ExpressionContext ctx) {
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
    public String visitExpressionTuple(genParser.ExpressionTupleContext ctx) {
        currentExpressionTuple = new Variable();
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
            currentExpressionTuple = foundVar;
            return currentExpressionTuple.getName();
        } else if (ctx.INTEGER() != null) {
            currentExpressionTuple = new Variable(ctx.INTEGER().getText(), "int", false);
            return currentExpressionTuple.getName();
        } else {
            return "fail on parse expression " + ctx.getText();
        }
    }

    @Override
    public String visitTuple(genParser.TupleContext ctx) {
        currentExpression = new Tuple();
        for (var context : ctx.expressionTuple()) {
            visitExpressionTuple(context);
            currentExpression.add(currentExpressionTuple);
        }
        return "tuple";
    }

    private void updateOutMainFunc(int[] outputType) {
        var resFunc = functions.get(currentMainFunc);
        resFunc.outputType = outputType;
        functions.replace(currentMainFunc, resFunc);
    }

    private void addMainFunc() {
        var newFunc = new Function(currentMainFunc);
        for (var curVar : currentMainVars) {
            newFunc.addInputType(curVar.type);
        }
        functions.put(currentMainFunc, newFunc);
    }

    private boolean isTail(Variable tail, Variable other) {
        boolean hasTail = tail != null && tail.isN();
        return hasTail && other.name.equals(tail.name);
    }

    private int getNFromTuple(Variable tail, Expression current) {
        if (current instanceof Variable) {
            return isTail(tail, (Variable) current) ? 1 : 0;
        } else {
            int res = 0;
            for (var expr : ((Tuple) current).data) {
                res += getNFromTuple(tail, expr);
            }
            return res;
        }
    }

    // predict that (int) is int. Sample:
    // int x
    // (x) = x
    private String updateTypesByCurrentFunction() {
        int curVar = 0;
        var curFunc = functions.get(currentOperFunc);
        while (curVar < currentOperVars.size() && curFunc.inputType[0] > 0) {
            if (currentOperVars.get(curVar).isInt()) {
                curFunc.inputType[0]--;
                curVar++;
            } else {
                break;
            }
        }
        if (curFunc.inputType[0] == 0) {
            if (curFunc.inputType[1] == 1) {
                if (curVar + 1 == currentOperVars.size() && currentOperVars.get(curVar).isN()) {
                    return "accept";
                } else if (curVar + 1 == currentOperVars.size()) {
                    return "Fail\n" +
                            "Expected: int[n]\n" +
                            "But got:  " + currentOperVars.get(curVar).getType();
                } else {
                    return "Fail\n" +
                            "Expected: int[n]\n";
                }
            } else { // inputType[1] == 0
                if (curVar == currentOperVars.size()) {
                    return "accept";
                } else {
                    return "Fail\n" +
                            "Expected: Nothing\n" +
                            "But got:  " + currentOperVars.get(curVar).getType();
                }
            }
        } else {
            if (curVar == currentOperVars.size()) {
                return "Fail\n" +
                        "Expected: " + curFunc.getType("in");
            } else {
                var tail = currentMainVars.get(currentMainVars.size() - 1);
                // some tuple exist
                int count_tails = 0;
                boolean hasTail = tail != null && tail.isN();
                for (int i = curVar; i < currentOperVars.size(); i++) {
                    var currentVar = currentOperVars.get(i);
                    curFunc.diff(currentVar);
                    if (currentVar instanceof Variable) {
                        if (isTail(tail, (Variable) currentVar)) {
                            count_tails += 1;
                        }
                    } else { // Tuple
                        count_tails += getNFromTuple(tail, currentVar);
                    }
                }
                if (count_tails == 0) {
                    if (curFunc.inputType[0] == 0) {
                        return "accept";
                    } else {
                        return "Fail\nExpected: " + curFunc.inputType[0] + " ints";
                    }
                } else {
                    if (curFunc.inputType[0] % count_tails == 0 && curFunc.inputType[1] % count_tails == 0) {
                        // update tail
                        assert tail != null;
                        var newTail = new Variable(tail);
                        newTail.type[0] = Math.max(newTail.type[0], 1) * (curFunc.inputType[0] / count_tails);
                        newTail.type[1] *= (curFunc.inputType[1] / count_tails);
                        var mainFunc = functions.get(currentMainFunc);
                        mainFunc.update(tail, newTail);
                        functions.replace(currentMainFunc, mainFunc);
                        currentMainVars.set(currentMainVars.size() - 1, newTail);
                        return "accept";
                    } else {
                        return "Fail\n" +
                                "Expected:" + count_tails + " times " + tail.getType() + '\n' +
                                "But got:  " + curFunc.getType("in");
                    }
                }
            }
        }
    }

}