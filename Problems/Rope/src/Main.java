import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if ("split".equals(command[0])) {
                int ind = Integer.parseInt(command[1]);
                sb = new StringBuilder(sb.substring(ind, sb.length()) + sb.substring(0, ind));
            } else if ("reverse".equals(command[0])) {
                sb.reverse();
            }
        }
        System.out.println(sb);

    }
}