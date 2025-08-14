package challenges.year2024.day19;

import java.util.*;

public class Towel {
    String towelPattern;

    public Towel(String towelPattern) {
        this.towelPattern = towelPattern;
    }

    public boolean isSolvable(List<String> towelPatterns, Map<String, Set<String>> cache) {
        String temp = towelPattern;
        List<String> queue = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            String current = queue.removeFirst();
            if (current.isEmpty()) {
                return true;
            }
            visited.add(current);
            Set<String> successors = findPatterns(current, towelPatterns, cache);
            for (String successor : successors) {
                String newTowelPattern = current.substring(successor.length());
                if (!visited.contains(newTowelPattern) && !queue.contains(newTowelPattern)) {
                    queue.add(newTowelPattern);
                }
            }
        }
        return false;
    }

    private Set<String> findPatterns(String towel, List<String> towelPatterns, Map<String, Set<String>> cache) {
        // Cache the result for the current towel substring
        if (cache.containsKey(towel)) {
            return cache.get(towel);
        }

        Set<String> successors = new HashSet<>();
        for (String pattern : towelPatterns) {
            if (towel.startsWith(pattern)) {
                successors.add(pattern);
            }
        }

        cache.put(towel, successors);
        return successors;
    }

    public long getCombinationList(Map<Character, List<String>> towels, Map<String, Long> cache2) {
     long combinations = getCombinations(towelPattern, towels, cache2);
     return combinations;
    }

    private long getCombinations(String pattern, Map<Character, List<String>> towels, Map<String, Long> cache) {
        if(pattern.isEmpty()){
            return 1;
        }

        if(cache.containsKey(pattern)){
            return cache.get(pattern);
        }

        List<String> arr = new ArrayList<>(towels.get(pattern.charAt(0)));
        for(int i = arr.size()-1; i >= 0; i--){
            if(!pattern.startsWith(arr.get(i))){
                arr.remove(i);
            }
        }

        long count = 0;
        for(String towel : arr){
            count += getCombinations(pattern.substring(towel.length()), towels, cache);
        }
        cache.put(pattern, count);
        return count;
    }
}