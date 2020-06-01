import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //scanner.nextLine();
        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            arrays[i] = IntStream.generate(scanner::nextInt).limit(m).toArray();
            //arrays[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[] result = {};
        for (int[] array : arrays) {
            result = merge(result, array);
        }
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] merge(int[] arrayA, int[] arrayB) {
        if (arrayA.length == 0) {
            return arrayB;
        }
        if (arrayB.length == 0) {
            return arrayA;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[arrayA.length + arrayB.length];

        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] > arrayB[j]) {
                result[k] = arrayA[i];
                i++;
            } else {
                result[k] = arrayB[j];
                j++;
            }
            k++;
        }

        while (i < arrayA.length) {
            result[k] = arrayA[i];
            i++;
            k++;
        }

        while (j < arrayB.length) {
            result[k] = arrayB[j];
            j++;
            k++;
        }

        return result;
    }
}