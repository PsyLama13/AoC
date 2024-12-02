package y2021.d3;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD3 {

    public static void main(String[] args) throws IOException {
        List<String> inputDebug = Helper.readInput("d3_debug.txt");
        List<String> input = Helper.readInput("d3.txt");

        //System.out.println(solveFirst(input));
        System.out.println(solveSecond(input));
    }

    private static int solveFirst(List<String> input){
        Report report = new Report(input);
        return report.getPowerConsumption();
    }

    private static int solveSecond(List<String> input){
        Report report = new Report(input);
        return report.getLifeSupportRating();
    }
}
