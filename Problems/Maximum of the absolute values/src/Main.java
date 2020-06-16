import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .max().getAsInt());
    }
}