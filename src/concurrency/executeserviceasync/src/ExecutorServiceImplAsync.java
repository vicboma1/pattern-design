package concurrency.executeserviceasync.src;

import concurrency.executeserviceasync.api.ExecutorServiceAsync;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


/**
 * Created by vicboma on 16/06/14.
 * Based on Adapter pattern.
 */
public class ExecutorServiceImplAsync implements ExecutorServiceAsync {

    private java.util.concurrent.ExecutorService executorPool;

    public static ExecutorServiceAsync create(java.util.concurrent.ExecutorService executorService) {
        return new ExecutorServiceImplAsync(executorService);
    }

    ExecutorServiceImplAsync(java.util.concurrent.ExecutorService executorService) {
        this.executorPool = executorService;
    }

    @Override
    public void shutdown() {
        executorPool.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return executorPool.shutdownNow();
    }

    @Override
    public Boolean isShutdown() {
        return executorPool.isShutdown();
    }

    @Override
    public Boolean isTerminated() {
        return executorPool.isTerminated();
    }

    @Override
    public Boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorPool.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executorPool.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executorPool.submit(task, result);
    }

    @Override
    public <T> Future<T> submit(Runnable task) {
        final Future<?> submit = executorPool.submit(task);
        return (Future<T>) submit;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executorPool.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, Long timeout, TimeUnit unit) throws InterruptedException {
        return executorPool.invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executorPool.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, Long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return executorPool.invokeAny(tasks, timeout, unit);
    }

}
