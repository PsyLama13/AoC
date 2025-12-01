package challenges.year2025.day01;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class D1Solver {

    public static void main(String[] args) throws IOException {
        List<String> debug = Helper.readInput("year2025/d1d.txt");
        List<String> input = Helper.readInput("year2025/d1.txt");

        SafeSolver test = new SafeSolver(debug);
        SafeSolver real = new SafeSolver(input);

        //IO.println(real.solve1());
        IO.println(real.solve2());
    }
}
