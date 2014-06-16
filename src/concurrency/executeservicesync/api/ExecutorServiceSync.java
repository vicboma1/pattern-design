package concurrency.executeservicesync.api;

/**
 * Created by vicboma on 16/06/14.
 */
public interface ExecutorServiceSync extends AbstractExecutorService {
    void submit(Runnable task);
}
