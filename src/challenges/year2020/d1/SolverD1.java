package challenges.year2020.d1;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2020/d1.txt");
        AccountingFixer accountingFixer = new AccountingFixer(input);

        //System.out.println(accountingFixer.calcDay1());
        System.out.println(accountingFixer.calcDay2());
    }
}
