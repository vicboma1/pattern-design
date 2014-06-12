package creational.singletonthreadsafe.src;

import creational.singletonthreadsafe.api.SceneManager;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class SingletonThreadSafeImplTest {

    private static final long DELAY = 1L;
    private static final long TIMER = 1L;

    @Test
    public void testSceneManager() throws Exception {
        final SceneManager<String,Scene> expected = SingletonThreadSafeImpl.sceneManager();
        final SceneManager<String,Scene> sceneManager = SingletonThreadSafeImpl.sceneManager();

        assertEquals("Not same instance",expected, sceneManager);
    }

    @Test(timeout=15000)
    public void testSceneManagerLockResolved() throws Exception {

        for (int i = 0; i < 100; i++) {
            final int index = i;
            Timer timer = new Timer("Timer_" + index);
            timer.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            assertSceneManagerThreadSafe(index);
                        }
                    },
                    DELAY,
                    TIMER
            );

           // assertSceneManagerThreadSafe(index);
        }
    }

    private void assertSceneManagerThreadSafe(Integer index) {
        final SceneManager<Integer, Scene> sceneManager = SingletonThreadSafeImpl.<Integer, Scene>sceneManager();
        putScene(sceneManager, index);
        final Scene scene = sceneManager.goTo(index);
        assertEquals("fail set", (""+index), scene.getName());
        final String newName = (""+index * 100);
        scene.setName(newName);
        assertEquals("fail set", newName, scene.getName());
    }

    private void putScene(SceneManager<Integer, Scene> sceneSceneManager, Integer index) {
        sceneSceneManager.put(
                index,
                new Scene<Integer>("" + index, null)
        );
    }
}