package challenges.year2025.day02;

import java.util.stream.LongStream;

public record NumberRange(Long start, Long end) {
    public static NumberRange fromString(String sequence) {
        String[] arr = sequence.split("-");
        Long first = Long.parseLong(arr[0]);
        Long last = Long.parseLong(arr[1]);

        return new NumberRange(first, last);
    }

    public long addUpInvalidIds(IdPredicate predicate){
        return LongStream.range(start, end).filter(predicate).sum();
    }
}