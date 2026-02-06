package katas.theater.main.play;

public interface Play {
    String name();

    PlayType getPlayType();

    int getVolumeCredit(int visitors);

    int getAmount(int visitors);
}