package challenges.year2021.d5;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD5 {

    public static void main(String[] args) throws IOException {
        List<String> debug = Helper.readInput("d5_debug.txt");
        List<String> test = Helper.readInput("d5d.txt");

        solveFirst(test);
    }

    private static void solveFirst(List<String> input){
        OceanVentMap oceanVentMap = new OceanVentMap(input);
        oceanVentMap.drawMap();
        System.out.println(oceanVentMap.getScore());
    }
}
