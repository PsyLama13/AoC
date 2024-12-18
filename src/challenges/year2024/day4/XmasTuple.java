package challenges.year2024.day4;

import helper.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class XmasTuple {
    private final Coordinate x;
    private Coordinate m;

    public XmasTuple(Coordinate firstCoordinate) {
        this.x = firstCoordinate;
    }

    public List<XmasTuple> copyWithMs(List<Coordinate> mList) {
        List<XmasTuple> output = new ArrayList<>();
        for (Coordinate m : mList) {
            if (m.isNeighbouringTo(x)) {
                XmasTuple temp = new XmasTuple(this.x);
                temp.m = m;
                output.add(temp);
            }
        }

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmasTuple xmasTuple)) return false;
        return Objects.equals(x, xmasTuple.x) && Objects.equals(m, xmasTuple.m);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, m);
    }

    public boolean isValid(Map<Coordinate, String> wordMap) {
        int dx = (int) (m.x() - x.x());
        int dy = (int) (m.y() - x.y());
        Coordinate a = new Coordinate(m.x() + dx, m.y() + dy);
        Coordinate s = new Coordinate(a.x() + dx, a.y() + dy);
        String aString = wordMap.get(a);
        String sString = wordMap.get(s);

        return aString != null && sString != null && aString.equals("A") && sString.equals("S");
    }
}