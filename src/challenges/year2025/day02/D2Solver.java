package challenges.year2025.day02;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class D2Solver {
    private D2Solver() {
        throw new IllegalStateException("utility class");
    }

    public static void main() throws IOException {
        List<String> debug = Helper.readInput("year2025/d2d.txt");
        List<String> input = Helper.readInput("year2025/d2.txt");
        SequenceGenerator testGenerator = new SequenceGenerator(debug);
        SequenceGenerator prodGenerator = new SequenceGenerator(input);

        IO.println(testGenerator.calcSillySum(2));
        IO.println(prodGenerator.calcSillySum(2));

        IO.println(testGenerator.calcSillySum(null));
        IO.println(prodGenerator.calcSillySum(null));
    }
}
