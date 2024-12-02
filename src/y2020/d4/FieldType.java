package y2020.d4;

public enum FieldType {
    BIRTH_YEAR("byr"),
    ISSUE_YEAR("iyr"),
    EXPIRATION_YEAR("eyr"),
    HEIGHT("hgt"),
    HAIR_COLOR("hcl"),
    EYE_COLOR("ecl"),
    PASSPORT_ID("pid"),
    COUNTRY_ID("cid");

    private final String value;

    FieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FieldType getEnum(String s){
        for(FieldType t : FieldType.values()){
            if(t.value.equals(s)){
                return t;
            }
        }
        throw new IllegalStateException();
    }
}
