package challenges.year2024.day21;

import helper.Helper;
import helper.Solver;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class SolverD21 extends Solver {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d21.txt");

        MoveEncoderHelper moveEncoderHelper = new MoveEncoderHelper(input);

        logger.log(Level.INFO, () -> "part 1: " + moveEncoderHelper.calc1());
        logger.log(Level.INFO, () -> "part 1: " + moveEncoderHelper.calc2());
    }
}
