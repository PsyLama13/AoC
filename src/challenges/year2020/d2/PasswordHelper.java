package challenges.year2020.d2;

import java.util.ArrayList;
import java.util.List;

public class PasswordHelper {

    List<PolicyCheck> list = new ArrayList<>();

    public PasswordHelper(List<String> input) {
        for (String s : input) {
            List<String> subString = List.of(s.split(" "));
            List<String> numberString = List.of(subString.get(0).split("-"));
            List<String> policyCharacter = List.of(subString.get(1).split(":"));

            int min = Integer.parseInt(numberString.get(0));
            int max = Integer.parseInt(numberString.get(1));
            String c = policyCharacter.get(0);
            PolicyCheck policyCheck = new PolicyCheck(min, max, c, subString.get(2));
            list.add(policyCheck);
        }
    }

    public int getNumberOfValidPws(){
        int counter = 0;
        for(PolicyCheck p : list){
            if(p.isValid()){
                counter++;
            }
        }
        return counter;
    }

    public int getNumberOfValidPws2(){
        int counter = 0;
        for(PolicyCheck p : list){
            if(p.isValid2()){
                counter++;
            }
        }
        return counter;
    }
}
