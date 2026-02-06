package katas.theater.main;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public final class Invoice {
    private final String customer;
    private final List<Performance> performances;

    private final Integer amount;
    private final Integer volumeCredit;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;

        amount = performances.stream().mapToInt(Performance::getAmount).sum();
        volumeCredit = performances.stream().mapToInt(Performance::getVolumeCredit).sum();
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder sb = new StringBuilder(String.format("Statement for %s%n", customer));
        for (Performance performance : performances) {
            sb.append(performance.toString());
        }
        sb.append(String.format("Amount owed is %s%n", format.format(amount / 100)));
        sb.append(String.format("You earned %s credits%n", volumeCredit));
        return sb.toString();
    }
}