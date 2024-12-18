package challenges.year2024.day16;

import helper.Helper;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolverD16 {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("AoC");
        List<String> input = Helper.readInput("year2024/d16.txt");
        List<String> debug = Helper.readInput("year2024/d16d.txt");
        MazeHelper mhd = new MazeHelper(debug);
        MazeHelper mh = new MazeHelper(input);
        logger.log(Level.INFO, ()->String.valueOf(mhd.calc1()));
        logger.log(Level.INFO, ()->String.valueOf(mhd.calc2()));
        logger.log(Level.INFO, ()->String.valueOf(mh.calc1()));
        logger.log(Level.INFO, ()->String.valueOf(mh.calc2()));
    }
}
