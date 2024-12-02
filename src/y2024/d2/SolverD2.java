package y2024.d2;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2024/d2.txt");
        List<String> debug = Helper.readInput("y2024/d2d.txt");

        ReactorHelper reactorHelper = new ReactorHelper(input);

        System.out.println(reactorHelper.calc2());
    }
}
