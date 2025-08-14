package challenges.year2024.day24;

public class Gate implements Comparable<Gate>{
    private String input1;
    private String input2;
    private String output;
    private GateType type;

    public Gate(String input1, String input2, String output, GateType type) {
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
        this.type = type;
    }

    public boolean calc(boolean var1, boolean var2) {
        return switch (type) {
            case AND -> var1 && var2;
            case OR -> var1 || var2;
            case XOR -> var1 ^ var2;
        };
    }

    public String getInput1() {
        return input1;
    }

    public String getInput2() {
        return input2;
    }

    public String getOutput() {
        return output;
    }

    public GateType getType(){
        return type;
    }

    @Override
    public String toString() {
        return input1 + " " + type + " " + input2 + " -> " + output;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((output == null) ? 0 : output.hashCode());
        result = prime * result + ((input1 == null) ? 0 : input1.hashCode());
        result = prime * result + ((input2 == null) ? 0 : input2.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Gate other = (Gate) obj;
        if (output == null) {
            if (other.output != null)
                return false;
        } else if (!output.equals(other.output))
            return false;
        if (input1 == null) {
            if (other.input1 != null)
                return false;
        } else if (!input1.equals(other.input1))
            return false;
        if (input2 == null) {
            if (other.input2 != null)
                return false;
        } else if (!input2.equals(other.input2))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public int compareTo(final Gate o) {
        return this.output.compareTo(o.output);
    }
}
