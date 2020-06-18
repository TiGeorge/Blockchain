import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if ("add".equals(command[0])) {
                list.add(Integer.parseInt(command[1]));
            } else if ("remove".equals(command[0])) {
                list.remove(Integer.parseInt(command[1]));
            } else if ("size".equals(command[0])) {
                System.out.println(list.size());
            } else if ("isempty".equals(command[0])) {
                System.out.println(list.isEmpty());
            } else if ("contains".equals(command[0])) {
                System.out.println(list.contains(Integer.parseInt(command[1])));
            } else if ("indexof".equals(command[0])) {
                System.out.println(list.indexOf(Integer.parseInt(command[1])));
            } else if ("clear".equals(command[0])) {
                list.clear();
            }
        }
    }
}