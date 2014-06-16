package concurrency.executeserviceasync.src;

import concurrency.executeserviceasync.api.ExecutorServiceAsync;
import creational.familyFactory.executors.src.Executors;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ExecutorServiceImplAsyncTest {

    private ExecutorServiceAsync executorServiceAsync;

    @Before
    public void setUp() throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorServiceAsync = ExecutorServiceImplAsync.create(executorService);
    }

    @Test
    public void testCreate() throws Exception {
        final ExecutorService expected = Executors.newFixedThreadPool(2);
        assertNotEquals("fail create", expected, executorServiceAsync);
    }

    @Test
    public void testShutdown() throws Exception {
        final ExecutorServiceAsync executorServiceAsyncSpy = spy(executorServiceAsync);
        executorServiceAsyncSpy.shutdown();
        verify(executorServiceAsyncSpy).shutdown();
    }

    @Test(timeout = 4000)
    public void testShutdownNow() throws Exception {

        final int expected = 0;

        for (int i = 0; i < 100; i++)
            executorServiceAsync.submit(() -> {
                System.out.println("I am execute Async");
            });

        final List<Runnable> runnables = executorServiceAsync.shutdownNow();

        assertNotEquals("fail shutdownNow", expected, runnables.size());
    }

    @Test
    public void testIsShutdown() throws Exception {
        final Boolean expected = false;
        final boolean shutdown = executorServiceAsync.isShutdown();
        assertEquals("fail shutdown", expected, shutdown);
    }

    @Test
    public void testIsTerminated() throws Exception {
        final Boolean expected = false;
        final boolean terminated = executorServiceAsync.isTerminated();
        assertEquals("fail terminated", expected, terminated);
    }

    @Test(timeout = 4000)
    public void testAwaitTermination() throws Exception {
        final Boolean expected = false;
        final Runnable task = () -> {
            System.out.println("I am execute Async");
        };
        executorServiceAsync.submit(task);
        final boolean terminated = executorServiceAsync.awaitTermination(1L, TimeUnit.MILLISECONDS);
        assertEquals("fail terminated", expected, terminated);
    }

    @Test(timeout = 4000)
    public void testSubmit() throws Exception {
        final ExecutorServiceAsync executorServiceAsyncSpy = spy(executorServiceAsync);
        final Runnable task = () -> {
            System.out.println("I am execute Async");
        };
        executorServiceAsyncSpy.submit(task);
        verify(executorServiceAsyncSpy).submit(task);
    }


    @Test(timeout = 4000)
    public void testSubmitCallable() throws Exception {
        final Integer expected = new Integer(1);

        final Callable<Integer> task = () -> {
            return new Integer(1);
        };
        final Future<Integer> submit = executorServiceAsync.submit(task);
        new CountDownLatch(2000);

        assertEquals("fail submit callable", expected, submit.get());
    }

    @Test(timeout = 4000)
    public void testSubmitRunnable() throws Exception {
        final Integer expected = new Integer(1);

        final Runnable task = () -> {
        };
        final Future<Integer> submit = executorServiceAsync.submit(task, expected);
        new CountDownLatch(2000);

        assertEquals("fail submit runnable", submit.get(), expected);
    }

    @Test(timeout = 2000)
    public void testInvokeAll() throws Exception {
        final List<Integer> results = new ArrayList() {
            {
                add(new Integer(0));
                add(new Integer(10));
                add(new Integer(100));
            }
        };

        final Collection<Callable<Integer>> collects = new ArrayList() {
            {
                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(0);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(1);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(2);
                    }
                });
            }
        };

        final List<Future<Integer>> futures = executorServiceAsync.invokeAll(collects);

        final int size = futures.size();
        for (int i = 0; i < size; i++)
            assertEquals("fail invokeAll", results.get(i), futures.get(i).get());
    }

    @Test(timeout = 3000)
    public void testInvokeAll1() throws Exception {
        final List<Integer> results = new ArrayList() {
            {
                add(new Integer(0));
                add(new Integer(10));
                add(new Integer(100));
            }
        };

        final Collection<Callable<Integer>> collects = new ArrayList() {
            {
                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(0);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(1);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(2);
                    }
                });
            }
        };

        final List<Future<Integer>> futures = executorServiceAsync.invokeAll(collects, 2000L, TimeUnit.MILLISECONDS);

        final int size = futures.size();
        for (int i = 0; i < size; i++)
            assertEquals("fail invokeAll", results.get(i), futures.get(i).get());


    }

    @Test(timeout = 4000)
    public void testInvokeAny() throws Exception {
        final Integer expected = new Integer(0);
        final List<Integer> results = new ArrayList() {
            {
                add(new Integer(0));
                add(new Integer(10));
                add(new Integer(100));
            }
        };

        final Collection<Callable<Integer>> collects = new ArrayList() {
            {
                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(0);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(1);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(2);
                    }
                });
            }
        };

        final Integer result = executorServiceAsync.invokeAny(collects);
        assertEquals("fail invokeAll", expected, result);
    }

    @Test(timeout = 4000)
    public void testInvokeAny2() throws Exception {
        final Integer expected = new Integer(0);
        final List<Integer> results = new ArrayList() {
            {
                add(new Integer(0));
                add(new Integer(10));
                add(new Integer(100));
            }
        };

        final Collection<Callable<Integer>> collects = new ArrayList() {
            {
                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(0);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(1);
                    }
                });

                add(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return results.get(2);
                    }
                });
            }
        };

        final Integer result = executorServiceAsync.invokeAny(collects, 2000L, TimeUnit.MILLISECONDS);
        assertEquals("fail invokeAll", expected, result);
    }
}
