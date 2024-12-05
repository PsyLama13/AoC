package y2020.d7;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    String name;
    List<String> contents = new ArrayList<>();
    BagTree tree;
    public Bag(String s) {
        String[] splitter = s.split(" bags contain ");
        name = splitter[0];

        String content = splitter[1];
        if(content.equals("no other bags.")){
            // do nothing, bag is empty;
        }else{
            String[] arr = content.substring(0, content.length()-1).split(", ");
            for(String str : arr){
                String[] temp = str.split(" ");
                String asdf = temp[1] + " " + temp [2];
                contents.add(asdf);
            }
        }
    }

    public void fillTree(List<Bag> bags) {
        List<Bag> children = new ArrayList<>();
        for(String content : contents){
            Bag bag = bags.stream().filter(i -> i.name.equals(content)).findFirst().orElseThrow();
            children.add(bag);
        }
        tree = new BagTree(this, null, children);
        for(Bag child : children){
            //fillTreeRecursively()
        }
    }
}
