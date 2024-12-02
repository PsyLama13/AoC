package y2020.d6;

import java.util.ArrayList;
import java.util.List;

public class QuestionHelper {
    List<QuestionnaireGroup> groupList = new ArrayList<>();
    public QuestionHelper(List<String> input) {
        List<String> groupStrings = new ArrayList<>();
        for(String s : input){
            if(s.isEmpty()){
                QuestionnaireGroup qg = new QuestionnaireGroup(groupStrings);
                groupList.add(qg);
                groupStrings = new ArrayList<>();
            }
            groupStrings.add(s);
        }
        QuestionnaireGroup qg = new QuestionnaireGroup(groupStrings);
        groupList.add(qg);
    }

    public int calc1(){
        int count = 0;
        for(QuestionnaireGroup group : groupList){
            count += group.getYesAnswersInGroup();
        }
        return count;
    }

    public int calc2(){
        int count = 0;
        for(QuestionnaireGroup group : groupList){
            count += group.getTogetherYesAnswersInGroup();
        }
        return count;
    }
}
