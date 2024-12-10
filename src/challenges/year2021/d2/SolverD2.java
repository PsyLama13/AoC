package challenges.year2021.d2;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD2 {

    public static void main(String[] args) throws IOException {
        List<String> inputDebug = Helper.readInput("d2_debug.txt");
        List<String> input = Helper.readInput("d2.txt");

        System.out.println(solveFirst(inputDebug));
        System.out.println(solveSecond(input));
    }

    private static int solveSecond(List<String> input) {

        Ship ship = new Ship();

        for(String s : input){
            ship.navigateWithAim(s);
        }

        return calculate(ship);
    }

    private static int solveFirst(List<String> strings) {

        Ship ship = new Ship();
        for(String s : strings){
            ship.navigate(s);
        }
        return calculate(ship);
    }

    private static int calculate(Ship ship) {
        return ship.getDepth() * ship.getHorizontal();
    }
}
