import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String[] s = new Scanner(System.in).nextLine().split("");
        long count = Arrays.stream(s)
                .filter(e -> "g".equalsIgnoreCase(e) || "c".equalsIgnoreCase(e))
                .count();
        System.out.println(count * 100d / s.length);
    }
}