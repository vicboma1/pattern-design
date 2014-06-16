package concurrency.threadpoolpriorityQueueAsync.src;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by vicboma on 16/06/14.
 */
public class CoreExecuting {

    public static final int DELAY = 0;
    public static final int PERIOD = 10;

    private Timer timer;
    private Queue<Callable> priorityQueue;
    private int resolved = 0;

    public CoreExecuting(Queue<Callable> priorityQueue, ThreadPoolExecutor threadPoolExecutor) {
        this.priorityQueue = priorityQueue;
        final Queue<Callable> _priorityQueue = this.priorityQueue;
        final ThreadPoolExecutor _threadPoolExecutor = threadPoolExecutor;
        this.timer = new Timer("ThreadPool - PriorityQueueAsync", true);
        this.timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {

                        final Queue<Callable> priorityQueue = _priorityQueue;
                        if (priorityQueue.isEmpty()) {
                            sleep(100);
                            return;
                        }

                        priorityQueue
                                .stream()
                                .parallel()
                                .forEach(element -> {
                                            try {
                                                priorityQueue.poll();
                                                _threadPoolExecutor.submit(element);
                                            } catch (RejectedExecutionException e) {
                                                System.out.println("Taks Rejected " + (resolved++));
                                                priorityQueue.add(element);
                                            } finally {
                                                System.out.println("Taks Resolved " + (resolved++));
                                                sleep(5);
                                            }
                                        }
                                );
                    }

                    private void sleep(Integer time) {
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                DELAY,
                PERIOD);
    }

    public <T> void addTask(Callable<T> callable) {
        priorityQueue.add(callable);
    }

    public Integer size() {
        return priorityQueue.size();
    }
}
