package concurrency.executeservicesync.src;

import concurrency.executeservicesync.api.ExecutorServiceSync;
import creational.familyFactory.executors.src.Executors;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ExecutorServiceImplSyncTest {

    private ExecutorServiceSync executorServiceSync;

    @Before
    public void setUp() throws Exception {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorServiceSync = ExecutorServiceImplSync.create(executorService);
    }

    @Test
    public void testShutdown() throws Exception {
        final ExecutorServiceSync executorServiceSyncSpy = spy(executorServiceSync);
        executorServiceSyncSpy.shutdown();
        verify(executorServiceSyncSpy).shutdown();
    }

    @Test
    public void testShutdownNow() throws Exception {
        final int expected = 0;

        IntStream stream = IntStream.range(0, 100);
        stream
                .sequential()
                .forEach(
                        e ->
                                executorServiceSync.submit(() -> {
                                            System.out.println("I am execute");
                                        }
                                )
                );

        final List<Runnable> runnables = executorServiceSync.shutdownNow();

        assertNotEquals("fail shutdownNow", expected, runnables.size());
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
            System.out.println("I am execute");
        };
        executorServiceSync.submit(task);
        final boolean terminated = executorServiceSync.awaitTermination(1L, TimeUnit.MILLISECONDS);
        assertEquals("fail terminated", expected, terminated);
    }

    @Test
    public void testSubmit() throws Exception {
        final ExecutorServiceSync executorServiceSyncSpy = spy(executorServiceSync);
        final Runnable task = () -> {
            System.out.println("I am execute");
        };
        executorServiceSyncSpy.submit(task);
        verify(executorServiceSyncSpy).submit(task);
    }

    @Test
    public void testSubmitCallableVerify() throws Exception {
        final ExecutorServiceSync executorServiceSyncSpy = spy(executorServiceSync);
        final Boolean expectedResult = true;
        final Runnable task = () -> {
            System.out.println("I am execute");
        };
        executorServiceSyncSpy.submit(task, expectedResult);
        verify(executorServiceSyncSpy).submit(task, expectedResult);
    }

    @Test
    public void testSubmitCallable() throws Exception {
        final Boolean expectedResult = true;
        final Runnable task = () -> {
            System.out.println("I am execute");
        };
        final Boolean submit = executorServiceSync.submit(task, expectedResult);
        assertEquals("fail submit", expectedResult, submit);
    }
}