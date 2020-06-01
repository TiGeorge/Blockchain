import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int finish = array.length;
        int count = 0;
        while (finish-- > 1) {
            for (int i = 0; i < finish; i++) {
                if (array[i] < array[i + 1]) {
                    array[i] ^= array[i + 1];
                    array[i + 1] ^= array[i];
                    array[i] ^= array[i + 1];
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}