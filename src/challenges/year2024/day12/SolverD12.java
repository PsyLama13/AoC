package challenges.year2024.day12;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD12 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d12.txt");
        List<String> debug = Helper.readInput("year2024/d12d.txt");

        GardenHelper gardenHelper = new GardenHelper(debug);

        //System.out.println(gardenHelper.calc1());
        System.out.println(gardenHelper.calc2());
    }
}
