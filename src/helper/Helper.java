package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Helper {
    private Helper() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> readInput(String location) {

        String locationPrefix = "src/resources/";
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(locationPrefix + location)));
        } catch (IOException e) {
            IO.println("error while parsing " + locationPrefix + location + " excception was: " + e);
            return null;
        }

        return List.of(content.split("\r\n"));
    }
}
