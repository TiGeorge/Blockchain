import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = IntStream.generate(scanner::nextInt).limit(n).toArray();
        int m = scanner.nextInt();

        if (m < array[0] || m > array[n - 1]) {
            System.out.println(-1);
            return;
        }
        int jumpLength = (int) Math.sqrt(n);
        int currentJump = -1;
        while (currentJump < array.length - 1) {
            int previousJump = currentJump;
            currentJump = Math.min(currentJump + jumpLength, array.length - 1);
            if (m <= array[currentJump]) {
                System.out.println(previousJump + 1 + " " + currentJump);
                break;
            }
        }
    }
}