package challenges.year2024.day19;

import java.util.*;

public class TowelHelper {
    private final List<String> towelPatterns;
    private final Map<Character, List<String>> towels = new HashMap<>();
    private final List<Towel> towelList = new ArrayList<>();

    Map<String, Set<String>> cache = new HashMap<>();
    Map<String, Long> cache2 = new HashMap<>();

    public TowelHelper(List<String> input) {
        towelPatterns = parseTowelPatterns(input.get(0));
        for (String towel : input.get(0).split(", ")) {
            if (!towels.containsKey(towel.charAt(0))) {
                towels.put(towel.charAt(0), new ArrayList<>());
            }
            towels.get(towel.charAt(0)).add(towel);
        }

        for (int i = 2; i < input.size(); i++) {
            towelList.add(new Towel(input.get(i)));
        }
    }

    public int calc1() {
        int counter = 0;
        for (Towel towel : towelList) {
            if (towel.isSolvable(towelPatterns, cache)) {
                counter++;
            }
        }
        return counter;
    }

    public long calc2() {
        long counter = 0;
        for (Towel towel : towelList) {
            counter += towel.getCombinationList(towels, cache2);
        }
        return counter;
    }

    private List<String> parseTowelPatterns(String s) {
        return List.of(s.split(", "));
    }
}