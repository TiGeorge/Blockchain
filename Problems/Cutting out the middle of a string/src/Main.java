import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();
        s = s.substring(0, length / 2 - 1 + length % 2) + s.substring(length / 2 + 1);
        System.out.println(s);
    }
}