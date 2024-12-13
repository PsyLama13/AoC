package challenges.year2020.d7;

import java.util.*;

public class BagHelper {
    Map<String, Set<String>> bagMap = new HashMap<>();

    public BagHelper(List<String> input) {
        for (String s : input) {
            Bag bag = new Bag(s);
            bagMap.put(bag.name, bag.contents);
        }

    }

    public int calc1() {
        int count = calcPossibilities();
        return count;
    }

    private int calcPossibilities() {
        String startBag = "shiny gold";
        List<String> parents = getPossibleParents(startBag);
        return 1;
    }

    private List<String> getPossibleParents(String startBag) {
        List<String> parents = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : bagMap.entrySet()) {
            if(entry.getValue().contains(startBag)){
                parents.add(entry.getKey());
            }
        }
        return parents;
    }
}
