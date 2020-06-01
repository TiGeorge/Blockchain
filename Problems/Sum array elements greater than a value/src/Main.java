import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String line = scanner.nextLine();
        int n = scanner.nextInt();
        System.out.println(Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).filter(e -> e > n).sum());
    }
}