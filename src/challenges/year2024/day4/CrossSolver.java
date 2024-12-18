package challenges.year2024.day4;

import helper.Coordinate;

import java.util.Map;

public class CrossSolver {
    Coordinate a;

    public CrossSolver(Coordinate a) {
        this.a = a;
    }

    public boolean isValid(Map<Coordinate, String> wordMap) {
        //m top
        boolean top = checkDirection(DirectionType.TOP, wordMap);
        //m bot
        boolean bot = checkDirection(DirectionType.BOT, wordMap);
        //m left
        boolean left = checkDirection(DirectionType.LEFT, wordMap);
        //m right
        boolean right = checkDirection(DirectionType.RIGHT, wordMap);

        return top || bot || left || right;
    }

    private boolean checkDirection(DirectionType directionType, Map<Coordinate, String> wordMap) {
        Coordinate m1;
        Coordinate m2;
        Coordinate s1;
        Coordinate s2;
        switch (directionType) {
            case TOP -> {
                m1 = a.upLeft();
                m2 = a.upRight();
                s1 = a.downRight();
                s2 = a.downLeft();
            }
            case BOT -> {
                m1 = a.downLeft();
                m2 = a.downRight();
                s1 = a.upRight();
                s2 = a.upLeft();
            }
            case LEFT -> {
                m1 = a.upLeft();
                m2 = a.downLeft();
                s1 = a.downRight();
                s2 = a.upRight();
            }
            case RIGHT -> {
                m1 = a.upRight();
                m2 = a.downRight();
                s1 = a.downLeft();
                s2 = a.upLeft();
            }
            default -> throw new IllegalStateException("Unexpected value: " + directionType);
        }
        String sm1 = wordMap.get(m1);
        String sm2 = wordMap.get(m2);
        String ss1 = wordMap.get(s1);
        String ss2 = wordMap.get(s2);

        if (sm1 == null || sm2 == null || ss1 == null || ss2 == null) {
            return false;
        }

        return sm1.equals("M") && sm2.equals("M") && ss1.equals("S") && ss2.equals("S");
    }
}