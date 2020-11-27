public class Variable extends Expression {

    public Variable() {
        this.name = "noname";
    }

    public Variable(String name, String funcName, boolean isTail) {
        this.name = name;
        int[] typeTail = new int[]{0, 1};
        int[] typeInt = new int[]{1, 0};
        this.type = isTail ? typeTail : typeInt;
    }

    public Variable(Variable other) {
        this.name = other.name;
        this.type = other.type.clone();
    }

    @Override
    void addTuple(Variable other) {
        // do nothing
    }

}
