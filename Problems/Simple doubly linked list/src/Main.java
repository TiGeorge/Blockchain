import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if ("addFirst".equals(command[0])) {
                list.addFirst(Integer.parseInt(command[1]));
            } else if ("addLast".equals(command[0])) {
                list.addLast(Integer.parseInt(command[1]));
            } else if ("removeFirst".equals(command[0])) {
                list.removeFirst();
            } else if ("removeLast".equals(command[0])) {
                list.removeLast();
            } else if ("reverse".equals(command[0])) {
                Collections.reverse(list);
            }
        }
        list.forEach(integer -> System.out.print(integer + " "));
    }
}