package challenges.year2015.d5;

import java.util.List;
import java.util.Objects;

public class NiceStringCounter {
    private List<String> strings;

    private final List<String> badStrings = List.of("ab", "cd", "pq", "xy");
    private final List<String> vowels = List.of("a", "e", "i", "o", "u");

    public NiceStringCounter(List<String> input) {
        strings = input;
    }

    public int count() {
        int counter = 0;
        for (String string : strings) {
            if (isNice(string)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isNice(String string) {
        return containsAtLeastThreeVowels(string) && containsDoubleLetter(string) && !containsBadStrings(string);
    }

    private boolean containsBadStrings(String string) {
        for (String badString : badStrings) {
            if (string.contains(badString)) {
                return true;
            }
        }

        return false;
    }

    private boolean containsDoubleLetter(String string) {

        for (int i = 0; i < string.length() - 1; i++) {
            char firstChar = string.charAt(i);
            char secondChar = string.charAt(i + 1);
            if (Objects.equals(firstChar, secondChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsAtLeastThreeVowels(String string) {
        int vowelCount = 0;

        for (int i = 0; i < string.length(); i++) {
            String s = String.valueOf(string.charAt(i));
            if (vowels.contains(s)) {
                vowelCount++;
            }
        }

        return vowelCount >= 3;
    }

    public int countCorrect() {
        int counter = 0;
        for (String s : strings) {
            if (isReallyNice(s)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isReallyNice(String s) {
        return containsNonOverLappingPair(s) && containsRepeatedLetter(s);
    }

    private boolean containsRepeatedLetter(String s) {
        for(int i = 0; i < s.length()-2; i++){
            char first = s.charAt(i);
            char second = s.charAt(i+2);
            if(first == second){
                return true;
            }
        }

        return false;
    }

    private boolean containsNonOverLappingPair(String s) {
        String firstPair = s.substring(0, 2);
        String checkString = s.substring(2, s.length());
        if(checkString.contains(firstPair)){
            return true;
        }

        for(int i = 1; i < s.length()-1; i++){
            firstPair = s.substring(i, i + 2);
            checkString = s.substring(0,i) + s.substring(i+2, s.length());
            if(checkString.contains(firstPair)){
                return true;
            }
        }

        return false;
    }
}
