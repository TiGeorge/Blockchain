import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                if (array[j] > max) {
                    max = array[j];
                    array[j] = array[i];
                    array[i] = max;
                }
            }
            System.out.print(max + " ");
            max = Integer.MIN_VALUE;
        }
    }
}