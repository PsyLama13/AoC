package y2021.d2;

import java.util.List;

public class Ship {

    private int horizontal;
    private int depth;
    private int aim;

    public Ship() {
        horizontal = 0;
        depth = 0;
        aim = 0;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getDepth() {
        return depth;
    }

    private void forward(int x) {
        horizontal += x;
    }

    private void down(int x) {
        depth += x;
    }

    private void up(int x) {
        depth -= x;
    }

    public void navigate(String s) {

        List<String> l = List.of(s.split(" "));
        int x = Integer.parseInt(l.get(1));
        switch (l.get(0)) {
            case "forward" -> forward(x);
            case "up" -> up(x);
            case "down" -> down(x);
            default -> throw new IllegalStateException("Unexpected value: " + l.get(0));
        }
    }

    public void navigateWithAim(String s) {
        List<String> l = List.of(s.split(" "));
        int x = Integer.parseInt(l.get(1));
        switch (l.get(0)) {
            case "forward" -> aimForward(x);
            case "up" -> aimUp(x);
            case "down" -> aimDown(x);
            default -> throw new IllegalStateException("Unexpected value: " + l.get(0));
        }
    }

    private void aimDown(int x) {
        aim += x;
    }

    private void aimUp(int x) {
        aim -= x;
    }

    private void aimForward(int x) {
        horizontal += x;
        depth += x * aim;
    }
}
