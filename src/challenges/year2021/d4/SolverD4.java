package challenges.year2021.d4;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD4 {

    public static void main(String[] args) throws IOException {
        List<String> debug = Helper.readInput("d4_debug.txt");
        List<String> input = Helper.readInput("d4d.txt");

        System.out.println(solveFirst(input));
    }

    private static int solveFirst(List<String> strings){
        BingoGame bingoGame = new BingoGame(strings);
        return bingoGame.getFinalScore();
    }

    private static int solveSecond(List<String> strings){
        BingoGame bingoGame = new BingoGame(strings);
        return bingoGame.getLastBoardScore();
    }
}
