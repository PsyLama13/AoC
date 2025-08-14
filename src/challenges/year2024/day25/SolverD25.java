package challenges.year2024.day25;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD25 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d25.txt");
        List<String> debug = Helper.readInput("year2024/d25d.txt");

        KeySolver keySolver = new KeySolver(input);

        System.out.println(keySolver.calc1());
    }
}
