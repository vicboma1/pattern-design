package creational.familyFactory.executors.src;

import org.junit.Test;

import java.util.concurrent.ExecutorService;

import static org.junit.Assert.assertNotNull;

public class ExecutorsTest {

    @Test
    public void testNewFixedThreadPool() throws Exception {

        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newFixedThreadPool(4);
            assertNotNull("fail newFixedThreadPool " + serviceSync);
        }
    }

    @Test
    public void testNewFixedThreadPool1() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newFixedThreadPool(
                    4,
                    (r) -> {
                        Thread thread = new Thread(r);
                        thread.setName("newFixedThreadPool-" + r.toString());
                        return thread;
                    }
            );
            assertNotNull("fail newFixedThreadPool " + serviceSync);
        }
    }

    @Test
    public void testNewCachedThreadPool() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newCachedThreadPool();
            assertNotNull("fail newCachedThreadPool " + serviceSync);
        }
    }

    @Test
    public void testNewCachedThreadPool1() throws Exception {

        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newCachedThreadPool(
                    (r) -> {
                        Thread thread = new Thread(r);
                        thread.setName("newCachedThreadPool-" + r.toString());
                        return thread;
                    }
            );
            assertNotNull("fail newCachedThreadPool " + serviceSync);
        }
    }

    @Test
    public void testNewSingleThreadExecutor() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newSingleThreadExecutor();
            assertNotNull("fail newSingleThreadExecutor " + serviceSync);
        }
    }

    @Test
    public void testNewSingleThreadExecutor1() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newSingleThreadExecutor(
                    (r) -> {
                        Thread thread = new Thread(r);
                        thread.setName("newSingleThreadExecutor-" + r.toString());
                        return thread;
                    }
            );
            assertNotNull("fail newSingleThreadExecutor " + serviceSync);
        }
    }

    @Test
    public void testNewWorkStealingPool() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newWorkStealingPool();
            assertNotNull("fail newWorkStealingPool " + serviceSync);
        }
    }

    @Test
    public void testNewWorkStealingPool1() throws Exception {
        for (int i = 0; i < 4; i++) {
            ExecutorService serviceSync = Executors.newWorkStealingPool(4);
            assertNotNull("fail newWorkStealingPool " + serviceSync);
        }
    }

    private void print(String str) {
        System.out.println(str);
    }
}