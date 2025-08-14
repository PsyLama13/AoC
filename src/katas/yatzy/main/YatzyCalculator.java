package katas.yatzy.main;

import java.util.List;

public interface YatzyCalculator {
    List<String> validCategories();
    int score(List<Integer> dice, String category);
}