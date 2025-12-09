package challenges.year2025.day08;

import java.util.ArrayList;
import java.util.List;

public class JunctionBoxMap {
    private final List<JunctionBox> boxes = new ArrayList<>();

    public JunctionBoxMap(List<String> input) {
        for (String s : input) {
            String[] split = s.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int z = Integer.parseInt(split[2]);
            boxes.add(new JunctionBox(x, y, z));
        }
    }

    public long solve(int iterator) {
        EdgeList edgeList = new EdgeList(boxes);
        CircuitSet circuitSet = new CircuitSet();
        for (JunctionBox box : boxes) {
            circuitSet.addCluster(box);
        }

        for (int i = 0; i < iterator; i++) {
            Edge edge = edgeList.removeFirst();
            circuitSet.mergeClusters(edge);
        }

        List<BoxCluster> biggest = circuitSet.getBiggestN(3);
        return biggest.stream().mapToLong(i -> i.boxes().size()).reduce(1L, Math::multiplyExact);
    }

    public long solve2() {
        EdgeList edgeList = new EdgeList(boxes);
        CircuitSet circuitSet = new CircuitSet();
        for (JunctionBox box : boxes) {
            circuitSet.addCluster(box);
        }

        while (true) {
            Edge edge = edgeList.removeFirst();
            circuitSet.mergeClusters(edge);

            if (circuitSet.getClusterListSize() == 1) {
                return edge.multiplyXValues();
            }
        }
    }
}