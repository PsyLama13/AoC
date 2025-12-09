package challenges.year2025.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RayMap {
    private final Map<Long, Long> rayMap = new HashMap<>();

    public RayMap(Set<Long> rays, long maxX) {
        for (int x = 0; x < maxX; x++) {
            rayMap.put((long) x, 0L);
        }

        for (Long val : rays) {
            this.addRay(val, 1);
        }
    }

    public long getSumOfRays() {
        return rayMap.values().stream().mapToLong(i -> i).sum();
    }

    private void addRay(Long key, long valueToAdd) {
        Long currentValue = rayMap.get(key);
        if (currentValue == null) {
            return;
        }

        rayMap.put(key, currentValue + valueToAdd);
    }

    private void removeRay(Long key, Long value) {
        long count = Math.max(0, rayMap.get(key) - value);
        rayMap.put(key, count);
    }

    public void handleSplitting(long key) {
        long val = rayMap.get(key);
        removeRay(key, val);
        // bounding handling is in addRay, if it is outside of array, it will not be pushed
        addRay(key - 1, val);
        addRay(key + 1, val);
    }
}