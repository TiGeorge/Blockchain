import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        char[] chars = new Scanner(System.in).nextLine().toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        char last = chars[0];
        int count = 0;
        for (char current : chars) {
            if (current == last) {
                count++;
            } else {
                stringBuilder.append(last).append(count);
                last = current;
                count = 1;
            }
        }
        stringBuilder.append(last).append(count);
        System.out.println(stringBuilder.toString());
    }
}
