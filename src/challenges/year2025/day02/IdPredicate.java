package challenges.year2025.day02;

import java.util.OptionalInt;
import java.util.function.LongPredicate;

public class IdPredicate implements LongPredicate {

    public IdPredicate() {
        this.repeater = OptionalInt.empty();
    }

    public IdPredicate(Integer repeater) {
        this.repeater = OptionalInt.of(repeater);
    }

    private final OptionalInt repeater;

    @Override
    public boolean test(long currentNumber) {
        if (repeater.isPresent()) {
            return isRepeatableForLength(currentNumber, repeater.getAsInt());
        } else {
            String s = Long.toString(currentNumber);
            for (int patternLength = 1; patternLength <= s.length() / 2; patternLength++) {
                if (isRepeatableForLength(currentNumber, patternLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRepeatableForLength(Long currentNumber, int length) {
        String numberString = currentNumber.toString();
        int wordLength = numberString.length();
        if (wordLength % length == 0) {
            String part = numberString.substring(0, length);
            int repeatCount = wordLength / length;
            String testee = part.repeat(repeatCount);
            return testee.equals(numberString);
        }
        return false;
    }
}
