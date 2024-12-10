package challenges.year2015.d4;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class SolverD4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        List<String> input = List.of("bgvyzdsv");

        HashCalculator hashCalculator = new HashCalculator(input.get(0));
        //System.out.println(hashCalculator.calculateAnswer1());
        System.out.println(hashCalculator.calculateAnswer2());
    }
}
