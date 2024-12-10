package challenges.year2021.d4;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class BingoGrid {

    BingoValue[][] values;
    List<Coordinate> markedValues = new ArrayList<>();
    int maxx;
    int maxy;

    public BingoGrid(List<String> strings) {

        maxy = strings.size();
        ArrayList<String> temp = new ArrayList<>(List.of(strings.get(0).split(" ")));
        temp.removeIf(String::isEmpty);
        maxx = temp.size();
        values = new BingoValue[maxx][maxy];
        for (int y = 0; y < strings.size(); y++) {
            List<String> numberStrings = new java.util.ArrayList<>(List.of(strings.get(y).split(" ")));
            numberStrings.removeIf(String::isEmpty);
            for (int x = 0; x < numberStrings.size(); x++) {
                String s = numberStrings.get(x);
                int value = Integer.parseInt(s);
                values[x][y] = new BingoValue(value);
            }
        }
    }

    public void markNumber(int val) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if (values[i][j].value() == val) {
                    values[i][j].markValue();
                    markedValues.add(new Coordinate(i, j));
                }
            }
        }
    }

    public Integer getWinningNumber() {
        if (isWinning()) {
            return calculateWinningNumber();
        }
        return null;
    }

    private Integer calculateWinningNumber() {
        int val = 0;
        for(int y = 0; y < maxy; y++){
            for(int x = 0; x < maxx; x++){
                if(!values[x][y].marked()){
                    val += values[x][y].value();
                }
            }
        }
        return val;
    }

    private boolean isWinning() {
        return hasWinningLine() || hasWinningRow();
    }

    private boolean hasWinningLine() {

        for(int y = 0; y < maxy; y++){
            final int v = y;
            int count = Math.toIntExact(markedValues.stream().filter(i -> i.y() == v).count());
            if(count == maxx){
                return true;
            }
        }

        return false;
    }

    public boolean hasWinningRow() {

        for(int x = 0; x < maxx; x++){
            final int v = x;
            int count = Math.toIntExact(markedValues.stream().filter(i -> i.x() == v).count());
            if(count == maxy){
                return true;
            }
        }
        return false;
    }
}
