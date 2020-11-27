import java.util.ArrayList;

public class Tuple extends Expression {
    ArrayList<Variable> data;

    public Tuple() {
        this.name = "tuple";
        data = new ArrayList<>();
    }

    @Override
    public void addTuple(Variable other) {
        data.add(other);
    }
}
