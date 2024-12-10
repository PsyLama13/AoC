package challenges.year2021.d6;

import java.util.List;

public class FishBowl {


    FishLine fishLine = new FishLine();
    public FishBowl(List<String> input){
        parseFishes(input);
    }

    private void parseFishes(List<String> input) {
        fishLine.initFill(List.of(input.get(0).split(",")));
    }

    public void doDay(){
        Long newFishCount = fishLine.pop();
        fishLine.add(8, newFishCount);
        fishLine.add(6, newFishCount);
    }

    public long getFishesForDays(int days) {
        for(int i = 0; i < days; i++){
            doDay();
        }
        return fishLine.getFishCount();
    }
}
