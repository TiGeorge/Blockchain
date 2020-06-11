import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int k = scanner.nextInt();

        if (m == k) {
            System.out.println(0);
            return;
        }
        double d = m;
        int count = 0;
        do {
            d = d + (double) p / 100 * d;
            count++;
        } while (d < k);
        System.out.println(count);
    }
}