package challenges.year2018.day05;

import java.util.Comparator;
import java.util.stream.IntStream;

public class PolymerSimulator {
    final String POLYMER;

    public PolymerSimulator(String polymer) {
        this.POLYMER = polymer;
    }

    public String getSimulatedPolymer() {
        return react(POLYMER);
    }

    /**
     * Removes all units of one type (both polarities) before reacting,
     * tries this for every type and returns the shortest resulting polymer.
     */
    public String getShortestImprovedPolymer() {
        return IntStream.rangeClosed('a', 'z')
                .mapToObj(type -> react(removeType(POLYMER, (char) type)))
                .min(Comparator.comparingInt(String::length))
                .orElseThrow();
    }

    private static String removeType(String polymer, char type) {
        return polymer.replaceAll("(?i)" + type, "");
    }

    private static String react(String polymer) {
        StringBuilder output = new StringBuilder(polymer);
        for (int i = 0; i < output.length() - 1; i++) {
            String firstChar = String.valueOf(output.charAt(i));
            String secondChar = String.valueOf(output.charAt(i + 1));
            if (firstChar.equalsIgnoreCase(secondChar) && !firstChar.equals(secondChar)) {
                output.delete(i, i + 2); // remove both
                // the units left and right of the removed pair are now neighbours and may react,
                // so step back one position (the loop's i++ then lands on i - 1)
                i = Math.max(i - 2, -1);
            }
        }
        return output.toString();
    }
}
