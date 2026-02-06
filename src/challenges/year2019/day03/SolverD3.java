package challenges.year2019.day03;

import helper.Helper;

import java.util.List;

public class SolverD3 {
    void main(){
        List<String> debug1 = Helper.readInput("year2019/d3d.txt");
        List<String> debug2 = Helper.readInput("year2019/d3dd.txt");
        List<String> input = Helper.readInput("year2019/d3.txt");

        CrossWireSolver crossWireSolver = new CrossWireSolver(input);
        IO.println(crossWireSolver.solve1());
    }
}
