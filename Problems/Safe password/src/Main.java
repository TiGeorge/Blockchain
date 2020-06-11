import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String password = new Scanner(System.in).nextLine();
        System.out.println(password.length() >= 12
                && password.matches(".*\\d.*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[A-Z].*") ? "YES" : "NO");
    }
}