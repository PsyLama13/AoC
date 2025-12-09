package challenges.year2025.day07;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TachionBeams {
    private long maxX;
    private long maxY;
    private Set<Long> rays = new HashSet<>();
    private Integer splitCount = 0;

    public TachionBeams(Coordinate start, long maxX, long maxY) {
        rays.add(start.x());
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean contains(Long xVal) {
        return rays.contains(xVal);
    }

    public void handleRaySplit(Long xVal) {
        rays.remove(xVal);
        List<Long> newRays = new ArrayList<>(List.of(xVal - 1, xVal + 1));
        newRays.removeIf(v -> v < 0 || v > maxX);
        rays.addAll(newRays);
        if (!newRays.isEmpty()) {
            splitCount++;
        }
    }

    public long getSplitCount() {
        return splitCount;
    }

    public long getTimelineCount(Splitters splitters) {
        RayMap rayMap = new RayMap(rays, maxX);

        for (int y = 1; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (splitters.containsSplitter(y, x)) {
                    rayMap.handleSplitting(x);
                }
            }
            //rayMap.printCurrent();
        }
        return rayMap.getSumOfRays();
    }
}