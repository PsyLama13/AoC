package y2024.d4;

import helper.Coordinate;

import java.util.*;

public class WordGrid {
    Map<Coordinate, String> wordMap = new HashMap<>();
    int maxY;
    int maxX;

    public WordGrid(List<String> input) {
        maxY = input.size();
        maxX = input.get(0).length();
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                String letter = input.get(y).split("")[x];
                wordMap.put(coordinate, letter);
            }
        }
    }

    public void printMap() {
        for (int y = 0; y < maxY; y++) {
            StringBuilder s = new StringBuilder();
            for (int x = 0; x < maxX; x++) {
                s.append(wordMap.get(new Coordinate(x, y)));
            }
            System.out.println(s);
        }
    }

    List<Coordinate> findAllLetters(String letter) {
        return wordMap.entrySet().stream().filter(i -> i.getValue().equals(letter)).map(Map.Entry::getKey).toList();
    }

    List<Coordinate> findAllMtoX(Coordinate x) {
        List<Coordinate> neighbours = x.getAllNeightboursWithDiagonals();
        List<Coordinate> output = new ArrayList<>();
        for (Coordinate c : neighbours) {
            if (wordMap.containsKey(c) && wordMap.get(c).equals("M")) {
                output.add(c);
            }
        }
        return output;
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
        List<Coordinate> alllA = findAllLetters("A");

        for(Coordinate a : alllA){
            CrossSolver crossSolver = new CrossSolver(a);
            if(crossSolver.isValid(wordMap)){
                counter++;
            }
        }
        return counter;
    }
}
