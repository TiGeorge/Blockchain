import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> map = new TreeMap<>();
        for (String s : strings) {
            map.merge(s, 1, Integer::sum);
        }

        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.entrySet().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}