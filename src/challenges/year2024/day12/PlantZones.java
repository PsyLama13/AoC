package challenges.year2024.day12;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class PlantZones {
    private final List<Zone> zones;
    String key;

    public PlantZones(String key, List<Coordinate> coordinates) {
        this.key = key;
        zones = computeZones(coordinates);
    }

    public List<Zone> getZones() {
        return zones;
    }

    private List<Zone> computeZones(List<Coordinate> coordinates) {
        List<Zone> output = new ArrayList<>();
        List<Coordinate> remainingCoordinates = new ArrayList<>(coordinates);
        while (!remainingCoordinates.isEmpty()) {
            Coordinate startingPoint = remainingCoordinates.get(0);
            Zone zone = new Zone(key, startingPoint, remainingCoordinates);
            output.add(zone);
            remainingCoordinates.removeAll(zone.getCoordinates());
        }
        return output;
    }

}
