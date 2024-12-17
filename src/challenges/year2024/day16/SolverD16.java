package challenges.year2024.day16;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD16 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d16.txt");
        List<String> debug = Helper.readInput("year2024/d16d.txt");


        MazeHelper mh = new MazeHelper(debug);
        System.out.println(mh.calc2());


        //MazeSolver mazeSolver = new MazeSolver(debug);
        //System.out.println(mazeSolver.calc1());
        //System.out.println(mazeSolver.calc2());
    }
}
