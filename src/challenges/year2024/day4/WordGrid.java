package challenges.year2024.day4;

import helper.Coordinate;

import java.util.*;

public class WordGrid {
    private final Map<Coordinate, String> wordMap = new HashMap<>();

    public WordGrid(List<String> input) {
        int maxY = input.size();
        int maxX = input.get(0).length();
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                String letter = input.get(y).split("")[x];
                wordMap.put(coordinate, letter);
            }
        }
    }

    List<Coordinate> findAllLetters(String letter) {
        return wordMap.entrySet().stream().filter(i -> i.getValue().equals(letter)).map(Map.Entry::getKey).toList();
    }

    public int findAllXMAS() {
        int counter = 0;
        List<Coordinate> allX = findAllLetters("X");
        List<Coordinate> allM = findAllLetters("M");

        for (Coordinate x : allX) {
            XmasTuple xmasTuple = new XmasTuple(x);
            List<XmasTuple> successors = xmasTuple.copyWithMs(allM);
            for (XmasTuple successor : successors) {
                if (successor.isValid(wordMap)) {
                    counter++;
                }

            }
        }
        return counter;
    }

    public int findAllCrossMAS() {
        int counter = 0;
        List<Coordinate> allA = findAllLetters("A");

        for (Coordinate a : allA) {
            CrossSolver crossSolver = new CrossSolver(a);
            if (crossSolver.isValid(wordMap)) {
                counter++;
            }
        }
        return counter;
    }
}
