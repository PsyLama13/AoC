package challenges.year2024.day3;

public class MulFunction implements MemoryFunction {

    private final int n1;
    private final int n2;
    private final int location;

    public MulFunction(int num1, int num2, int location) {
        n1 = num1;
        n2 = num2;
        this.location = location;
    }

    @Override
    public int getResult() {
        return n1 * n2;
    }

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.MUL;
    }

    @Override
    public int getLocation() {
        return location;
    }
}