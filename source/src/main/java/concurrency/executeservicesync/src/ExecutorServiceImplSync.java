package concurrency.executeservicesync.src;

import concurrency.executeservicesync.api.ExecutorServiceSync;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


/**
 * Created by vicboma on 16/06/14.
 * Based on Adapter pattern.
 */
public class ExecutorServiceImplSync implements ExecutorServiceSync {

    protected java.util.concurrent.ExecutorService executorPool;

    public static ExecutorServiceSync create(java.util.concurrent.ExecutorService executorService) {
        return new ExecutorServiceImplSync(executorService);
    }

    protected ExecutorServiceImplSync(java.util.concurrent.ExecutorService executorService) {
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

    @Override
    public <T> T submit(Runnable task, T result) {
        if (task == null)
            throw new NullPointerException();

        executorPool.submit(new RunnableAdapter(task, result));
        return result;
    }

    static final class RunnableAdapter<T> implements Callable<T> {
        private Runnable task;
        private T result;

        RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
        }

        public T call() {
            task.run();
            return result;
        }
    }
}
