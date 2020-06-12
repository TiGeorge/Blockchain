import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        LocalTime earlier1 = LocalTime.parse(scanner.next());
        LocalTime later1 = LocalTime.parse(scanner.next());
        LocalTime earlier2 = LocalTime.parse(scanner.next());
        LocalTime later2 = LocalTime.parse(scanner.next());

        System.out.println(!earlier1.isAfter(later2) && !later1.isBefore(earlier2));
    }
}