import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static int[] countingSort(int[] numbers) {
        int maxVal = 20 + 10; // we suppose the maximum is 10
        int k = maxVal + 1; // the length of the array containing counts
        int[] counts = new int[k]; // it stores 11 zeros with indexes from 0 to k-1

        /* in this loop we count distinct numbers in the input array */
        for (int number : numbers) {
            counts[number + 10]++;
        }

        int pos = 0; // a position in the numbers array

        /* in this loop we modify the input array to make it sorted */
        for (int num = 0; num < k; num++) { // get the next element
            int count = counts[num]; // get the count of the element
            while (count > 0) {
                numbers[pos] = num - 10; // write it in the numbers array
                pos++;
                count--;
            }
        }

        return numbers;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String elements = scanner.nextLine();
        final int[] array = Arrays.stream(elements.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        countingSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}