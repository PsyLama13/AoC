package katas.yatzy.main.yatzy3;

import java.util.List;

public class ChanceScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        return sum(dice);
    }
}