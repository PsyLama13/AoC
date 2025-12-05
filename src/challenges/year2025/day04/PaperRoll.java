package challenges.year2025.day04;

import helper.Coordinate;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PaperRoll {
    private final Coordinate coordinate;

    public static boolean isPaperRoll(char c) {
        return c == '@';
    }

    public PaperRoll(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaperRoll paperRoll)) return false;
        return Objects.equals(coordinate, paperRoll.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate);
    }

    public boolean isAccessible(Set<PaperRoll> paperRollLocations) {
        List<PaperRoll> neighbours = this.getNeighbours();
        long numberOfNeighbouringPaperRolls = neighbours.stream().filter(paperRollLocations::contains).count();
        return numberOfNeighbouringPaperRolls < 4;
    }

    private List<PaperRoll> getNeighbours() {
        List<Coordinate> list = this.coordinate.getEightNeighbours();
        return list.stream().map(PaperRoll::new).toList();
    }
}