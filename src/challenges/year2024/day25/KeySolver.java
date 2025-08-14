package challenges.year2024.day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class KeySolver {
    List<List<Integer>> keys = new ArrayList<>();
    List<List<Integer>> locks = new ArrayList<>();

    public KeySolver(List<String> input) {
        List<String> strings = new ArrayList<>();
        for (String string : input) {
            if (string.isEmpty()) {
                boolean isLock = isLock(strings);
                if (isLock) {
                    locks.add(createIntList(strings));
                } else {
                    keys.add(createIntList(strings));
                }
                strings.clear();
                continue;

            }
            strings.add(string);
        }
        if (isLock(strings)) {
            locks.add(createIntList(strings));
        } else {
            keys.add(createIntList(strings));
        }
    }

    public int calc1() {
        int counter = 0;
        List<List<Integer>> tempKeys = new ArrayList<>(keys);
        for (List<Integer> lock : locks) {
            for (List<Integer> key : tempKeys) {
                if (areMatching(lock, key)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean areMatching(List<Integer> lock, List<Integer> key) {
        for (int i = 0; i < lock.size(); i++) {
            if (key.get(i) + lock.get(i) > 5) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> createIntList(List<String> strings) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(strings.get(0).length(), -1));
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c == '#') {
                    list.set(i, list.get(i) + 1);
                }
            }
        }
        return list;
    }

    private boolean isLock(List<String> strings) {
        return Stream.of(strings.get(0).split("")).allMatch(i -> i.equals("#"));
    }
}
