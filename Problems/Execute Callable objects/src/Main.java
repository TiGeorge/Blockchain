import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        // write your code here
        Collections.reverse(items);
        return items.stream().mapToInt(future -> {
            try {
                return future.get().call();
            } catch (Exception e) {
                return 0;
            }
        }).sum();
    }

}