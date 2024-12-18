package challenges.year2015.d4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCalculator {

    String secretKey;

    public HashCalculator(String secretKey) {
        this.secretKey = secretKey;
    }

    int calculateAnswer1() throws NoSuchAlgorithmException {

        int addingNumber = 0;

        while (true) {
            String checkString = secretKey + addingNumber;
            String hash = doHashing(checkString);

            if (isHashValidForNZeroes(hash, 5)) {
                return addingNumber;
            }

            addingNumber++;
        }
    }

    int calculateAnswer2() throws NoSuchAlgorithmException {
        int addingNumber = 0;

        while (true) {
            String checkString = secretKey + addingNumber;
            String hash = doHashing(checkString);

            if (isHashValidForNZeroes(hash, 6)) {
                return addingNumber;
            }

            addingNumber++;
        }
    }

    private String doHashing(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(s.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);

        StringBuilder hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }
        return hashText.toString();
    }

    private boolean isHashValidForNZeroes(String s, int numOfZeroes) {
        StringBuilder checker = new StringBuilder();
        checker.append("0".repeat(Math.max(0, numOfZeroes)));

        if (s.startsWith(checker.toString())) {
            Character leadingChar = s.charAt(5);
            try {
                int num = Integer.parseInt(String.valueOf(leadingChar));
                if (num > 0) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }
}
