package challenges.year2020.d4;

import java.util.ArrayList;
import java.util.List;

public class PassportScanner {

    List<Passport> passports = new ArrayList<>();

    public PassportScanner(List<String> input) {
        List<String> sublist = new ArrayList<>();
        for (String s : input) {
            if (!s.isEmpty()) {
                sublist.add(s);
            } else {
                Passport passport = new Passport(sublist);
                passports.add(passport);
                sublist.clear();
            }
        }
        Passport passport = new Passport(sublist);
        passports.add(passport);
    }

    public int calc1(){
        int counter = 0;
        for(Passport passport : passports){
            if(passport.isValid()){
                counter++;
            }
        }
        return counter;
    }

    public int calc2() {
        int counter = 0;
        for(Passport passport : passports){
            if(passport.isValid2()){
                counter++;
            }
        }
        return counter;
    }
}
