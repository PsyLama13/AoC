package y2015.d5;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD5 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2015/d5.txt");
        List<String> debug = List.of("ugknbfddgicrmopn", "aaa", "jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb");
        List<String> debug2 = List.of("qjhvhtzxzqqjkmpb", "xxyxx", "uurcxstgmygtbstg", "ieodomkazucvgmuy");

        NiceStringCounter niceStringCounter = new NiceStringCounter(input);

        //System.out.println(niceStringCounter.count());
        System.out.println(niceStringCounter.countCorrect());
    }
}
