package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Helper {

    public static List<String> readInput(String location) throws IOException {

        String locationPrefix = "src/resources/";
        String content = new String(Files.readAllBytes(Paths.get(locationPrefix + location)));
        List<String> output = List.of(content.split("\r\n"));

        return output;
    }
}
