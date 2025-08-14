package challenges.year2024.day19;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class Day19Solver extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d19.txt");
        List<String> debug = Helper.readInput("year2024/d19d.txt");

        TowelHelper towelHelperDebug = new TowelHelper(debug);
        TowelHelper towelHelper = new TowelHelper(input);

        //logger.log(Level.INFO, () -> "debug part 1: " + towelHelper.calc1());
        //System.out.println(towelHelper.calc2());
        //logger.log(Level.INFO, () -> "part 1: " + towelHelper.calc1());
        logger.log(Level.INFO, () -> "part 2: " + towelHelper.calc2());

    }
}
