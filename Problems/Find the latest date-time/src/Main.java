import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println(IntStream.range(0, Integer.parseInt(scanner.nextLine()))
                .mapToObj(i -> scanner.nextLine())
                .map(LocalDateTime::parse)
                .max(LocalDateTime::compareTo)
                .get());
    }
}