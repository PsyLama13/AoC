package challenges.year2024.day4;

import java.util.List;

public class WordSearch {
    WordGrid wordGrid;
    public WordSearch(List<String> debug) {
        wordGrid = new WordGrid(debug);
    }

    public int calc1() {
        return wordGrid.findAllXMAS();
    }

    public int calc2(){
        return wordGrid.findAllCrossMAS();
    }
}
