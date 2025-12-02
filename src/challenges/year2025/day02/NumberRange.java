package challenges.year2025.day02;

public record NumberRange(Long start, Long end) {
    public static NumberRange fromString(String sequence) {
        String[] arr = sequence.split("-");
        Long first = Long.parseLong(arr[0]);
        Long last = Long.parseLong(arr[1]);

        return new NumberRange(first, last);
    }

    public long addUpInvalidIds(Integer amountOfRepPatterns) {
        long totalSum = 0L;

        for (Long currentNumber = start; currentNumber <= end; currentNumber++) {
            if (isRepeating(currentNumber, amountOfRepPatterns)) {
                totalSum += currentNumber;
            }
        }

        return totalSum;
    }

    private boolean isRepeating(Long currentNumber, Integer amountOfRepPatterns) {
        String numberString = currentNumber.toString();
        int wordLength = numberString.length();

        if (amountOfRepPatterns == null) {
            for (int patternLength = 1; patternLength <= wordLength / 2; patternLength++) {
                if (isRepeatableForLength(currentNumber, patternLength)) {
                    return true;
                }
            }
        } else {
            return isRepeatableForLength(currentNumber, amountOfRepPatterns);
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