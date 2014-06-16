package concurrency.executepoolsync.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vicboma on 16/06/14.
 */
public interface ExecutorServiceSync {

    void shutdown();

    List<java.lang.Runnable> shutdownNow();

    boolean isShutdown();

    boolean isTerminated();

    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;

    // <T> Future<T> submit(Callable<T> task);

    void submit(Runnable task);

    //  Future<?> submit(java.lang.Runnable task);

    //  <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException;

    //  <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException;

    // <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;

    // <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
