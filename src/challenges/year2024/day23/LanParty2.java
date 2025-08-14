package challenges.year2024.day23;

import helper.Helper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LanParty2  {
    private final Map<String, Set<String>> network;

    public LanParty2(List<String> input) {
        network = new HashMap<>();
        for(String line : input){
            String[] computers = line.split("-");
            saveConnection(computers[0], computers[1]);
            saveConnection(computers[1], computers[0]);
        }

    }

    public String part1() {
        long interconnectedTriosContainingT = interconnectedTriosWithStartingT().size();
        return Long.toString(interconnectedTriosContainingT);
    }

    public String part2() {
        Set<String> largest = findGroups().stream().max(Comparator.comparingInt(Set::size)).orElseThrow();
        return largest.stream().sorted().collect(Collectors.joining(","));
    }

    private void saveConnection(String from, String to) {
        network.computeIfAbsent(from, _ -> new HashSet<>()).add(to);
    }

    private Set<Set<String>> interconnectedTriosWithStartingT() {
        Set<Set<String>> interconnectedTrios = new HashSet<>();
        network.keySet().stream().filter(s -> s.startsWith("t"))
                .forEach(firstNode -> network.get(firstNode).stream().filter(secondNode -> !secondNode.equals(firstNode))
                        .forEach(secondNode -> network.get(secondNode).stream().filter(thirdNode -> !thirdNode.equals(firstNode) && network.get(thirdNode).contains(firstNode))
                                .forEach(thirdNode -> interconnectedTrios.add(Set.of(firstNode, secondNode, thirdNode)))));
        return interconnectedTrios;
    }

    private Set<Set<String>> findGroups() {
        Set<Set<String>> groups = new HashSet<>();
        for (String firstNode : network.keySet()) {
            Set<String> checked = new HashSet<>();
            Set<String> passed = new HashSet<>();
            Queue<String> queue = new ArrayDeque<>();
            queue.add(firstNode);
            while (!queue.isEmpty()) {
                String node = queue.poll();
                if (!checked.contains(node) && network.get(node).containsAll(passed)) {
                    passed.add(node);
                    checked.add(node);
                    for (String next : network.get(node)) {
                        if (!checked.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
            groups.add(passed);
        }
        return groups;
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d23.txt");
        LanParty2 day23 = new LanParty2(input);
        System.out.println(day23.part1());
        System.out.println(day23.part2());
    }
}