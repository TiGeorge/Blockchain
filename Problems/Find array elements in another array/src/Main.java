import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] a = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        scanner.nextLine();
        int[] b = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int value : b) {
            int search = -1;
            int left = 0;
            int right = a.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2; // the index of the middle element

                if (value == a[mid]) {
                    search = mid;
                    break;// the element is found, return its index
                } else if (value < a[mid]) {
                    right = mid - 1; // go to the left subarray
                } else {
                    left = mid + 1;  // go the the right subarray
                }
            }
            // the element is not found
            System.out.println((search == -1 ? -1 : search + 1) + " ");
        }
    }

}