package challenges.year2025.day04;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PaperRollDiagram {
    HashSet<PaperRoll> paperRollLocations = new HashSet<>();

    public PaperRollDiagram(List<String> input) {
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                char c = line.charAt(x);
                if (PaperRoll.isPaperRoll(c)) {
                    paperRollLocations.add(new PaperRoll(new Coordinate(x, y)));
                }
            }
        }
    }

    public Integer getAccessiblePaperRollsCount() {
        return getAccessiblePaperRolls().size();
    }

    public Integer getAccessiblePaperRollsCountRecursively(){
        int counter = 0;
        while (true){
            List<PaperRoll> accessibleRolls = getAccessiblePaperRolls();

            if(accessibleRolls.isEmpty()){
                return counter;
            }
            counter += accessibleRolls.size();
            accessibleRolls.forEach(paperRollLocations::remove);
        }
    }

    private List<PaperRoll> getAccessiblePaperRolls() {
        List<PaperRoll> accessibleRolls = new ArrayList<>();
        for (PaperRoll paperRoll : paperRollLocations) {
            if(paperRoll.isAccessible(paperRollLocations)){
                accessibleRolls.add(paperRoll);
            }
        }
        return accessibleRolls;
    }
}