package challenges.year2020.d3;

import helper.Coordinate;

import java.util.*;

public class WorldMap {
    Map<Coordinate, Geology> world = new HashMap<>();
    int maxX;
    int maxY;


    public WorldMap(List<String> inputList) {
        generateWorld(inputList);
        maxX = inputList.get(0).length();
        maxY = inputList.size();
    }

    private void generateWorld(List<String> inputList) {
        int y = 0;
        for(String string : inputList){
            int x = 0;
            for(String s : string.split("")){
                switch (s){
                    case "." -> world.put(new Coordinate(x, y), Geology.OPEN);
                    case "#" -> world.put(new Coordinate(x,y), Geology.TREE);
                    default -> throw new IllegalStateException("Unexpected value: " + s);
                }
                x++;
            }
            y++;
        }
    }

    public Geology getGeologyAtPosition(int x, int y){
        int tempX = x % maxX;
        int tempY = y % maxY;

        return world.get(new Coordinate(tempX, tempY));
    }
}
