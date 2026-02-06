package katas.theater.main;

import katas.theater.main.play.Play;

import java.text.NumberFormat;
import java.util.Locale;

public record Performance(int visitors, Play play) {

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        int amount = getAmount();
        return String.format("  %s: %s (%s seats)%n", play.name(), format.format(amount / 100), visitors);
    }

    public int getVolumeCredit() {
        return play.getVolumeCredit(visitors);
    }

    public int getAmount() {
        return play.getAmount(visitors);
    }
}