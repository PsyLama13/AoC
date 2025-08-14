package katas.yatzy.main.yatzy3;


import katas.yatzy.main.YatzyCalculator;
import katas.yatzy.main.YatzyCategory;

import java.util.Arrays;
import java.util.List;

public class Yatzy3 implements YatzyCalculator {
    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).toList();
    }

    @Override
    public int score(List<Integer> dice, String category) {
        return CategoryScorer.createInstance(category).calculateScore(dice);
    }
}