package y2021.d6;

import java.util.ArrayList;
import java.util.List;

public class FishLine {

    private List<Long> list;
    public FishLine(){
        list = new ArrayList<>();
    }
    public void initFill(List<String> input){
        for(int i = 0; i <= 8; i++){
            list.add(0L);
        }

        for(String s : input){
            int i = Integer.parseInt(s);
            list.set(i, list.get(i) + 1);
        }
    }

    public Long pop(){
        Long retVal = list.remove(0);
        list.add(0L);
        return retVal;
    }

    public long getFishCount(){
        long output = 0;
        for(Long i : list){
            output += i;
        }
        return output;
    }

    public void add(int pos, Long num){
        Long initVal = list.get(pos);
        list.set(pos, initVal + num);
    }
}
