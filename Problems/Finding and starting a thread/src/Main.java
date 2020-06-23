import java.util.Arrays;
import java.util.Optional;

class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        Optional<Thread> first = Arrays.stream(threads)
                .filter(thread -> thread.getState() == Thread.State.NEW)
                .findFirst();
        if (first.isPresent()) {
            Thread thread = first.get();
            thread.start();
            thread.join();
        }
    }
}