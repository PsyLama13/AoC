package challenges.year2024.day3;

public class DontFunction implements MemoryFunction {
    int location;

    public DontFunction(int location) {
        this.location = location;
    }

    @Override
    public boolean getAvailability() {
        return false;
    }

    @Override
    public int getResult() {
        return 0;
    }

    @Override
    public FunctionType getFunctionType() {
        return FunctionType.DONT;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
