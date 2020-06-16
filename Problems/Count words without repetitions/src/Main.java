import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(Stream.generate(scanner::nextLine)
                .limit(n)
                .map(String::toLowerCase)
                .map(l -> l.split("\\s+"))
                .flatMap(Arrays::stream)
                .distinct()
                .count());
    }
}
