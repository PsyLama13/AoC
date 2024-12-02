package y2015.d6;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD6 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("y2015/d6.txt");
        List<String> debug = List.of("turn on 0,0 through 999,999", "turn off 499,499 through 500,500", "toggle 0,0 through 999,0");

        LightCoordinator lightCoordinator = new LightCoordinator(input);

        System.out.println(lightCoordinator.handleInstructionsAndCountLights());
    }
}
