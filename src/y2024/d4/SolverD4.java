package y2024.d4;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD4 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2024/d4.txt");
        List<String> debug = Helper.readInput("y2024/d4d.txt");

        WordSearch wordSearch = new WordSearch(input);
        //System.out.println(wordSearch.calc1());
        System.out.println(wordSearch.calc2());
    }
}
