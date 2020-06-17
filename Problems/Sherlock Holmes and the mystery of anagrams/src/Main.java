import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] w1 = scanner.nextLine().toLowerCase().toCharArray();
        char[] w2 = scanner.nextLine().toLowerCase().toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        System.out.println(Arrays.compare(w1, w2) == 0 ? "yes" : "no");
    }
}