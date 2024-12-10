package challenges.year2020.d7;

import java.util.List;

public class BagTree {
    Bag entry;
    Bag parent;
    List<Bag> children;

    public BagTree(Bag entry, Bag parent, List<Bag> children) {
        this.entry = entry;
        this.parent = parent;
        this.children = children;
    }
}
