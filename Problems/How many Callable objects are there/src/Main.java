import java.util.concurrent.*;


class FutureUtils {

    public static int determineCallableDepth(Callable callable) throws Exception {
        // write your code here
        Object call = callable.call();
        return call instanceof Callable ? 1 + determineCallableDepth((Callable) call) : 1;
    }
}