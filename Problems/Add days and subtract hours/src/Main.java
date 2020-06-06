import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("\\s+");
        System.out.println(LocalDateTime.parse(split[0])
                .plusDays(Integer.parseInt(split[1])).minusHours(Integer.parseInt(split[2])));
    }
}