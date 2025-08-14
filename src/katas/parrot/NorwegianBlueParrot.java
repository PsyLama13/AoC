package katas.parrot;

public class NorwegianBlueParrot implements Parrot {
    private final double voltage;
    private final boolean isNailed;
    private static final Double NORWEGIAN_BLUE_MIN_SPEED = 24.0;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return isNailed ? 0 : getBaseSpeed();
    }

    @Override
    public String getCry() {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }

    private double getBaseSpeed() {
        return Math.min(NORWEGIAN_BLUE_MIN_SPEED, voltage * BASE_SPEED);
    }
}