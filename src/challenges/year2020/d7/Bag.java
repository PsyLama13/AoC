package challenges.year2020.d7;

import java.util.HashSet;
import java.util.Set;

public class Bag {
    String name;
    Set<String> contents = new HashSet<>();

    public Bag(String s) {
        String[] splitter = s.split(" bags contain ");
        name = splitter[0];

        String content = splitter[1];
        if (!content.equals("no other bags.")) {
            String[] arr = content.substring(0, content.length() - 1).split(", ");
            for (String str : arr) {
                String[] temp = str.split(" ");
                String string = temp[1] + " " + temp[2];
                contents.add(string);
            }
        }
    }
}
