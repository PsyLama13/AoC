package helper;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * The puzzle input of a day, convertible into the shape the puzzle needs.
 * Line endings are normalized and trailing whitespace (e.g. the final newline) is removed.
 */
public final class Input {
    private final String text;

    private Input(String text) {
        this.text = text.replace("\r\n", "\n").stripTrailing();
    }

    public static Input of(String text) {
        return new Input(text);
    }

    public static Input fromFile(Path path) {
        try {
            return new Input(Files.readString(path));
        } catch (IOException e) {
            throw new UncheckedIOException("Could not read input " + path, e);
        }
    }

    /**
     * The whole input as a single string, e.g. for puzzles with one long line.
     */
    public String text() {
        return text;
    }

    public List<String> lines() {
        return text.lines().toList();
    }

    /**
     * One number per line.
     */
    public List<Integer> ints() {
        return lines().stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    /**
     * Groups of lines separated by blank lines.
     */
    public List<List<String>> blocks() {
        return Arrays.stream(text.split("\n\\s*\n"))
                .map(block -> block.lines().toList())
                .toList();
    }
}
