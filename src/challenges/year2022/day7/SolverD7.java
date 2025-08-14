package challenges.year2022.day7;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD7 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2022/d7.txt");
        List<String> debug = Helper.readInput("year2022/d7d.txt");

        AoCFileSystem aoCFileSystem = new AoCFileSystem(input);
        System.out.println(aoCFileSystem.calc1());
    }
}
