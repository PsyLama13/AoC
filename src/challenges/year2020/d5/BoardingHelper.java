package challenges.year2020.d5;

import java.util.ArrayList;
import java.util.List;

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
        boardingIds.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        Integer prevId = null;
        for (BoardingId id : boardingIds) {
            if (prevId != null && id.getId() - 1 != prevId) {
                return id.getId() - 1;
            }


            prevId = id.getId();
        }
        return 1;
    }
}