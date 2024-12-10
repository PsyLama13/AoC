package challenges.year2020.d5;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD5 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2020/d5d.txt");
        List<String> debug = List.of("FBFBBFFRLR");

        BoardingHelper boardingHelper = new BoardingHelper(input);

        //System.out.println(boardingHelper.calc1());
        System.out.println(boardingHelper.calc2());
    }
}
