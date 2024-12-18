package challenges.year2024.day18;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD18 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d18.txt");
        List<String> debug = Helper.readInput("year2024/d18d.txt");

        BitMazeSolver bitMazeSolver = new BitMazeSolver(input, 70, 70, 1024);
        //BitMazeSolver debugSolver = new BitMazeSolver(debug, 6, 6);

        System.out.println(bitMazeSolver.calc1());
        calc2(input, 70);
    }

    private static void calc2(List<String> input, int max){
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            BitMazeSolver bitMazeSolver = new BitMazeSolver(input, max, max, i);
            int val = bitMazeSolver.calc1();
            if(val == Integer.MAX_VALUE){
                System.out.println(input.get(i-1));
                return;
            }
        }
    }
}
