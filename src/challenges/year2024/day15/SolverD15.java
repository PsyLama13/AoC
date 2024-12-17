package challenges.year2024.day15;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD15 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d15.txt");
        List<String> debug = Helper.readInput("year2024/d15d.txt");

        WareHouse wareHouse = new WareHouse(input);
        wareHouse.runCommands();
        System.out.println(wareHouse.calc2());

    }
}
