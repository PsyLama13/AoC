package y2020.d3;

import java.util.List;

public class ToggobanCalculator {

    int sideStep;
    int downStep;
    WorldMap worldMap;
    int bottom;

    public ToggobanCalculator(List<String> input, int sideStep, int downStep) {
        worldMap = new WorldMap(input);
        bottom = input.size();
        this.sideStep = sideStep;
        this.downStep = downStep;
    }

    public int calc1() {
        int tempHeight = 0;
        int x = 0;
        int y = 0;
        int treeCounter = 0;
        while (tempHeight < bottom-1){
            x += sideStep;
            y += downStep;
            tempHeight = y;
            Geology g = worldMap.getGeologyAtPosition(x, y);
            if(g.equals(Geology.TREE)){
                treeCounter++;
            }

        }
        return treeCounter;
    }
}
