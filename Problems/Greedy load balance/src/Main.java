import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        int load1 = 0;
        int load2 = 0;

        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            int id = scanner.nextInt();
            int loadLevel = scanner.nextInt();
            if (load2 < load1) {
                queue2.offer(id);
                load2 += loadLevel;
            } else {
                queue1.offer(id);
                load1 += loadLevel;
            }
        }
        queue1.forEach(e -> System.out.println(e + " "));
        queue2.forEach(e -> System.out.println(e + " "));
    }
}