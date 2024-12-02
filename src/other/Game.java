package other;

import java.util.*;

public class Game {

    Map<Color, Integer> fishes = new HashMap<>();
    Set<Color> fisher = new HashSet<>();
    Set<Color> winningFishes = new HashSet<>();

    int boatPosition = 0;
    int startOffset;

    private final int FISH_START_POS_DEFAULT = 5;
    private final int FINISH_LINE = 10;

    public Game(int startOffset) {
        this.startOffset = startOffset;
        initGame(FISH_START_POS_DEFAULT + this.startOffset);
    }

    public void initGame(int startPos) {
        fishes.clear();
        fisher.clear();
        winningFishes.clear();

        fishes.put(Color.orange, startPos);
        fishes.put(Color.pink, startPos);
        fishes.put(Color.blue, startPos);
        fishes.put(Color.yellow, startPos);

        fisher.add(Color.green);
        fisher.add(Color.red);

        boatPosition = 0;
    }

    public int play(int numOfGames) {
        int numOfFishWins = 0;
        for (int i = 0; i < numOfGames; i++) {
            initGame(startOffset);
            boolean fishwin = playOneGame();
            if (fishwin) {
                numOfFishWins++;
            }
        }
        return numOfFishWins;
    }

    private boolean playOneGame() {
        int counter = 1;
        for (; ; ) {
            //System.out.println("Round " + counter);
            Color color = Color.rollDice();
            if (fishes.isEmpty()) {
                return winningFishes.size() > fisher.size();
            }
            handleRound(color);
            counter++;
        }
    }

    private void handleRound(Color color) {
        if (fisher.contains(color)) {
            boatPosition++;
        } else if (winningFishes.contains(color)) {
            Color lowestFishColor = getLowestFish();
            fishes.put(lowestFishColor, fishes.get(lowestFishColor) + 1);
        } else {
            fishes.put(color, fishes.get(color) + 1);
        }

        handleFishCatchAndSea();
    }

    private Color getLowestFish() {
        Map.Entry<Color, Integer> smallest = null;

        for (Map.Entry<Color, Integer> entry : fishes.entrySet()) {
            if (smallest == null || smallest.getValue() > entry.getValue()) {
                smallest = entry;
            }
        }
        return smallest.getKey();
    }

    private void handleFishCatchAndSea() {
        List<Color> toRemove = new ArrayList<>();
        for (Map.Entry<Color, Integer> entry : fishes.entrySet()) {
            if (entry.getValue() <= boatPosition) {
                fisher.add(entry.getKey());
                toRemove.add(entry.getKey());
            }
            if (entry.getValue() >= FINISH_LINE) {
                winningFishes.add(entry.getKey());
                toRemove.add(entry.getKey());
            }
        }
        for (Color c : toRemove) {
            fishes.remove(c);
        }
    }
}
