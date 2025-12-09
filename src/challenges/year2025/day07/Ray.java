package challenges.year2025.day07;

import java.util.*;

public record Ray(Long coordinate, UUID id) {

    public Ray(long value) {
        this(value, UUID.randomUUID());
    }

    public static Set<Ray> listFromLongList(Set<Long> set) {
        Set<Ray> list = new HashSet<>();
        for (Long val : set) {
            list.add(new Ray(val));
        }
        return list;
    }
}
