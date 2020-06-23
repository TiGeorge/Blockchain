import java.util.Arrays;
import java.util.Scanner;

class Main {

    static int count = 0;

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        insertionSort(arr);
        System.out.println(count);
    }

    public static int[] insertionSort(int[] array) {
        /* iterating over elements in the unsorted part */
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // take the next element
            int j = i - 1;

            /* find a suitable position to insert and shift elements to the right */
            boolean isShift = false;
            while (j >= 0 && array[j] < elem) {
                if (!isShift) {
                    isShift = true;
                    count++;
                }
                array[j + 1] = array[j]; // shifting
                j--;
            }
            array[j + 1] = elem; // insert the element in the found position in the sorted part
        }

        return array;
    }
}