package challenges.year2024.day22;

public class SecretHelper {

    private SecretHelper() {
        throw new IllegalStateException("Utility Class");
    }

    public static long encode(long number) {
        long stepOne = number * 64;
        number = mix(number, stepOne);
        number = prune(number);
        long stepTwo = number / 32;
        number = mix(number, stepTwo);
        number = prune(number);
        long stepThree = number * 2048;
        number = mix(number, stepThree);
        number = prune(number);
        return number;
    }

    private static long prune(long number) {
        return number % 16777216;
    }

    private static long mix(long number, long next) {
        return next ^ number;
    }
}
