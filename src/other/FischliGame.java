package other;

public class FischliGame {

    public static void main(String[] args) {

        int startline = 5;
        int numOfGames = 10000;
        Game game = new Game(startline);
        int fishWins = game.play(numOfGames);
        float percent = (float) fishWins / numOfGames;
        System.out.println(percent * 100);
    }
}
