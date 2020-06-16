import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String[] split = new Scanner(System.in).nextLine().split("");
        LinkedList<String> stack = new LinkedList<>();
        boolean result = true;
        for (String s : split) {
            if ("[".equals(s) || "(".equals(s) || "{".equals(s)) {
                stack.push(s);
            } else if (stack.isEmpty()) {
                result = false;
                break;
            } else if ("]".equals(s)) {
                if (!"[".equals(stack.pop())) {
                    result = false;
                    break;
                }
            } else if (")".equals(s)) {
                if (!"(".equals(stack.pop())) {
                    result = false;
                    break;
                }
            } else if ("}".equals(s)) {
                if (!"{".equals(stack.pop())) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result && stack.isEmpty());
    }
}