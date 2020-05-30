import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] array = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        boolean result = false;
        int left = 0;
        int right = array.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == array[mid]) {
                result = true;
                break;
            } else if (mid < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
