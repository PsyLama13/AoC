package challenges.year2024.day13;

import helper.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ClawMachine {
    private Coordinate prizeLocation;
    private Coordinate buttonAOffset;
    private Coordinate buttonBOffset;
    private int costA = 3;
    private int costB = 1;
    private Integer priceSpendings;


    public ClawMachine(List<String> clawString) {
        buttonAOffset = parseButton(clawString.get(0));
        buttonBOffset = parseButton(clawString.get(1));
        prizeLocation = parseButton(clawString.get(2));
    }

    public Coordinate getPrizeLocation() {
        return prizeLocation;
    }

    public Coordinate getButtonAOffset() {
        return buttonAOffset;
    }

    public Coordinate getButtonBOffset() {
        return buttonBOffset;
    }

    public void trySolveMachine() {

        PriorityQueue<CoordinateCost> pq = new PriorityQueue<>();
        HashSet<Coordinate> visited = new HashSet<>();

        pq.add(new CoordinateCost(new Coordinate(0, 0), 0));

        while (!pq.isEmpty()) {
            CoordinateCost current = pq.poll();

            if (visited.contains(current.coordinate())) {
                continue;
            }

            visited.add(current.coordinate());
            if (current.coordinate().equals(prizeLocation)) {
                this.priceSpendings = current.cost();
                return;
            }

            CoordinateCost nextA = new CoordinateCost(current.coordinate().plus(buttonAOffset), current.cost() + costA);
            if (!visited.contains(nextA.coordinate()) && nextA.coordinate().x() <= prizeLocation.x() && nextA.coordinate().y() <= prizeLocation.y()) {
                pq.add(nextA);
            }

            CoordinateCost nextB = new CoordinateCost(current.coordinate().plus(buttonBOffset), current.cost() + costB);
            if (!visited.contains(nextB.coordinate()) && nextB.coordinate().x() <= prizeLocation.x() && nextB.coordinate().y() <= prizeLocation.y()) {
                pq.add(nextB);
            }
        }
    }

    private Coordinate parseButton(String s) {
        String[] a = s.split(": ");
        String[] b = a[1].split(", ");
        int x = Integer.parseInt(b[0].substring(2));
        int y = Integer.parseInt(b[1].substring(2));
        return new Coordinate(x, y);
    }

    public boolean isSolvable() {
        return priceSpendings != null;
    }

    public Integer getPriceSpendings() {
        return priceSpendings;
    }

    public void trySolveExtendedMachine() {
        long extender = 10000000000000L;
        long priceX = prizeLocation.x() + extender;
        long priceY = prizeLocation.y() + extender;



    }
}
