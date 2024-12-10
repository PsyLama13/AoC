package challenges.year2021.d4;

import java.util.List;

public class BingoCard {

    List<String> input;
    BingoGrid bingoGrid;
    boolean hasWon = false;

    public BingoCard(List<String> input) {
        this.input = input;
        bingoGrid = new BingoGrid(input);
    }

    public void markNumber(int val) {
        bingoGrid.markNumber(val);
    }

    public Integer getScore(int val) {

        Integer num = bingoGrid.getWinningNumber();
        if (num != null) {
            hasWon = true;
            return val * num;
        }
        return null;
    }
}
