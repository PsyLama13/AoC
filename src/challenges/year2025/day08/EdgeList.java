package challenges.year2025.day08;

import java.util.ArrayList;
import java.util.List;

public class EdgeList {
    List<Edge> edges = new ArrayList<>();

    public EdgeList(List<JunctionBox> boxList) {
        for (int i = 0; i < boxList.size(); i++) {
            for (int j = i + 1; j < boxList.size(); j++) {
                JunctionBox box1 = boxList.get(i);
                JunctionBox box2 = boxList.get(j);
                double distance = box1.getDistanceTo(box2);
                edges.add(new Edge(box1, box2, distance));
            }
        }
        edges.sort(Edge::compareTo);
    }

    public Edge removeFirst(){
        return edges.removeFirst();
    }
}