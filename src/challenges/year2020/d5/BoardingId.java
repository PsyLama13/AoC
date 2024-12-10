package challenges.year2020.d5;

public class BoardingId {
    private int row;
    private int column;

    int maxRow = 128;
    int maxColumn = 8;

    public BoardingId(String input) {
        row = calcRow(input);
        column = calcColumn(input);

    }

    private int calcRow(String input) {
        String code = input.substring(0, 7);
        int min = 0;
        int max = maxRow;
        for (String s : code.split("")) {
            int dif = (max - min) / 2;
            switch (s) {
                case "F" -> {
                    max -= dif;
                }
                case "B" -> {

                    min += dif;
                }
                default -> throw new IllegalStateException();
            }
        }
        return min;
    }

    private int calcColumn(String input) {
        String code = input.substring(7);
        int min = 0;
        int max = maxColumn;
        for (String s : code.split("")) {
            int diff = (max - min) / 2;
            switch (s) {
                case "L" -> {
                    max -= diff;
                }
                case "R" -> {
                    min += diff;
                }
                default -> throw new IllegalStateException();
            }
        }
        return min;
    }

    public int getId() {
        return row * 8 + column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "BoardingId{" +
                "row=" + row +
                ", column=" + column +
                ", id=" + this.getId() +
                '}';
    }
}
