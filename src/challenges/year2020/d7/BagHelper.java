package challenges.year2020.d7;

import java.util.ArrayList;
import java.util.List;

public class BagHelper {
    List<Bag> bags = new ArrayList<>();

    public BagHelper(List<String> input) {
        for(String s : input){
            Bag bag = new Bag(s);
            bags.add(bag);
        }
        for(Bag bag : bags){
            bag.fillTree(bags);
        }
    }

    public int calc1() {
        return 0;
    }
}
