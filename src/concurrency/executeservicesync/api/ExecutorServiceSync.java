package concurrency.executeservicesync.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vicboma on 16/06/14.
 */
public interface ExecutorServiceSync {

    void shutdown();

    List<java.lang.Runnable> shutdownNow();

    Boolean isShutdown();

    Boolean isTerminated();

    Boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

    void submit(Runnable task);
}