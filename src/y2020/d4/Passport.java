package y2020.d4;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Passport {

    List<String> requiredTypes = List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
    List<String> optionalTypes = List.of("cid");
    Map<FieldType, String> passportData = new EnumMap<>(FieldType.class);

    public Passport(List<String> input) {
        for (String line : input) {
            List<String> fields = List.of(line.split(" "));
            for (String field : fields) {
                List<String> data = List.of(field.split(":"));
                FieldType type = FieldType.getEnum(data.get(0));
                String d = data.get(1);
                passportData.put(type, d);
            }
        }
    }

    public boolean isValid() {
        for (String s : requiredTypes) {
            FieldType type = FieldType.getEnum(s);
            String data = passportData.get(type);
            if (data == null || data.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid2() {
        for (String s : requiredTypes) {
            FieldType type = FieldType.getEnum(s);
            String data = passportData.get(type);
            if (data == null || data.isEmpty()) {
                return false;
            }
            boolean valid = checkValidity(type, data);
            if (!valid) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidity(FieldType type, String data) {
        return switch (type) {

            case BIRTH_YEAR -> checkBirthYear(data);
            case ISSUE_YEAR -> checkIssueYear(data);
            case EXPIRATION_YEAR -> checkExpirationYear(data);
            case HEIGHT -> checkHeight(data);
            case HAIR_COLOR -> checkHairColor(data);
            case EYE_COLOR -> checkEyeColor(data);
            case PASSPORT_ID -> checkPassportId(data);
            case COUNTRY_ID -> true;
        };
    }

    private boolean checkPassportId(String data) {
        if(data.length() != 9){
            return false;
        }
        try{
            Integer.parseInt(data);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean checkEyeColor(String data) {
        List<String> valid = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return valid.contains(data);
    }

    private boolean checkHairColor(String data) {
        List<String> validCharacters = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f");
        if(!data.startsWith("#")){
            return false;
        }

        String colorCode = data.substring(1);

        if(colorCode.length() != 6){
            return false;
        }

        for(String s : colorCode.split("")){
            if(!validCharacters.contains(s)){
                return false;
            }
        }

        return true;
    }

    private boolean checkHeight(String data) {
        String unit = data.substring(data.length() - 2);
        String numberString = data.substring(0, data.length() - 2);
        int number;
        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return false;
        }

        switch (unit) {
            case "cm" -> {
                return number >= 150 && number <= 193;
            }
            case "in" -> {
                return number >= 59 && number <= 76;
            }
            default -> {
                return false;
            }
        }
    }

    private boolean checkExpirationYear(String data) {
        return checkYear(data, 2020, 2030);
    }

    private boolean checkIssueYear(String data) {
        return checkYear(data, 2010, 2020);
    }

    private boolean checkBirthYear(String data) {
        return checkYear(data, 1920, 2002);
    }

    private boolean checkYear(String data, int min, int max) {
        if (data.length() != 4) {
            return false;
        }
        try {
            int year = Integer.parseInt(data);
            return year >= min && year <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
