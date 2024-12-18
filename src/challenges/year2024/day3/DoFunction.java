package challenges.year2024.day3;

public class DoFunction implements MemoryFunction {

    int location;

    public DoFunction(int location) {
        this.location = location;
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.DO;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
