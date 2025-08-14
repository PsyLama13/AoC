package katas.yatzy.main.yatzy3;

import java.util.List;

public class StraightScorer extends CategoryScorer {
    private final int straightExcludes;

    public StraightScorer(int straightExcludes) {
        this.straightExcludes = straightExcludes;
    }

    boolean isStraight(List<Integer> dice) {
        return frequencies(dice).values().stream().filter(frequency -> frequency == 1).toList().size() == 5;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        if (isStraight(dice) && frequencies(dice).get(straightExcludes) == 0) {
            return sum(dice);
        }
        return 0;
    }
}