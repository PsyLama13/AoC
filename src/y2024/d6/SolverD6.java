package y2024.d6;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD6 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2024/d6.txt");
        List<String> debug = Helper.readInput("y2024/d6d.txt");

        PathChecker pathChecker = new PathChecker(input);
        System.out.println(pathChecker.calc1());
        System.out.println(pathChecker.calc2());
    }
}
