package y2015.d7;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverP7 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2015/d7.txt");
        List<String> debug = Helper.readInput("y2015/d7d.txt");

        ConstructionKit constructionKit = new ConstructionKit(input);

        System.out.println(constructionKit.calculate("a"));
    }
}
