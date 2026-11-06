package helper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base class for a day's tests. Derives year and day from the package name,
 * e.g. {@code challenges.year2018.day05} loads {@code src/resources/year2018/d05.txt}.
 */
public abstract class AocTest {
    private static final Pattern YEAR_AND_DAY = Pattern.compile("year(\\d{4})\\.d(?:ay)?(\\d+)$");
    private static final Path RESOURCES = Path.of("src", "resources");

    private Input input;

    protected Input input() {
        if (input == null) {
            input = Input.fromFile(inputFile());
        }
        return input;
    }

    private Path inputFile() {
        String packageName = getClass().getPackageName();
        Matcher matcher = YEAR_AND_DAY.matcher(packageName);
        if (!matcher.find()) {
            throw new IllegalStateException(
                    "Package must end with yearYYYY.dayDD to find the input, was " + packageName);
        }
        int year = Integer.parseInt(matcher.group(1));
        int day = Integer.parseInt(matcher.group(2));
        Path file = RESOURCES.resolve("year" + year).resolve("d%02d.txt".formatted(day));

        if (!Files.exists(file)) {
            throw new IllegalStateException("Input not found: " + file
                    + " - download it from https://adventofcode.com/" + year + "/day/" + day + "/input");
        }
        return file;
    }
}
