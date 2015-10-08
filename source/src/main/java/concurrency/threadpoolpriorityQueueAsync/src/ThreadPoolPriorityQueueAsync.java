package concurrency.threadpoolpriorityQueueAsync.src;

import java.util.concurrent.*;

/**
 * Created by vicboma on 16/06/14.
 */
public class ThreadPoolPriorityQueueAsync {

    private ThreadPoolExecutor threadPoolExecutor;
    private CoreExecuting coreExecuting;

    public static ThreadPoolPriorityQueueAsync create(int corePoolSize, int maximumPoolSize, int keepAliveTime, TimeUnit milliseconds, LinkedBlockingQueue<Runnable> runnables) {
        return new ThreadPoolPriorityQueueAsync(
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, milliseconds, runnables));
    }

    ThreadPoolPriorityQueueAsync(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.coreExecuting = new CoreExecuting(new ConcurrentLinkedQueue<Callable>(), this.threadPoolExecutor);

    }

    public <T> void addTask(Callable<T> callable) {
        coreExecuting.addTask(callable);
    }

    public Integer size() {
        return this.coreExecuting.size();
    }
}
