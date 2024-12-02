package y2015.d1;

import helper.Helper;

import java.io.IOException;
import java.util.List;


public class SolverD1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2015/d1.txt");

        BracketParser bracketParser = new BracketParser(input);
        System.out.println(bracketParser.getFirstBasementOccurence());
    }
}
