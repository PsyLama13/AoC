package challenges.year2021.d7;

import java.util.ArrayList;
import java.util.List;

public class Aligner {
    List<Integer> positionList = new ArrayList<>();
    int minPos = Integer.MAX_VALUE;
    int maxPos = Integer.MIN_VALUE;
    public Aligner(List<String> input) {
        List<String> list = List.of(input.get(0).split(","));
        for(String s : list){
            int i = Integer.parseInt(s);
            positionList.add(i);
            if(i > maxPos){
                maxPos = i;
            }
            if(i < minPos){
                minPos = i;
            }
        }
    }

    public int getLeastFuel() {
        int minFuel = Integer.MAX_VALUE;
        for(Integer pos : positionList){
            int fuelCount = 0;
            for(Integer posToCheck : positionList){
                fuelCount += Math.abs(pos - posToCheck);
            }
            if(fuelCount < minFuel){
                minFuel = fuelCount;
            }
        }
        return minFuel;
    }

    public int getLeastFuelSecond() {
        int minFuel = Integer.MAX_VALUE;
        for(int i = minPos ; i < maxPos; i++){
            int fuelCount = 0;
            for(Integer pos : positionList){
                fuelCount += calcFuelUsage(pos, i);
            }
            if(fuelCount < minFuel){
                minFuel = fuelCount;
            }
        }
        return minFuel;
    }

    private int calcFuelUsage(Integer pos, Integer posToCheck) {
        if(pos == posToCheck){
            return 0;
        }
        int smaller = pos < posToCheck ? pos : posToCheck;
        int bigger = pos > posToCheck ? pos : posToCheck;

        int count = 0;
        int output = 0;
        for(int i = smaller ; i <= bigger; i++){
            output += count;
            count++;
        }
        return output;
    }
}
