package challenges.year2025.day08;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class BoxCluster implements Comparable<BoxCluster> {
    private final Set<JunctionBox> boxes = new HashSet<>();

    public BoxCluster(Set<JunctionBox> boxes) {
        this.boxes.addAll(boxes);
    }

    public void merge(BoxCluster other) {
        this.boxes.addAll(other.boxes);
    }

    public boolean contains(JunctionBox a) {
        return boxes.contains(a);
    }

    @Override
    public int compareTo(BoxCluster o) {
        return Integer.compare(this.boxes.size(), o.boxes.size());
    }

    public Set<JunctionBox> boxes() {
        return boxes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BoxCluster) obj;
        return Objects.equals(this.boxes, that.boxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxes);
    }

    @Override
    public String toString() {
        return "BoxCluster[" +
                "boxes=" + boxes + ']';
    }

}
