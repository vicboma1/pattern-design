package concurrency.executeservicesync.src;

import concurrency.executeservicesync.api.ExecutorServiceSync;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by vicboma on 16/06/14.
 * Based on Adapter pattern.
 */
public class ExecutorServiceImplSync implements ExecutorServiceSync {

    private java.util.concurrent.ExecutorService executorPool;

    public static ExecutorServiceSync create(java.util.concurrent.ExecutorService executorService) {
        return new ExecutorServiceImplSync(executorService);
    }

    ExecutorServiceImplSync(java.util.concurrent.ExecutorService executorService) {
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
    public void submit(Runnable task) {
        executorPool.execute(task);
    }
}
