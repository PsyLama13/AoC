package challenges.year2020.d2;

import helper.Helper;

import java.io.IOException;
import java.util.List;

public class SolverD2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput("year2020/d2.txt");
        PasswordHelper passwordHelper = new PasswordHelper(input);
        System.out.println(passwordHelper.getNumberOfValidPws());
        System.out.println(passwordHelper.getNumberOfValidPws2());
    }
}
