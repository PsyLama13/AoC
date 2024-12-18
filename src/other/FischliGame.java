package other;

import helper.Solver;

import java.util.logging.Level;

public class FischliGame extends Solver {

    public static void main(String[] args) {

        int startline = 5;
        int numOfGames = 10000;
        Game game = new Game(startline);
        int fishWins = game.play(numOfGames);
        float percent = (float) fishWins / numOfGames;
        logger.log(Level.INFO, () -> String.valueOf(percent * 100));
    }
}