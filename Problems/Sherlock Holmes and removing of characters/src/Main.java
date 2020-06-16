import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(scanner.nextLine().toLowerCase().split(""))
                .forEach(letter -> map.merge(letter, 1, Integer::sum));
        Arrays.stream(scanner.nextLine().toLowerCase().split(""))
                .forEach(letter -> map.merge(letter, -1, Integer::sum));

        System.out.println(map.values().stream().mapToInt(Math::abs).sum());

    }
}