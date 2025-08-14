package katas.yatzy.main.yatzy2;

import katas.yatzy.main.YatzyCalculator;
import katas.yatzy.main.YatzyCategory;

import java.util.*;

public class Yatzy2 implements YatzyCalculator {
    static final List<Integer> DICE_VALUES = Arrays.asList(6, 5, 4, 3, 2, 1);

    @Override
    public List<String> validCategories() {
        return Arrays.stream(YatzyCategory.values()).map(Enum::toString).toList();
    }

    @Override
    public int score(List<Integer> dice, String categoryName) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);
        Map<Integer, Integer> diceFrequencies = createDiceFrequencyMap(dice);
        return getResultByCategory(diceFrequencies, category, dice);
    }

    private int getResultByCategory(Map<Integer, Integer> diceFrequencies, YatzyCategory category, List<Integer> dice) {
        return switch (category) {
            case CHANCE -> dice.stream().mapToInt(Integer::intValue).sum();
            case YATZY -> getYatzyScore(diceFrequencies);
            case ONES -> diceFrequencies.get(1);
            case TWOS -> diceFrequencies.get(2) * 2;
            case THREES -> diceFrequencies.get(3) * 3;
            case FOURS -> diceFrequencies.get(4) * 4;
            case FIVES -> diceFrequencies.get(5) * 5;
            case SIXES -> diceFrequencies.get(6) * 6;
            case PAIR -> getOfAKindScore(diceFrequencies, 2);
            case THREE_OF_A_KIND -> getOfAKindScore(diceFrequencies, 3);
            case FOUR_OF_A_KIND -> getOfAKindScore(diceFrequencies, 4);
            case SMALL_STRAIGHT -> getSmallStraightScore(diceFrequencies);
            case LARGE_STRAIGHT -> getLargeStraightScore(diceFrequencies);
            case TWO_PAIRS -> getTwoPairsScore(diceFrequencies);
            case FULL_HOUSE -> getFullHouseScore(diceFrequencies, dice);
        };
    }

    private int getYatzyScore(Map<Integer, Integer> diceFrequencies) {
        // score for yatzy if all dice are the same
        int yatzyResult = 0;
        if (diceFrequencies.containsValue(5)) {
            yatzyResult = 50;
        }
        return yatzyResult;
    }

    private int getOfAKindScore(Map<Integer, Integer> diceFrequencies, int amount) {
        for (int i : DICE_VALUES) {
            if (diceFrequencies.get(i) >= amount) {
                return i * amount;
            }
        }
        return 0;
    }

    private int getSmallStraightScore(Map<Integer, Integer> diceFrequencies) {
        // score if dice contains 1,2,3,4,5
        return getStraightScore(diceFrequencies, 6);
    }

    private int getLargeStraightScore(Map<Integer, Integer> diceFrequencies) {
        // score if dice contains 2,3,4,5,6
        return getStraightScore(diceFrequencies, 1);
    }

    private int getStraightScore(Map<Integer, Integer> diceFrequencies, int notNeeded) {

        List<Integer> expected = new ArrayList<>(DICE_VALUES);
        int index = expected.indexOf(notNeeded);
        expected.remove(index); // remove 6 from expected, as it is not needed

        if (diceFrequencies.get(notNeeded) != 0) {
            return 0;
        }

        for (int num : expected) {
            if (diceFrequencies.get(num) != 1) {
                return 0;
            }
        }

        return diceFrequencies.entrySet().stream().filter(i -> !i.getValue().equals(0)).mapToInt(Map.Entry::getKey).sum();
    }

    private int getTwoPairsScore(Map<Integer, Integer> diceFrequencies) {
        // score if there are two pairs
        int twoPairResult = 0;
        long pairCount = 0L;
        for (Integer frequency : diceFrequencies.values()) {
            if (frequency >= 2) {
                pairCount++;
            }
        }
        if (pairCount == 2) {
            for (int i : DICE_VALUES) {
                if (diceFrequencies.get(i) >= 2) {
                    twoPairResult += i * 2;
                }
            }
        }
        return twoPairResult;
    }

    private int getFullHouseScore(Map<Integer, Integer> diceFrequencies, List<Integer> dice) {
        // score if there is a pair as well as three of a kind
        int fullHouseResult = 0;
        if (diceFrequencies.containsValue(2) && diceFrequencies.containsValue(3)) {
            for (Integer die : dice) {
                fullHouseResult += die;
            }
        }
        return fullHouseResult;
    }

    private Map<Integer, Integer> createDiceFrequencyMap(List<Integer> dice) {
        Map<Integer, Integer> freqencyMap = new HashMap<>();
        for (int i : DICE_VALUES) {
            freqencyMap.put(i, 0);
        }
        for (int die : dice) {
            freqencyMap.put(die, freqencyMap.get(die) + 1);
        }
        return freqencyMap;
    }
}