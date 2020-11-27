public class Variable {
    String name;
    String funcName;
    int[] type;

    public Variable() {
        this.name = "noname";
        this.funcName = "noname";
        this.type = new int[]{0, 0};
    }

    public Variable(String name, String funcName, boolean isTail) {
        this.name = name;
        this.funcName = funcName;
        int[] typeTail = new int[]{0, 1};
        int[] typeInt = new int[]{1, 0};
        this.type = isTail ? typeTail : typeInt;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        var res = new StringBuilder(String.format("%d", type[0]));
        if (type[1] > 0) {
            if (type[0] != 0) {
                res.append("+");
            }
            else {
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
    }

    @Override
    public int hashCode() {
        String toHash = funcName + '$' + name;
        return toHash.hashCode();
    }
}
