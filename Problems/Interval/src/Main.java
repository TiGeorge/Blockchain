import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int i = new Scanner(System.in).nextInt();

        System.out.println(i > -15 && i <= 12 ||
                i > 14 & i < 17 ||
                i >= 19 ? "True" : "False");
    }
}