package challenges.year2024.day13;

import helper.Coordinate;

import java.util.List;

public class ClawMachine {
    private Coordinate priceLocation;
    private final Coordinate buttonAOffset;
    private final Coordinate buttonBOffset;
    private Long priceSpending;

    public ClawMachine(List<String> clawString) {
        buttonAOffset = parseButton(clawString.get(0));
        buttonBOffset = parseButton(clawString.get(1));
        priceLocation = parseButton(clawString.get(2));
    }

    public void trySolveMachine() {

        double epsilon = 0.000001;
        double a1 = buttonAOffset.x();
        double a2 = buttonAOffset.y();
        double b1 = buttonBOffset.x();
        double b2 = buttonBOffset.y();
        double c1 = priceLocation.x();
        double c2 = priceLocation.y();

        double d = a1 * b2 - a2 * b1;
        double dx = c1 * b2 - c2 * b1;
        double dy = a1 * c2 - a2 * c1;

        double a = dx / d;
        double b = dy / d;

        long intA = Math.round(a);
        long intB = Math.round(b);

        if (Math.abs(a - intA) < epsilon && Math.abs(b - intB) < epsilon) {
            int costA = 3;
            int costB = 1;
            priceSpending = intA * costA + intB * costB;
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
        return priceSpending != null;
    }

    public Long getPriceSpending() {
        return priceSpending;
    }


    public void trySolveExtendedMachine() {
        priceLocation = new Coordinate(priceLocation.x() + 10000000000000L, priceLocation.y() + 10000000000000L);
        trySolveMachine();
    }
}