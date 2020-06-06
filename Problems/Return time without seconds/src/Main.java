import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        System.out.println(LocalTime.parse(new Scanner(System.in).nextLine()).withSecond(0));
    }
}