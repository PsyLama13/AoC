package challenges.year2024.day12;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GardenHelper {

    Map<String, List<Coordinate>> map = new HashMap<>();
    List<PlantZones> plantZonesList = new ArrayList<>();

    public GardenHelper(List<String> input) {
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(0).length(); x++) {
                Coordinate c = new Coordinate(x, y);
                String s = input.get(y).split("")[x];
                map.computeIfAbsent(s, k -> new ArrayList<>()).add(c);
            }
        }
        initPlantZonesList();
    }

    public long calc1() {
        long counter = 0;
        for (PlantZones plantZones : plantZonesList) {
            for (Zone zone : plantZones.getZones()) {
                counter += zone.getFencingPricePart1();
            }
        }
        return counter;
    }

    public long calc2() {
        long counter = 0;
        for(PlantZones plantZones : plantZonesList){
            for(Zone zone : plantZones.getZones()){
                counter += zone.getFencingPricePart2();
            }
        }
        return counter;
    }

    private void initPlantZonesList() {
        for (Map.Entry<String, List<Coordinate>> entry : map.entrySet()) {
            PlantZones plantZones = new PlantZones(entry.getKey(), entry.getValue());
            plantZonesList.add(plantZones);
        }
    }
}
