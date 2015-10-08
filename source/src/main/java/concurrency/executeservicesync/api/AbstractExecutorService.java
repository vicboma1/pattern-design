package concurrency.executeservicesync.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vicboma on 16/06/14.
 */
public interface AbstractExecutorService {
    void shutdown();

    List<Runnable> shutdownNow();

    Boolean isShutdown();

    Boolean isTerminated();

    Boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
}
