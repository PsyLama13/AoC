package challenges.year2018.day03;

import helper.Coordinate;

import java.util.*;

public class FabricManager {


    private final Set<Claim> claims = new HashSet<>();
    private final Map<Coordinate, Integer> coordinateToClaimAmount = new HashMap<>();

    public FabricManager(List<String> input) {
        for (String s : input) {
            Claim claim = Claim.parseClaim(s);
            claims.add(claim);

            for (Coordinate c : claim.getCoordinateSet()) {
                coordinateToClaimAmount.merge(c, 1, Integer::sum);
            }
        }
    }

    public long calculateOverlap() {
        return coordinateToClaimAmount.values().stream().filter(v -> v > 1).count();
    }

    public int getSoloId() {
        for (Claim claim : claims) {
            if (claim.isNonOverlapping(coordinateToClaimAmount)) {
                return claim.id();
            }
        }

        throw new IllegalStateException("no non overlapping claim found!");
    }
}
