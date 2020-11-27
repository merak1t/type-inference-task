public abstract class Expression {
    String name;
    int[] type = new int[]{0, 0};


    public String getName() {
        return name;
    }


    public boolean isInt() {
        return type[0] == 1 && type[1] == 0;
    }

    public boolean isN() {
        return type[1] == 1 && type[0] == 0;
    }

    public String getType() {
        var res = new StringBuilder(String.format("%d", type[0]));
        if (type[1] > 0) {
            if (type[0] != 0) {
                res.append("+");
            } else {
                res = new StringBuilder();
            }
            if (type[1] == 1) {
                res.append("n");
            } else {
                res.append(String.format("%d*n", type[1]));
            }

        } else if (type[0] == 1) {
            return "int";
        }

        return "int[" + res.toString() + "]";
    }

    public void add(Variable other) {
        this.type[0] += other.type[0];
        this.type[1] += other.type[1];
        addTuple(other);
    }


    abstract void addTuple(Variable other);

    ;

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
