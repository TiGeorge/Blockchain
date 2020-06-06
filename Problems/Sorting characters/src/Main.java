import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = IntStream.generate(() -> scanner.next().charAt(0)).limit(n).toArray();
        countingSort(array);
        Arrays.stream(array).forEach(e -> System.out.print((char) e + " "));
    }

    public static int[] countingSort(int[] numbers) {
        int maxVal = Arrays.stream(numbers).max().getAsInt(); // we suppose the maximum is 10
        int k = maxVal + 1; // the length of the array containing counts
        int[] counts = new int[k]; // it stores 11 zeros with indexes from 0 to k-1
        /* in this loop we count distinct numbers in the input array */
        for (int number : numbers) {
            counts[number]++;
        }
        int pos = 0; // a position in the numbers array
        /* in this loop we modify the input array to make it sorted */
        for (int num = 0; num < k; num++) { // get the next element
            int count = counts[num]; // get the count of the element
            while (count > 0) {
                numbers[pos] = num; // write it in the numbers array
                pos++;
                count--;
            }
        }
        return numbers;
    }
}
