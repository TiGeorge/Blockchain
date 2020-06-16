import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }
}