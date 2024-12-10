package challenges.year2020.d6;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD6 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2020/d6.txt");
        List<String> debug = Helper.readInput("year2020/d6d.txt");

        QuestionHelper questionHelper = new QuestionHelper(input);

        System.out.println(questionHelper.calc2());

    }
}
