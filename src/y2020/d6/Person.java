package y2020.d6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Person {
    Set<String> yesAnswers = new HashSet<>();
    public Person(String s) {
        if(!s.isEmpty()){
            yesAnswers.addAll(Arrays.asList(s.split("")));
        }
    }

    public int getAmountOfYesAnswers(){
        return yesAnswers.size();
    }

    public Set<String> getYesAnswers(){
        return yesAnswers;
    }
}
