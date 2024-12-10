package challenges.year2021.d6;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD6 {
    public static void main(String[] args) throws IOException {
        List<String> debug = Helper.readInput("d6_debug.txt");
        List<String> input = Helper.readInput("d6.txt");

        System.out.println(solveFirst(input));
    }

    private static long solveFirst(List<String> input) {
        long start = System.currentTimeMillis();
        FishBowl fishBowl = new FishBowl(input);
        long output = fishBowl.getFishesForDays(256);
        long end = System.currentTimeMillis();
        System.out.println("took " + (end - start) + "ms");
        return output;

    }
}
