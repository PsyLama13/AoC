package challenges.year2025.day10;

import java.util.*;


public class Machine {
    private LightSet goal;
    private final List<Button> buttons = new ArrayList<>();
    private final List<Integer> joltages = new ArrayList<>();

    public Machine(String s) {
        String[] split = s.split(" ");
        for (String part : split) {
            Character c = part.charAt(0);
            switch (c) {
                case '[' -> parseIndicatorLights(part);
                case '(' -> parseButtons(part);
                case '{' -> parseJoltage(part);
                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
        }

    }

    public long getFewestButtonSwitches() {

        Set<LightSet> visited = new HashSet<>();
        PriorityQueue<LightToButtonList> queue = new PriorityQueue<>(
                Comparator.comparingInt(ltbl -> ltbl.history().size())
        );

        LightSet start = new LightSet(goal.lights().size());
        queue.add(new LightToButtonList(start, new ArrayList<>()));
        visited.add(start);

        while (!queue.isEmpty()) {

            LightToButtonList ltbl = queue.poll();
            LightSet current = ltbl.lightSet();
            List<Button> currentHistory = ltbl.history();
            for (Button button : buttons) {
                LightSet next = current.handleButtonPress(button);

                if (next.equals(goal)) {
                    return currentHistory.size() + 1;
                }

                if (!visited.contains(next)) {
                    visited.add(next);
                    List<Button> temp = new ArrayList<>(currentHistory);
                    temp.add(button);
                    queue.add(new LightToButtonList(next, temp));
                }
            }
        }
        throw new IllegalStateException("no solution");
    }

    public long getFewestButtonSwitchesWithJoltage() {

        JoltageLightSet joltGoal = new JoltageLightSet(goal, joltages);
        Set<JoltageLightSet> visited = new HashSet<>();
        PriorityQueue<JoltageLightToButtonList> queue = new PriorityQueue<>(
                Comparator.comparingInt(ltbl -> ltbl.history().size())
        );

        LightSet startLight = new LightSet(goal.lights().size());
        JoltageLightSet jls = new JoltageLightSet(startLight, Collections.nCopies(joltages.size(), 0));
        queue.add(new JoltageLightToButtonList(jls, new ArrayList<>()));
        visited.add(jls);

        while (!queue.isEmpty()) {

            JoltageLightToButtonList ltbl = queue.poll();
            JoltageLightSet currentLight = ltbl.joltageLightSet();

            List<Button> currentHistory = ltbl.history();
            for (Button button : buttons) {
                JoltageLightSet next = currentLight.handleButtonPress(button);

                if (next.equals(joltGoal)) {
                    return currentHistory.size() + 1;
                }

                if (!visited.contains(next)) {
                    visited.add(next);
                    List<Button> temp = new ArrayList<>(currentHistory);
                    temp.add(button);
                    queue.add(new JoltageLightToButtonList(next, temp));
                }
            }
        }
        throw new IllegalStateException("no solution");
    }

    private void parseJoltage(String part) {
        part = part.substring(1, part.length() - 1);
        for (String s : part.split(",")) {
            joltages.add(Integer.parseInt(s));
        }
    }

    private void parseButtons(String part) {
        part = part.substring(1, part.length() - 1);
        List<Integer> lightSwitchList = new ArrayList<>();
        for (String s : part.split(",")) {
            Integer i = Integer.parseInt(s);
            lightSwitchList.add(i);
        }
        buttons.add(new Button(lightSwitchList));
    }

    private void parseIndicatorLights(String part) {
        List<Boolean> lights = new ArrayList<>();
        part = part.substring(1, part.length() - 1);
        for (String s : part.split("")) {
            if (s.equals(".")) {
                lights.add(false);
            } else if (s.equals("#")) {
                lights.add(true);
            } else {
                throw new IllegalStateException();
            }
        }
        goal = new LightSet(lights);
    }

}