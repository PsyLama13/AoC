package y2024.d3;

public class DoFunction implements MemoryFunction {

    int location;

    public DoFunction(int location) {
        this.location = location;
    }

    @Override
    public boolean getAvailability() {
        return true;
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
