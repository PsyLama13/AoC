package y2020.d6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionnaireGroup {
    List<Person> people = new ArrayList<>();

    public QuestionnaireGroup(List<String> groupStrings) {
        for (String s : groupStrings) {
            Person person = new Person(s);
            people.add(person);
        }
        people.removeIf(p -> p.yesAnswers.isEmpty());
    }

    public int getYesAnswersInGroup() {
        Set<String> answers = new HashSet<>();
        for (Person person : people) {
            answers.addAll(person.getYesAnswers());
        }
        return answers.size();
    }

    public int getTogetherYesAnswersInGroup() {
        Set<String> answers = people.getFirst().yesAnswers;
        for(Person person : people){
            answers.retainAll(person.yesAnswers);
        }
        return answers.size();
    }
}
