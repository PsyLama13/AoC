package challenges.year2024.day3;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD3 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d3.txt");
        List<String> debug = Helper.readInput("year2024/d3d.txt");

        FunctionHelper functionHelper = new FunctionHelper(input);
        System.out.println(functionHelper.calc2());
    }
}
