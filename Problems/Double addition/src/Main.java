import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] ints = IntStream.generate(scanner::nextInt).limit(n).toArray();
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(ints[0]);
        if (ints.length > 1) {
            list.addLast(ints[1]);
        }
        for (int i = 2; i < ints.length; i++) {
            int diffFirst = Math.abs(list.getFirst() - ints[i]);
            int diffLast = Math.abs(list.getLast() - ints[i]);
            if (diffFirst < diffLast) {
                list.addFirst(ints[i]);
            } else {
                list.addLast(ints[i]);
            }
        }
        list.forEach(e -> System.out.print(e + " "));
    }
}