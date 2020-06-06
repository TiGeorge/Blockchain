import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        LocalTime time = LocalTime.ofSecondOfDay(new Scanner(System.in).nextInt());
        System.out.println(time);
    }
}