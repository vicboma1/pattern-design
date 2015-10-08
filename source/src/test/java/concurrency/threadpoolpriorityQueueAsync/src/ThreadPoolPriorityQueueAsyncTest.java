package concurrency.threadpoolpriorityQueueAsync.src;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ThreadPoolPriorityQueueAsyncTest {


    private ThreadPoolPriorityQueueAsync threadPoolPriorityQueueAsync;
    final private static int corePoolSize = 1;
    final private static int maximumPoolSize = 1;
    final private static int keepAliveTime = 500;
    final private static TimeUnit unit = TimeUnit.MILLISECONDS;


    @Before
    public void setUp() throws Exception {
        this.threadPoolPriorityQueueAsync = ThreadPoolPriorityQueueAsync.create(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<Runnable>());
    }

    @Test
    public void testCreate() throws Exception {
        final ThreadPoolPriorityQueueAsync expected = ThreadPoolPriorityQueueAsync.create(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<Runnable>());
        assertNotEquals("fail create", expected, this.threadPoolPriorityQueueAsync);
    }

    @Test(timeout = 5000)
    public void execute() throws Exception {
        for (int i = 0; i < 100; i++) {
            final Integer iter = i;
            threadPoolPriorityQueueAsync.addTask(() -> new Integer(iter));
        }
        new CountDownLatch(1000).await(2000, TimeUnit.MILLISECONDS);
        assertEquals("fail resolved task", new Integer(0), threadPoolPriorityQueueAsync.size());

    }
}