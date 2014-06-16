package concurrency.executepoolsync.src;

import concurrency.executepoolsync.api.ExecutorServiceSync;
import creational.familyFactory.executors.src.Executors;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ExecutorPoolImplSyncTest {

    private ExecutorServiceSync executorServiceSync;

    @Before
    public void setUp() throws Exception {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorServiceSync = ExecutorPoolImplSync.create(executorService);
    }

    @Test
    public void testShutdown() throws Exception {
        final ExecutorServiceSync executorServiceSyncSpy = spy(executorServiceSync);
        executorServiceSyncSpy.shutdown();
        verify(executorServiceSyncSpy).shutdown();
    }

    @Test(timeout = 3000)
    public void testShutdownNow() throws Exception {

        final int expected = 0;

        for (int i = 0; i < 100; i++)
            executorServiceSync.submit(() -> {
            });

        new CountDownLatch(2000);
        final List<Runnable> runnables = executorServiceSync.shutdownNow();

        assertEquals("fail shutdownNow", expected, runnables.size());
    }

    @Test
    public void testIsShutdown() throws Exception {
        final Boolean expected = false;
        final boolean shutdown = executorServiceSync.isShutdown();
        assertEquals("fail shutdown", expected, shutdown);
    }

    @Test
    public void testIsTerminated() throws Exception {
        final Boolean expected = false;
        final boolean terminated = executorServiceSync.isTerminated();
        assertEquals("fail terminated", expected, terminated);
    }

    @Test
    public void testAwaitTermination() throws Exception {
        final Boolean expected = false;
        final Runnable task = () -> {
        };
        executorServiceSync.submit(task);
        final boolean terminated = executorServiceSync.awaitTermination(1L, TimeUnit.MILLISECONDS);
        assertEquals("fail terminated", expected, terminated);
    }

    @Test
    public void testSubmit() throws Exception {
        final ExecutorServiceSync executorServiceSyncSpy = spy(executorServiceSync);
        final Runnable task = () -> {
        };
        executorServiceSyncSpy.submit(task);
        verify(executorServiceSyncSpy).submit(task);
    }
}