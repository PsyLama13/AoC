package challenges.year2024.day12;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class SolverD12 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d12.txt");
        List<String> debug = Helper.readInput("year2024/d12d.txt");

        GardenHelper gardenHelperDebug = new GardenHelper(debug);
        GardenHelper gardenHelper = new GardenHelper(input);

        logger.log(Level.INFO, () -> "debug part 1: " + gardenHelperDebug.calc1());
        logger.log(Level.INFO, () -> "debug part 2: " + gardenHelperDebug.calc2());
        logger.log(Level.INFO, () -> "part 1: " + gardenHelper.calc1());
        logger.log(Level.INFO, () -> "part 2: " + gardenHelper.calc2());
    }
}