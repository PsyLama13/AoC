package challenges.year2025.day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CircuitSet {
    private final List<BoxCluster> circuitList = new ArrayList<>();

    public void addCluster(JunctionBox box) {
        circuitList.add(new BoxCluster(Collections.singleton(box)));
    }

    public int getClusterListSize() {
        return circuitList.size();
    }

    public void mergeClusters(Edge edge) {
        BoxCluster a = findCluster(edge.a());
        BoxCluster b = findCluster(edge.b());
        if (a.equals(b)) {
            return;
        }

        a.merge(b);
        circuitList.remove(b);
    }

    private BoxCluster findCluster(JunctionBox a) {
        for (BoxCluster cluster : circuitList) {
            if (cluster.contains(a)) {
                return cluster;
            }
        }
        throw new IllegalStateException();
    }

    public List<BoxCluster> getBiggestN(int n) {
        return circuitList.stream().sorted(Comparator.reverseOrder()).limit(n).toList();
    }
}
