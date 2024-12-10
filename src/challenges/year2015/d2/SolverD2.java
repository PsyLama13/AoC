package challenges.year2015.d2;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2015/d2.txt");

        GiftTracker giftTracker = new GiftTracker(input);
        System.out.println(giftTracker.calculateNumberOfGiftedHomes());
        System.out.println(giftTracker.calculateNumberOfGiftedHomesY2());
    }
}
