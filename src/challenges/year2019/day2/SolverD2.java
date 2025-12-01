package challenges.year2019.day2;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2019/d2.txt");
        List<String> debug = Helper.readInput("year2019/d2d.txt");

        IntcodeHelper intcodeHelper = new IntcodeHelper(input);
        System.out.println(intcodeHelper.calc1());
    }
}
