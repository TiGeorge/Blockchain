import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int parseInt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < parseInt; i++) {
            int[] ints = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Collections.swap(list, ints[0], ints[1]);

        }
        list.forEach(e -> System.out.print(e + " "));

    }
}