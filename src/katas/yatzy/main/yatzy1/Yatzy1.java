package katas.yatzy.main.yatzy1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Yatzy1 {
    private static final List<Integer> DICE_VALUES = List.of(6, 5, 4, 3, 2, 1);

    private Yatzy1() {
        throw new IllegalStateException("utility class");
    }

    public static int chance(List<Integer> dice) {
        int total = 0;
        for (int num : dice) {
            total += num;
        }
        return total;
    }

    public static int getYatzyScore(List<Integer> dice) {
        int distinctDiceCount = Math.toIntExact(dice.stream().distinct().count());
        if (distinctDiceCount == 1) {
            return 50;
        }
        return 0;
    }

    public static int getOnesScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(1, 0);
    }

    public static int getTwosScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(2, 0) * 2;
    }

    public static int getThreesScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(3, 0) * 3;
    }

    public static int getFoursScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(4, 0) * 4;
    }

    public static int getFivesScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(5, 0) * 5;
    }

    public static int getSixesScore(List<Integer> dice) {
        return createfrequencyMap(dice).getOrDefault(6, 0) * 6;
    }

    public static int getOnePairScore(List<Integer> dice) {
        return getOfAKindScore(dice, 2);
    }

    public static int getTwoPairsScore(List<Integer> dice) {
        Map<Integer, Integer> frequencyMap = createfrequencyMap(dice);
        boolean foundFirstPair = false;
        int score = 0;
        for (int i : DICE_VALUES) {
            if (frequencyMap.containsKey(i) && frequencyMap.get(i) >= 2) {
                score += 2 * i;
                if (foundFirstPair) {
                    return score;
                } else {
                    foundFirstPair = true;
                }
            }
        }
        return 0;
    }

    public static int getThreeOfAKindScore(List<Integer> dice) {
        return getOfAKindScore(dice, 3);
    }

    public static int getFourOfAKindScore(List<Integer> dice) {
        return getOfAKindScore(dice, 4);
    }

    public static int getSmallStraightScore(List<Integer> dice) {
        final int smallStraightScore = 15;
        Map<Integer, Integer> frequencyMap = createfrequencyMap(dice);

        if (!frequencyMap.containsKey(6)) {
            for (int i = 1; i <= 5; i++) {
                if (frequencyMap.get(i) != 1) {
                    return 0;
                }
            }
            return smallStraightScore;
        }
        return 0;
    }

    public static int getLargeStraightScore(List<Integer> dice) {
        final int largeStraightScore = 20;
        Map<Integer, Integer> frequencyMap = createfrequencyMap(dice);

        if (!frequencyMap.containsKey(1)) {
            for (int i = 2; i <= 6; i++) {
                if (frequencyMap.get(i) != 1) {
                    return 0;
                }
            }
            return largeStraightScore;
        }
        return 0;
    }

    public static int getFullHouseScore(List<Integer> dice) {
        Map<Integer, Integer> frequencyMap = createfrequencyMap(dice);
        //find triplet
        Map.Entry<Integer, Integer> tripletEntry = frequencyMap.entrySet().stream().filter(e -> e.getValue().equals(3)).findFirst().orElse(null);
        if (tripletEntry == null) {
            return 0;
        }

        Map.Entry<Integer, Integer> pairEntry = frequencyMap.entrySet().stream().filter(e -> !e.getKey().equals(tripletEntry.getKey()) && e.getValue().equals(2)).findFirst().orElse(null);
        if (pairEntry == null) {
            return 0;
        }

        return tripletEntry.getKey() * tripletEntry.getValue() + pairEntry.getKey() * pairEntry.getValue();
    }

    private static int getOfAKindScore(List<Integer> dice, int amountOfSameDice) {
        Map<Integer, Integer> frequencyMap = createfrequencyMap(dice);
        for (int i : DICE_VALUES) {
            if (frequencyMap.containsKey(i) && frequencyMap.get(i) >= amountOfSameDice) {
                return i * amountOfSameDice;
            }
        }
        return 0;
    }

    private static Map<Integer, Integer> createfrequencyMap(List<Integer> dice) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : dice) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }
}