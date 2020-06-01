import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int maxOperations = 0;
        int numberOfArray = 0;
        for (int i = 0; i < n; i++) {
            int numberOperations = selectionSort(IntStream.generate(scanner::nextInt).limit(m).toArray());
            if (numberOperations > maxOperations) {
                maxOperations = numberOperations;
                numberOfArray = i + 1;
            }
        }
        System.out.println(numberOfArray);
    }

    public static int selectionSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min
            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                    count++;
                }
            }
            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
            count++;
        }
        return count;
    }
}