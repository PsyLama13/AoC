package challenges.year2024.day16.sub;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class Solverd16_2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d16.txt");
        List<String> debug = Helper.readInput("year2024/d16d.txt");

        MazeHelper mh = new MazeHelper(input);
        System.out.println(mh.calc1());
        System.out.println(mh.calc2());
    }
}
