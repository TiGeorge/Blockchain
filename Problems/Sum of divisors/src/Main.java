import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int[] params = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(IntStream.rangeClosed(params[0], params[1])
                .filter(i -> i % params[2] == 0 || i % params[3] == 0).sum());
    }
}