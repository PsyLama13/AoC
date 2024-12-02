package y2020.d5;

import helper.Coordinate;

import java.util.*;
import java.util.stream.Collectors;

public class BoardingHelper {

    List<BoardingId> boardingIds = new ArrayList<>();

    public BoardingHelper(List<String> input) {
        for (String s : input) {
            BoardingId boardingId = new BoardingId(s);
            boardingIds.add(boardingId);
        }
    }

    public int calc1() {
        int maxId = Integer.MIN_VALUE;
        for (BoardingId boardingId : boardingIds) {
            if (boardingId.getId() > maxId) {
                maxId = boardingId.getId();
            }
        }
        return maxId;
    }

    public int calc2() {
        Collections.sort(boardingIds, new Comparator<BoardingId>() {
            @Override
            public int compare(BoardingId o1, BoardingId o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        Integer prevId = null;
        for(BoardingId id : boardingIds){
            if(prevId != null){
                if(id.getId()-1 != prevId){
                 return id.getId() -1;
                }
            }

            prevId = id.getId();
        }
        return 1;
    }

    public void plotPoints() {
        String[][] arr = new String[128][8];
        for (BoardingId id : boardingIds) {
            arr[id.getRow()][id.getColumn()] = "x";
        }
    }
}
