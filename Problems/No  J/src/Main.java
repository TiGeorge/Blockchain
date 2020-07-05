import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void processIterator(String[] array) {
        // write your code here
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!next.startsWith("J")) {
                iterator.remove();
            } else {
                iterator.set(next.replaceAll("J", ""));
            }
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}