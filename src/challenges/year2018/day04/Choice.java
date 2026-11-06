package challenges.year2018.day04;

/**
 * The guard/minute combination chosen by a strategy to sneak into the lab.
 */
public record Choice(Guard guard, Minute minute) {

    /**
     * The ID of the chosen guard multiplied by the chosen minute.
     */
    public int answer() {
        return guard.id().value() * minute.value();
    }
}
