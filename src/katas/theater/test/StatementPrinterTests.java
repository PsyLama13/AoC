package katas.theater.test;

import katas.theater.main.Invoice;
import katas.theater.main.Performance;
import katas.theater.main.play.Comedy;
import katas.theater.main.play.Play;
import katas.theater.main.play.Tragedy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
        Play hamlet = new Tragedy("Hamlet");
        Play asYouLikeIt = new Comedy("As You Like It");
        Play othello = new Tragedy("Othello");

        List<Performance> performances = List.of(
                new Performance(55, hamlet),
                new Performance(35, asYouLikeIt),
                new Performance(40, othello));

        Invoice invoice = new Invoice("BigCo", performances);

        var secondResult = invoice.toString();
        String expectedResult = "Statement for BigCo%n  Hamlet: $650.00 (55 seats)%n  As You Like It: $580.00 (35 seats)%n  Othello: $500.00 (40 seats)%nAmount owed is $1,730.00%nYou earned 47 credits%n".formatted();

        Assertions.assertEquals(expectedResult, secondResult);
    }
}