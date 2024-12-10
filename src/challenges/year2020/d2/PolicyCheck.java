package challenges.year2020.d2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolicyCheck {

    int minAmount;
    int maxAmount;
    String character;
    String password;

    public PolicyCheck(int minAmount, int maxAmount, String character, String password) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.character = character;
        this.password = password;
    }

    public boolean isValid() {
        Pattern pattern = Pattern.compile(character);
        Matcher matcher = pattern.matcher(password);

        int count = 0;

        while (matcher.find()) {
            count++;
        }
        return count >= minAmount && count <= maxAmount;
    }

    public boolean isValid2() {
        int count = 0;
        if(Character.toString(password.charAt(minAmount-1)).equals(character)){
            count++;
        }

        if(Character.toString(password.charAt(maxAmount-1)).equals(character)){
            count++;
        }
        return count == 1;
    }
}
