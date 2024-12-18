package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Helper {
    private Helper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> readInput(String location) throws IOException {

        String locationPrefix = "src/resources/";
        String content = new String(Files.readAllBytes(Paths.get(locationPrefix + location)));

        return List.of(content.split("\r\n"));
    }
}
