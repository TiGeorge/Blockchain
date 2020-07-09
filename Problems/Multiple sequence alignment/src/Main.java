import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> words = Stream.generate(scanner::nextLine).limit(3).collect(Collectors.toList());

        int max = Math.max(Math.max(words.get(1).length(), words.get(2).length()), words.get(0).length());
        if (words.get(1).length() < max) {
            if (words.get(1).length() == max) {
                Collections.swap(words, 0, 1);
                Alignment alignment1no2 = editDistanceAlignment(words.get(0), words.get(1));
                Alignment alignment2no3 = editDistanceAlignment(words.get(1), words.get(2));
                System.out.println(getTripleAlignmentScore(alignment1no2, alignment2no3));
                System.out.println(alignment1no2.target);
                System.out.println(alignment1no2.source);
                System.out.println(alignment2no3.target);
            } else {
                Collections.swap(words, 1, 2);
                Alignment alignment1no2 = editDistanceAlignment(words.get(0), words.get(1));
                Alignment alignment2no3 = editDistanceAlignment(words.get(1), words.get(2));
                System.out.println(getTripleAlignmentScore(alignment1no2, alignment2no3));
                System.out.println(alignment1no2.source);
                System.out.println(alignment2no3.target);
                System.out.println(alignment2no3.source);
            }
        } else {
            Alignment alignment1no2 = editDistanceAlignment(words.get(0), words.get(1));
            Alignment alignment2no3 = editDistanceAlignment(words.get(1), words.get(2));
            System.out.println(getTripleAlignmentScore(alignment1no2, alignment2no3));
            System.out.println(alignment1no2.source);
            System.out.println(alignment2no3.source);
            System.out.println(alignment2no3.target);
        }


    }

    private static int getTripleAlignmentScore(Alignment alignment1, Alignment alignment2) {

        String s1 = alignment1.source;
        String s2 = alignment1.target;
        String s3 = alignment2.target;

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == '-' || s2.charAt(i) == '-') {
                    count += 2;
                } else {
                    count++;
                }
            }
            if (s2.charAt(i) != s3.charAt(i)) {
                if (s2.charAt(i) == '-' || s3.charAt(i) == '-') {
                    count += 2;
                } else {
                    count++;
                }
            }
            if (s1.charAt(i) != s3.charAt(i)) {
                if (s1.charAt(i) == '-' || s3.charAt(i) == '-') {
                    count += 2;
                } else {
                    count++;
                }
            }
        }

        return count;
    }

    public static int match(char a, char b) {
        return (a == b) ? 0 : 1;
    }

    public static Alignment editDistanceAlignment(String s, String t) {
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

        return reconstructAlignment(d, s, t);
    }

    public static Alignment reconstructAlignment(int[][] d, String s, String t) {
        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && d[i][j] == d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1))) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                i -= 1;
                j -= 1;
            } else if (j > 0 && d[i][j] == d[i][j - 1] + 1) {
                ssBuilder.append("-");
                ttBuilder.append(t.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && d[i][j] == d[i - 1][j] + 1) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            } else if (j > 0 && d[i][j] == d[i][j - 1] + 2) {
                ssBuilder.append("-");
                ttBuilder.append(t.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && d[i][j] == d[i - 1][j] + 2) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();

        return new Alignment(d[s.length()][t.length()], ss, tt);
    }
}

class Alignment {
    public int editDistance;
    public String source;
    public String target;

    public Alignment(int editDist, String source, String target) {
        this.editDistance = editDist;
        this.source = source;
        this.target = target;
    }
}