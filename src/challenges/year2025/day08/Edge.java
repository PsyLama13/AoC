package challenges.year2025.day08;

public record Edge(JunctionBox a, JunctionBox b, double distance) implements Comparable<Edge> {
    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.distance, o.distance);
    }

    public long multiplyXValues() {
        return (long) a.x() * b.x();
    }
}