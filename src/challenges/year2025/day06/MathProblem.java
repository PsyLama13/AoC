package challenges.year2025.day06;

import java.util.List;

public record MathProblem(List<Integer> numbers, Operator operator) {
    public Long solve(){
        return switch (operator){
            case PLUS -> numbers.stream().mapToLong(Integer::longValue).sum();
            case MULT -> numbers.stream().mapToLong(Integer::longValue).reduce(1L, Math::multiplyExact);
        };
    }
}