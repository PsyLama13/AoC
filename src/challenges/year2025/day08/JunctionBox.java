package challenges.year2025.day08;

public record JunctionBox(Integer x, Integer y, Integer z) {

    public double getDistanceTo(JunctionBox box2) {
        return Math.sqrt(Math.pow((double) x - box2.x(), 2) + Math.pow((double) y - box2.y(), 2) + Math.pow((double) z - box2.z, 2));
    }
}
