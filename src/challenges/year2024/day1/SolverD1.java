package challenges.year2024.day1;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class SolverD1 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d1.txt");
        List<String> debug = Helper.readInput("year2024/d1d.txt");

        DistanceHelper distanceHelper = new DistanceHelper(input);
        DistanceHelper distanceHelperDebug = new DistanceHelper(debug);
        logger.log(Level.INFO, () -> "debug part 1: " + distanceHelperDebug.calc1());
        logger.log(Level.INFO, () -> "debug part 2: " + distanceHelperDebug.calc2());
        logger.log(Level.INFO, () -> "part 1: " + distanceHelper.calc1());
        logger.log(Level.INFO, () -> "part 2: " + distanceHelper.calc1());
    }
}
