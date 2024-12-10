package challenges.year2024.day1;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d1.txt");
        List<String> debug = Helper.readInput("year2024/d1d.txt");


        DistanceHelper distanceHelper = new DistanceHelper(input);

        //System.out.println(distanceHelper.calc1());
        System.out.println(distanceHelper.calc2());
    }
}
