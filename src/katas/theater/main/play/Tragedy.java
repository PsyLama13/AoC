package katas.theater.main.play;

public record Tragedy(String name) implements Play {

    @Override
    public PlayType getPlayType() {
        return PlayType.TRAGEDY;
    }

    @Override
    public int getVolumeCredit(int visitors) {
        return Math.max(visitors - 30, 0);
    }

    @Override
    public int getAmount(int visitors) {
        int thisAmount = 40000;
        if (visitors > 30) {
            thisAmount += 1000 * (visitors - 30);
        }
        return thisAmount;
    }
}