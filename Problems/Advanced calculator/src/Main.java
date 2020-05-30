import java.util.Arrays;
import java.util.stream.IntStream;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        IntStream values = Arrays.stream(Arrays.copyOfRange(args, 1, args.length))
                .mapToInt(Integer::parseInt);
        if ("MAX".equals(operator)) {
            System.out.println(values.max().getAsInt());
        } else if ("MIN".equals(operator)) {
            System.out.println(values.min().getAsInt());
        } else if ("SUM".equals(operator)) {
            System.out.println(values.sum());
        }
    }
}
