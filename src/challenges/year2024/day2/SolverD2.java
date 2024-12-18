package challenges.year2024.day2;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class SolverD2 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d2.txt");
        List<String> debug = Helper.readInput("year2024/d2d.txt");

        ReactorHelper reactorHelperDebug = new ReactorHelper(debug);
        ReactorHelper reactorHelper = new ReactorHelper(input);
        logger.log(Level.INFO, () -> "debug part 1: " + reactorHelperDebug.calc1());
        logger.log(Level.INFO, () -> "debug part 2: " + reactorHelperDebug.calc2());
        logger.log(Level.INFO, () -> "part 1: " + reactorHelper.calc1());
        logger.log(Level.INFO, () -> "part 2: " + reactorHelper.calc2());
    }
}
