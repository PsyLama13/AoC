package y2024.d6;

import helper.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Grid {
    private final int maxX;
    private final int maxY;
    private Map<Coordinate, TileType> map = new HashMap<>();

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Grid(int maxX, int maxY, Map<Coordinate, TileType> map) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = new HashMap<>(map);
    }

    public void addField(int x, int y, TileType tileType) {
        addField(new Coordinate(x, y), tileType);
    }

    public void addField(Coordinate coordinate, TileType tileType) {
        map.put(coordinate, tileType);
    }

    public TileType get(Coordinate coordinate) {
        return map.get(coordinate);
    }

    public int calculateObstructionPoints(Guard guard) {
        int counter = 0;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                TileType tile = map.get(coordinate);
                if (tile.equals(TileType.OPEN)) {
                    Grid tempGrid = new Grid(maxX, maxY, map);
                    tempGrid.addField(coordinate, TileType.BLOCKED);
                    boolean isCyclic = guard.runAndReturnIfCycle(tempGrid);
                    if (isCyclic) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
