package challenges.year2024.day20;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class SolverD20 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d20.txt");
        List<String> debug = Helper.readInput("year2024/d20d.txt");

        RaceHelper raceHelperDebug = new RaceHelper(debug);
        RaceHelper raceHelper = new RaceHelper(input);

        logger.log(Level.INFO, ()->"debug part 1: " + raceHelper.calc1());

        //logger.log(Level.INFO, () -> "part 1: " + raceHelper.calc1(100));
    }
}
