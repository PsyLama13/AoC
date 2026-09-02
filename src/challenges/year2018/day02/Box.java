package challenges.year2018.day02;

import java.util.stream.Collectors;

public record Box(String id) {

    public static boolean hasProtoFabric(Box boxA, Box boxB) {
        if (boxA.id.length() != boxB.id.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < boxA.id.length(); i++) {
            char charA = boxA.id.charAt(i);
            char charB = boxB.id.charAt(i);
            if (charA != charB) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public static String generateProtoName(Box boxA, Box boxB) {
        if (!hasProtoFabric(boxA, boxB)) {
            throw new IllegalStateException(boxA.id + " and " + boxB.id + " are no proto boxes!");
        }

        String output = "";

        for (int i = 0; i < boxA.id.length(); i++) {
            if (boxA.id.charAt(i) == boxB.id.charAt(i)) {
                output += boxA.id.charAt(i);
            }
        }
        return output;
    }

    public boolean hasDoubles() {
        return hasLettersOccurringTimes(2);
    }

    public boolean hasTriples() {
        return hasLettersOccurringTimes(3);
    }

    private boolean hasLettersOccurringTimes(long times) {
        return id.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting())).containsValue(times);
    }
}
