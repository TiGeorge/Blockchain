import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = IntStream.generate(scanner::nextInt).limit(n).toArray();

        selectionSort(array);

        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (i % 2 == 0) {
                    if (array[j] > array[index]) {
                        index = j;
                    }
                } else {
                    if (array[j] < array[index]) {
                        index = j;
                    }
                }
            }

            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }

        return array;
    }
}