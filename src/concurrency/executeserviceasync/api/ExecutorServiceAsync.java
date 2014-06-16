package concurrency.executeserviceasync.api;

import concurrency.executeservicesync.api.AbstractExecutorService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by vicboma on 16/06/14.
 */
public interface ExecutorServiceAsync extends AbstractExecutorService {

    <T> Future<T> submit(Callable<T> task);

    <T> Future<T> submit(Runnable task, T result);

    <T> Future<T> submit(Runnable task);

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException;

    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, Long timeout, TimeUnit unit) throws InterruptedException;

    <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;

    <T> T invokeAny(Collection<? extends Callable<T>> tasks, Long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}
