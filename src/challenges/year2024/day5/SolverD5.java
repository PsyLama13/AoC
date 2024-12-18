package challenges.year2024.day5;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD5 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d5.txt");
        List<String> debug = Helper.readInput("year2024/d5d.txt");

        SafetyProtocolHelper safetyProtocolHelper = new SafetyProtocolHelper(input);

        safetyProtocolHelper.calc1And2();
    }
}
