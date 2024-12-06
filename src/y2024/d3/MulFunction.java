package y2024.d3;

public class MulFunction implements MemoryFunction {

    int n1;
    int n2;
    int location;

    public MulFunction(int num1, int num2, int location) {
        n1 = num1;
        n2 = num2;
        this.location = location;
    }

    @Override
    public boolean getAvailability() {
        return false;
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
