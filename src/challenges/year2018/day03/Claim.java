package challenges.year2018.day03;

import helper.Coordinate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public record Claim(int id, Coordinate startCoordinate, int width, int height) {
    public static Claim parseClaim(String s) {
        String[] splitInput = s.split(" ");

        int id = Integer.parseInt(splitInput[0].substring(1));
        int x = Integer.parseInt(splitInput[2].split(",")[0]);
        int y = Integer.parseInt(splitInput[2].split(",")[1].split(":")[0]);
        Coordinate coordinate = new Coordinate(x, y);
        int width = Integer.parseInt(splitInput[3].split("x")[0]);
        int height = Integer.parseInt(splitInput[3].split("x")[1]);

        return new Claim(id, coordinate, width, height);
    }

    public Set<Coordinate> getCoordinateSet() {
        Set<Coordinate> output = new HashSet<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinate c = new Coordinate(startCoordinate.x() + x, startCoordinate.y() + y);
                output.add(c);
            }
        }
        return output;
    }

    public boolean isNonOverlapping(Map<Coordinate, Integer> coordinateToClaimAmount) {
        for (Coordinate c : this.getCoordinateSet()) {
            if (coordinateToClaimAmount.get(c) > 1) {
                return false;
            }
        }
        return true;
    }
}
