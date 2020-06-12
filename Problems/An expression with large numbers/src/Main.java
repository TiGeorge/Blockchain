import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s+");
        BigInteger a = new BigInteger(split[0]);
        BigInteger b = new BigInteger(split[1]);
        BigInteger c = new BigInteger(split[2]);
        BigInteger d = new BigInteger(split[3]);

        BigInteger bigInteger = a.negate().multiply(b).add(c).subtract(d);
        System.out.println(bigInteger);

    }
}