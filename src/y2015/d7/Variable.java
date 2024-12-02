package y2015.d7;

public record Variable(String name, Integer value) {

    public boolean hasValue(){
        return value != null;
    }
}
