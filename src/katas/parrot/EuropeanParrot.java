package katas.parrot;

public class EuropeanParrot implements Parrot {

    @Override
    public double getSpeed() {
        return BASE_SPEED;
    }

    @Override
    public String getCry() {
        return "Sqoork!";
    }
}
