package challenges.year2024.day13;

import helper.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ClawMachine {
    private Coordinate priceLocation;
    private Coordinate buttonAOffset;
    private Coordinate buttonBOffset;
    private int costA = 3;
    private int costB = 1;
    private Long priceSpendings;


    public ClawMachine(List<String> clawString) {
        buttonAOffset = parseButton(clawString.get(0));
        buttonBOffset = parseButton(clawString.get(1));
        priceLocation = parseButton(clawString.get(2));
    }

    public Coordinate getPriceLocation() {
        return priceLocation;
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
            if (current.coordinate().equals(priceLocation)) {
                this.priceSpendings = (long) current.cost();
                return;
            }

            CoordinateCost nextA = new CoordinateCost(current.coordinate().plus(buttonAOffset), current.cost() + costA);
            if (!visited.contains(nextA.coordinate()) && nextA.coordinate().x() <= priceLocation.x() && nextA.coordinate().y() <= priceLocation.y()) {
                pq.add(nextA);
            }

            CoordinateCost nextB = new CoordinateCost(current.coordinate().plus(buttonBOffset), current.cost() + costB);
            if (!visited.contains(nextB.coordinate()) && nextB.coordinate().x() <= priceLocation.x() && nextB.coordinate().y() <= priceLocation.y()) {
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

    public Long getPriceSpendings() {
        return priceSpendings;
    }

    public void trySolveExtendedMachine() {
        long extender = 10000000000000L;
        long priceX = priceLocation.x() + extender;
        long priceY = priceLocation.y() + extender;
        long ax = buttonAOffset.x();
        long ay = buttonAOffset.y();
        long bx = buttonBOffset.x();
        long by = buttonBOffset.y();

        long gcdX = lcm(lcm(ax, bx), priceX);
        long gcdY = lcm(lcm(ay, by), priceY);
        long finalGcd = lcm(gcdX, gcdY);
        long multiplier = priceLocation.x() / finalGcd;
        priceLocation = new Coordinate(priceLocation.x() / finalGcd, priceLocation.y() / finalGcd);

        trySolveMachine();
        if (priceSpendings != null) {
            priceSpendings *= multiplier;
        }

    }

    private long lcm(long number1, long number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        long absNumber1 = Math.abs(number1);
        long absNumber2 = Math.abs(number2);
        long absHigherNumber = Math.max(absNumber1, absNumber2);
        long absLowerNumber = Math.min(absNumber1, absNumber2);
        long lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
