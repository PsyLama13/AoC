package challenges.year2019.day1;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2019/d1.txt");
        List<String> debug = Helper.readInput("year2019/d1d.txt");

        FuelCalculator fuelCalculator = new FuelCalculator(input);
        System.out.println(fuelCalculator.calc1());
        System.out.println(fuelCalculator.calc2());
    }
}
