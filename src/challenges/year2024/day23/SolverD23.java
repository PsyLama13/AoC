package challenges.year2024.day23;

import helper.Helper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SolverD23 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2024/d23.txt");
        List<String> debug = Helper.readInput("year2024/d23d.txt");

        //calc1(input);
        calc2(input);
    }

    private static void calc2(List<String> input) {
        Map<String, Set<String>> graph = new HashMap<>();

        for (String connection : input) {
            String[] nodes = connection.split("-");
            String node1 = nodes[0];
            String node2 = nodes[1];

            graph.putIfAbsent(node1, new HashSet<>());
            graph.putIfAbsent(node2, new HashSet<>());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        Set<Set<String>> groups = new HashSet<>();

        for (String firstNode : graph.keySet()) {
            groups.add(getGroupEntry(firstNode, graph));
        }
        Set<String> maxSet = getMaxSet(groups);
        String pwString = getPwString(maxSet);
        System.out.println(pwString);
    }

    private static String getPwString(Set<String> maxSet) {
        return maxSet.stream().sorted().collect(Collectors.joining(","));
    }

    private static Set<String> getMaxSet(Set<Set<String>> groups) {
        return groups.stream().max(Comparator.comparingInt(Set::size)).orElseThrow();
    }

    private static Set<String> getGroupEntry(String firstNode, Map<String, Set<String>> graph) {
        Set<String> visited = new HashSet<>();
        Set<String> passed = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node) && graph.get(node).containsAll(passed)) {
                passed.add(node);
                visited.add(node);
                for (String next : graph.get(node)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return passed;
    }

    private static void calc1(List<String> input) {

        Map<String, Set<String>> graph = new HashMap<>();

        for (String connection : input) {
            String[] nodes = connection.split("-");
            String node1 = nodes[0];
            String node2 = nodes[1];

            graph.putIfAbsent(node1, new HashSet<>());
            graph.putIfAbsent(node2, new HashSet<>());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        Set<Set<String>> triples = findTriples(graph);
        List<Set<String>> chiefTriples = findChiefTriples(triples);

        System.out.println(chiefTriples.size());
    }

    private static List<Set<String>> findChiefTriples(Set<Set<String>> triples) {
        return triples.stream().filter(i -> i.stream().anyMatch(k -> k.startsWith("t"))).toList();
    }

    private static Set<Set<String>> findTriples(Map<String, Set<String>> graph) {
        Set<Set<String>> triples = new HashSet<>();
        for (String node : graph.keySet()) {
            Set<String> neighbours = graph.get(node);
            for (String neighbour1 : neighbours) {
                for (String neighbour2 : neighbours) {
                    if (!neighbour1.equals(neighbour2) && graph.get(neighbour1).contains(neighbour2)) {
                        Set<String> triple = new TreeSet<>(Arrays.asList(node, neighbour1, neighbour2));
                        triples.add(triple);
                    }
                }
            }
        }
        return triples;
    }
}
