import java.util.List;

/**
 * Class to modify
 */
class ListMultiplicator {

    /**
     * Multiplies original list provided number of times
     *
     * @param list list to multiply
     * @param n    times to multiply, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        // Add implementation here
        multiplyHelper(list, n);
    }

    private static <T> void multiplyHelper(List<T> list, int n) {
        if (n == 0) {
            list.clear();
        } else {
            List<T> copy = List.copyOf(list);
            for (int i = 2; i <= n; i++) {
                list.addAll(copy);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }
}