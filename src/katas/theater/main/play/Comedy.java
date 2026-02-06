package katas.theater.main.play;

public record Comedy(String name) implements Play {

    @Override
    public PlayType getPlayType() {
        return PlayType.COMEDY;
    }

    @Override
    public int getVolumeCredit(int visitors) {
        return Math.max(visitors - 30, 0) + visitors / 5;
    }

    @Override
    public int getAmount(int visitors) {
        int thisAmount = 30000;
        thisAmount += 300 * visitors;
        if (visitors > 20) {
            thisAmount += 10000 + 500 * (visitors - 20);
        }
        return thisAmount;
    }
}