package katas.parrot;

public class AfricanParrot implements Parrot {

    private final int numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, BASE_SPEED - LOAD_FACTOR * numberOfCoconuts);
    }

    @Override
    public String getCry() {
        return "Sqaark!";
    }
}
