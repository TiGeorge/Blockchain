import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code
        String[] strings = new Scanner(System.in).nextLine().split("\\s+");
        int max = Arrays.stream(strings).mapToInt(String::length).max().getAsInt();
        System.out.println(Arrays.stream(strings).filter(s -> s.length() == max).findFirst().get());
    }
}