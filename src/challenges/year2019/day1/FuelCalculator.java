package challenges.year2019.day1;

import java.util.ArrayList;
import java.util.List;

public class FuelCalculator {
    List<Module> modules = new ArrayList<>();

    public FuelCalculator(List<String> input) {
        for (String s : input) {
            modules.add(new Module(Integer.parseInt(s)));
        }
    }

    public Integer calc1() {
        int sum = 0;
        for (Module module : modules) {
            int fuel = module.getFuel();
            sum += fuel;
        }
        return sum;
    }


    public int calc2() {
        int sum = 0;
        for (Module module : modules) {
            sum += module.getExtendedFuel();
        }
        return sum;
    }
}
