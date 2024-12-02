package y2021.d5;

import helper.Coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OceanVentMap {

    private final Map<Coordinate, Integer> map = new HashMap<>();
    private int maxY;
    private int maxX;

    public OceanVentMap(List<String> input) {
        for (String s : input) {
            Cloud c = new Cloud(s);
            adjustMaxValues(c);
            List<Coordinate> coordinates = c.getCloudLine();
            for(Coordinate coordinate : coordinates){
                pushCoordinateToMap(coordinate);
            }
        }
    }

    private void pushCoordinateToMap(Coordinate coordinate) {
        if(!map.containsKey(coordinate)){
            map.put(coordinate, 1);
        }else {
            int value = map.get(coordinate);
            map.put(coordinate, value+1);
        }
    }

    private void adjustMaxValues(Cloud c) {
        if (c.startPoint.x() > maxX) {
            maxX = c.startPoint.x();
        }

        if (c.startPoint.y() > maxY) {
            maxY = c.startPoint.y();
        }

        if (c.endPoint.x() > maxX) {
            maxX = c.endPoint.x();
        }

        if (c.endPoint.y() > maxY) {
            maxY = c.endPoint.y();
        }
    }

    public void drawMap(){
        StringBuilder output = new StringBuilder();
        for(int y = 0; y <= maxY; y++){
            for(int x = 0; x <= maxX; x++){
                Coordinate c = new Coordinate(x,y);
                if(map.containsKey(c)){
                    output.append(map.get(c));
                }else{
                    output.append(".");
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    public int getScore(){
        return Math.toIntExact(map.entrySet().stream().filter(s -> s.getValue() > 1).count());
    }
}
