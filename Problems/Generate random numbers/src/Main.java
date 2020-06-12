import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random(a + b);

        System.out.println(IntStream
                .generate(() -> random.nextInt(b - a + 1) + a)
                .limit(n)
                .sum());
    }
}