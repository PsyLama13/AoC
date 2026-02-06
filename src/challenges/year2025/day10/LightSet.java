package challenges.year2025.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record LightSet(List<Boolean> lights) {

    public LightSet(int size) {
        this(new ArrayList<>(Collections.nCopies(size, false)));
    }

    public LightSet handleButtonPress(Button button) {
        LightSet temp = new LightSet(new ArrayList<>(this.lights));
        for (int i : button.lightSwitches()) {
            temp.lights.set(i, !temp.lights.get(i));
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Boolean light : lights) {
            if (light) {
                s.append("#");
            } else {
                s.append(".");
            }
        }
        return s.toString();
    }
}
