import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int n = new Scanner(System.in).nextInt();
        int[] array = new int[n];

        int jumpLength = (int) Math.sqrt(array.length);
        int currentJump = 0;
        int countJump = 1;
        array[currentJump] = countJump;

        while (currentJump < n - 1) {
            int previousJump = currentJump;
            currentJump = Math.min(currentJump + jumpLength, n - 1);
            array[currentJump] = ++countJump;
            int traversCount = countJump;
            for (int i = currentJump - 1; i > previousJump; i--) {
                array[i] = ++traversCount;
            }
        }

        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}