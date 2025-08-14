package other.fisch;

import helper.Solver;

import java.util.logging.Level;

public class FischliGame extends Solver {

    public static void main(String[] args) {

        int startline = 6;
        int numOfGames = 100000;
        Game game = new Game(startline);
        int fishWins = game.play(numOfGames);
        float percent = (float) fishWins / numOfGames;
        logger.log(Level.INFO, () -> String.valueOf(percent * 100));
    }
}