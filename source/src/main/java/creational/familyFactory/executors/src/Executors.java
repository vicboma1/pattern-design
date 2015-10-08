package creational.familyFactory.executors.src;

import java.util.concurrent.*;

/**
 * Created by vicboma on 16/06/14.
 * Based on Factory / Adapter pattern.
 */
public class Executors {

    public static final long KEEP_ALIVE_TIME = 0L;
    public static final int CORE_POOL_SIZE = 0;
    public static final long KEEP_ALIVE_TIME_CACHED_POOL = 60L;

    public static ExecutorService newFixedThreadPool(Integer nThreads) {
        return getNewFixedThreadPool(nThreads, java.util.concurrent.Executors.defaultThreadFactory());
    }

    public static ExecutorService newFixedThreadPool(Integer nThreads, ThreadFactory threadFactory) {
        return getNewFixedThreadPool(nThreads, threadFactory);
    }

    public static ExecutorService newCachedThreadPool() {
        return getNewCachedThreadPool(java.util.concurrent.Executors.defaultThreadFactory());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return getNewCachedThreadPool(threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return java.util.concurrent.Executors.newSingleThreadExecutor();
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return java.util.concurrent.Executors.newCachedThreadPool(threadFactory);
    }

    public static ExecutorService newWorkStealingPool() {
        return new ForkJoinPool(Runtime.getRuntime().availableProcessors(), ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    public static ExecutorService newWorkStealingPool(Integer availableProcessors) {
        return new ForkJoinPool(availableProcessors, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }

    private static ThreadPoolExecutor getNewFixedThreadPool(Integer nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
    }

    private static ExecutorService getNewCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, Integer.MAX_VALUE, KEEP_ALIVE_TIME_CACHED_POOL, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory);
    }

}
