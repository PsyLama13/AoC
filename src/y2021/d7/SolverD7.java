package y2021.d7;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD7 {

    public static void main(String[] args) throws IOException {
        List<String> debug = Helper.readInput("d7_debug.txt");
        List<String> input = Helper.readInput("d7.txt");

        System.out.println(solveSecond(input));

    }

    private static int solveSecond(List<String> input) {
        Aligner aligner = new Aligner(input);
        return aligner.getLeastFuelSecond();
    }

    private static int solveFirst(List<String> input) {
        Aligner aligner = new Aligner(input);
        return aligner.getLeastFuel();
    }


}
