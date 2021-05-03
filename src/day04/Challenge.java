package day04;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class Challenge {

    private final String secretKey;
    private final boolean PRINT_DETAILS = false;

    public Challenge(String secretKey) {
        this.secretKey = secretKey;
    }

    public int solvePart1() {
        return findSecretNumber(5);
    }

    public int solvePart2() {
        return findSecretNumber(6);
    }

    public int findSecretNumber(int numberOfLeadingZeroes) {
        int secretNumber = -1;
        String leadingZeroes = new String(new char[numberOfLeadingZeroes]).replace('\0', '\u0030');

        try {
            byte[] digest;
            MessageDigest md = MessageDigest.getInstance("MD5");

            do {
                String attempt = secretKey + ++secretNumber;
                digest = md.digest(attempt.getBytes());
            } while (!bytesToHexString(digest).startsWith(leadingZeroes));

            if (PRINT_DETAILS)
                printDetails(secretNumber, digest);

        } catch (NoSuchAlgorithmException ignored) {
        }
        return secretNumber;
    }

    public static String bytesToHexString(byte[] bytes) {
        byte[] lookup = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
        byte[] hexChars = new byte[bytes.length * 2];

        for (int i = 0; i < bytes.length; i++) {
            int val = bytes[i] & 0xFF;
            hexChars[i * 2] = lookup[val >>> 4];
            hexChars[i * 2 + 1] = lookup[val & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

    private void printDetails(int secretNumber, byte[] digest) {
        System.out.printf("Secret key: %s + Number: %d -> MD5: ", secretKey, secretNumber);
        for (byte b : digest)
            System.out.printf("%02x", b);

        System.out.println();
    }
}
