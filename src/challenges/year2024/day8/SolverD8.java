package challenges.year2024.day8;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD8 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d8.txt");
        List<String> debug = Helper.readInput("year2024/d8d.txt");

        AntennaHelper antennaHelper = new AntennaHelper(input);

        System.out.println(antennaHelper.calc1());
        System.out.println(antennaHelper.calc2());
    }
}
