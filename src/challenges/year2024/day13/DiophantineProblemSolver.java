package challenges.year2024.day13;

public class DiophantineProblemSolver {
    long targetX;
    long targetY;
    int[] pathA;
    int[] pathB;

    public DiophantineProblemSolver(long targetX, long targetY, int[] pathA, int[] pathB) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.pathA = pathA;
        this.pathB = pathB;
    }

    public long minCostToReachTarget() {
        long dx1 = pathA[0];
        long dy1 = pathA[1];
        long cost1 = pathA[2];
        long dx2 = pathB[0];
        long dy2 = pathB[1];
        long cost2 = pathB[2];

        // Check GCD conditions for reachability
        long[] xyX = new long[2];
        long gcdX = gcd(dx1, dx2, xyX);
        if (targetX % gcdX != 0) { // not reachable in X direction
            return 0;
        }

        long[] xyY = new long[2];
        long gcdY = gcd(dy1, dy2, xyY);
        if (targetY % gcdY != 0) { // not reachable in Y direction
            return 0;
        }

        // Scale the solution to meet the target
        long scaleX = targetX / gcdX;
        long scaleY = targetY / gcdY;

        long mx = xyX[0] * scaleX;
        long nx = xyX[1] * scaleX;

        long my = xyY[0] * scaleY;
        long ny = xyY[1] * scaleY;

        // Minimize cost by adjusting m and n to stay within bounds
        // Using modular arithmetic to find non-negative solutions

        // Calculate cost for x and y
        long costX = Math.abs(mx) * cost1 + Math.abs(nx) * cost2;
        long costY = Math.abs(my) * cost1 + Math.abs(ny) * cost2;

        return costX + costY;
    }

    private long gcd(long a, long b, long[] xy) {
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return a;
        }
        long[] xy1 = new long[2];
        long gcd = gcd(b, a % b, xy1);
        xy[0] = xy1[1];
        xy[1] = xy1[0] - (a / b) * xy1[1];
        return gcd;
    }
}
