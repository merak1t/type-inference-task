import java.util.ArrayList;

public class Function {
    int[] inputType = new int[]{0, 0};
    int[] outputType = new int[]{0, 0};
    String name;

    public Function(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void addInputType(int[] toAdd) {
        inputType[0] += toAdd[0];
        inputType[1] += toAdd[1];
    }

    public void diff(Expression other) {
        this.inputType[0] -= other.type[0];
    }

    public void update(Variable oldTail, Variable newTail) {
        this.inputType[0] -= oldTail.type[0];
        this.inputType[1] -= oldTail.type[1];

        this.inputType[0] += newTail.type[0];
        this.inputType[1] += newTail.type[1];
    }

    public String getType(String type) {
        var currType = type.equals("in") ? inputType : outputType;

        var res = new StringBuilder(String.format("%d", currType[0]));
        if (currType[1] > 0) {
            if (currType[0] != 0) {
                res.append("+");
            } else {
                res = new StringBuilder();
            }
            if (currType[1] == 1) {
                res.append("n");
            } else {
                res.append(String.format("%d*n", currType[1]));
            }

        } else if (currType[0] == 1) {
            return "int";
        }

        return "int[" + res.toString() + "]";
    }
}
