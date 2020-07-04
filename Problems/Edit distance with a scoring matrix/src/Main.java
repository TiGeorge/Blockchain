import java.util.*;

public class Main {

    private static Map<String, Integer> letters = new HashMap<>() {
        {
            put("a", 0);
            put("s", 1);
            put("d", 2);
            put("b", 3);
            put("n", 4);
            put("m", 5);
        }
    };

    private static int[][] scoringMatrix = {
            {0, 1, 2, 5, 6, 7},
            {1, 0, 1, 5, 6, 7},
            {2, 1, 0, 5, 6, 7},
            {5, 6, 7, 0, 1, 2},
            {5, 6, 7, 1, 0, 1},
            {5, 6, 7, 2, 1, 0}
    };

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String inputWord = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        List<String> base = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            base.add(scanner.nextLine());
        }

        int minDist = Integer.MAX_VALUE;
        int indexOfMin = 0;
        for (int i = 0; i < base.size(); i++) {
            int dist = editDistance(base.get(i), inputWord);
            if (dist < minDist) {
                minDist = dist;
                indexOfMin = i;
            }
        }

        System.out.println(minDist);
        System.out.println(base.get(indexOfMin));
    }

    private static int getScore(String l1, String l2) {
        return scoringMatrix[letters.get(l1)][letters.get(l2)];
    }

    public static int match(char a, char b) {

        int score = getScore(Character.toString(a), Character.toString(b));

        return (a == b) ? 0 : score;
    }

    public static int editDistance(String s, String t) {

        int[][] d = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < t.length() + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = d[i][j - 1] + 1;
                int delCost = d[i - 1][j] + 1;
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }

        return d[s.length()][t.length()];
    }
}