package katas.yatzy.main.yatzy3;


import katas.yatzy.main.YatzyCalculator;

import java.util.List;

public class Yatzy3 implements YatzyCalculator {

    @Override
    public int score(List<Integer> dice, String category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}