package challenges.year2025.day01;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class D1Solver {
    private D1Solver(){
        throw new IllegalStateException("utility class");
    }

    public static void main() throws IOException {
        List<String> debug = Helper.readInput("year2025/d1d.txt");
        List<String> input = Helper.readInput("year2025/d1.txt");

        SafeSolver test = new SafeSolver(debug);
        SafeSolver real = new SafeSolver(input);

        IO.println(test.solve1());
        IO.println(test.solve2());

        IO.println(real.solve1());
        IO.println(real.solve2());
    }
}
