package y2024.d6;

import helper.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final int maxX;
    private final int maxY;
    private Map<Coordinate, TyleType> map = new HashMap<>();

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Grid(int maxX, int maxY, Map<Coordinate, TyleType> map) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = new HashMap<>(map);
    }

    public void addField(int x, int y, TyleType tyleType) {
        addField(new Coordinate(x, y), tyleType);
    }

    public void addField(Coordinate coordinate, TyleType tyleType) {
        map.put(coordinate, tyleType);
    }

    public void print() {
        for (int y = 0; y < maxY; y++) {
            StringBuilder s = new StringBuilder();
            for (int x = 0; x < maxX; x++) {
                s.append(map.get(new Coordinate(x, y)).toString());
            }
            System.out.println(s);
        }
    }

    public TyleType get(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public int calculateObstructionPoints(Guard guard) {
        int counter = 0;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                TyleType tile = map.get(coordinate);
                if (tile.equals(TyleType.OPEN)) {
                    Grid tempGrid = new Grid(maxX, maxY, map);
                    tempGrid.addField(coordinate, TyleType.BLOCKED);
                    boolean isCylce = guard.runAndReturnIfCycle(tempGrid);
                    if(isCylce){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
