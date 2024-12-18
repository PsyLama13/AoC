package challenges.year2015.d1;

import java.util.List;
import java.util.Objects;

public class BracketParser {

    String instruction;

    public BracketParser(List<String> input) {
        instruction = input.get(0);
    }

    int getFirstBasementOccurrence() {
        int level = 0;
        for (int i = 0; i < instruction.length(); i++) {
            Character c = instruction.charAt(i);
            Direction direction = Direction.parseDirection(c);
            if (Objects.requireNonNull(direction) == Direction.UP) {
                level++;
            } else if (direction == Direction.DOWN) {
                level--;
            } else {
                throw new IllegalStateException("Unexpected value: " + direction);
            }

            if (level == -1) {
                return i + 1;
            }
        }
        throw new IllegalStateException();
    }
}
