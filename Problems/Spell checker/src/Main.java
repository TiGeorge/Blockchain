import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int d = Integer.parseInt(scanner.nextLine());
        Set<String> dictionary = Stream.generate(scanner::nextLine).limit(d)
                .map(String::toLowerCase).collect(Collectors.toSet());
        int l = Integer.parseInt(scanner.nextLine());
        Set<String> words = Stream.generate(scanner::nextLine).limit(l)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(String::toLowerCase).collect(Collectors.toSet());

        words.removeAll(dictionary);
        words.forEach(System.out::println);
    }
}