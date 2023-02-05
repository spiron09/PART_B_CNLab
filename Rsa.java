import java.math.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Rsa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(128,r);
        BigInteger q = BigInteger.probablePrime(128,r);
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        BigInteger e;
        do {
            e = BigInteger.probablePrime(128/2,r);
        } while(!e.gcd(phi).equals(BigInteger.ONE));

        BigInteger d;
        d = e.modInverse(phi);

        String plainText, cipherText;
        System.out.println("Enter text!");
        plainText = sc.nextLine();
        System.out.println(plainText);
        cipherText = encrypt(plainText, e,n);
        System.out.println(cipherText);
        String d_plainText = decrypt(cipherText, d,n);
        System.out.println(d_plainText);
    }

    private static String decrypt(String cipherText, BigInteger d, BigInteger n) {
        BigInteger bi = new BigInteger(cipherText).modPow(d,n);
        return new String(bi.toByteArray());
    }

    private static String encrypt(String plainText, BigInteger e, BigInteger n) {
        return new BigInteger(plainText.getBytes()).modPow(e,n).toString();
    }
}
