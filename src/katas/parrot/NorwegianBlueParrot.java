package katas.parrot;

public record NorwegianBlueParrot(double voltage, boolean isNailed) implements Parrot {
    private static final Double NORWEGIAN_BLUE_MIN_SPEED = 24.0;

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