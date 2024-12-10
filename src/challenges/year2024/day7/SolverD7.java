package challenges.year2024.day7;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD7 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d7.txt");
        List<String> debug = Helper.readInput("year2024/d7d.txt");

        Calibrator calibrator = new Calibrator(input);

        System.out.println(calibrator.calc1());
    }
}
