import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String[] split = new Scanner(System.in).nextLine().split("\\s+");
        LocalDate date = LocalDate.parse(split[0]);
        int n = Integer.parseInt(split[1]);
        System.out.println(date.plusDays(n).getYear() > date.getYear());
    }
}