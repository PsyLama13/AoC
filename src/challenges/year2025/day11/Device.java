package challenges.year2025.day11;

import java.util.List;

public record Device(String name, List<String> connections) {

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Device o) {
            return this.name.equals(o.name);
        }
        return false;
    }
}
