package challenges.year2024.day11;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD11 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d11.txt");
        List<String> debug = Helper.readInput("year2024/d11d.txt");

        StoneRowHelper stoneRowHelper = new StoneRowHelper(input);
        System.out.println(stoneRowHelper.calcNumbersAfterIterations(1000));
    }


}
