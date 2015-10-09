package creational.multitondoublecheckedlocking.src;

import creational.multitondoublecheckedlocking.api.MultitonDoubleCheckedLocking;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ManagerContainerTest {

    private static final long DELAY = 1L;
    private static final long TIMER = 1L;

    @Test
    public void testGetInstance() throws Exception {
        final MultitonDoubleCheckedLocking audioContainer = ManagerContainer.getInstance(AudioContainer.class);
        final MultitonDoubleCheckedLocking menuContainer = ManagerContainer.getInstance(MenuContainer.class);
        final MultitonDoubleCheckedLocking sceneContainer = ManagerContainer.getInstance(SceneContainer.class);

        assertEquals("fail instance", AudioContainer.class, audioContainer.getClass());
        assertEquals("fail instance", MenuContainer.class, menuContainer.getClass());
        assertEquals("fail instance", SceneContainer.class, sceneContainer.getClass());

        final MultitonDoubleCheckedLocking getAudioContainer = ManagerContainer.getInstance(AudioContainer.class);
        final MultitonDoubleCheckedLocking getMenuContainer = ManagerContainer.getInstance(MenuContainer.class);
        final MultitonDoubleCheckedLocking getSceneContainer = ManagerContainer.getInstance(SceneContainer.class);

        assertEquals("fail instance", audioContainer, getAudioContainer);
        assertEquals("fail instance", menuContainer, getMenuContainer);
        assertEquals("fail instance", sceneContainer, getSceneContainer);
    }

    @Test(timeout = 15000)
    public void testSceneManagerLockResolved() throws Exception {
        IntStream stream = IntStream.range(0, 100);
        stream.parallel().forEach(e -> {
            Timer timer = new Timer("Timer_" + e);
            timer.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                testGetInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    DELAY,
                    TIMER
            );
        });
    }

    @Test
    public void testGetNotNull() throws Exception {
        final MultitonDoubleCheckedLocking getAudioContainer = ManagerContainer.getInstance(AudioContainer.class);
        assertNotNull("Create instance", getAudioContainer);
    }

    @Test
    public void testGetInstantiationException() throws Exception {
        MultitonDoubleCheckedLocking getAudioContainer = null;
        try {
            getAudioContainer = ManagerContainer.getInstance(MultitionAbstract.class);
        }catch (InstantiationException e){
            assertNull("Create instance", getAudioContainer);
        }

    }


    public abstract class MultitionAbstract implements MultitonDoubleCheckedLocking { }
    public class AudioContainer implements MultitonDoubleCheckedLocking {
        public AudioContainer() {
        }
    }
    public class MenuContainer implements MultitonDoubleCheckedLocking {
        public MenuContainer() {
        }
    }
    public class SceneContainer implements MultitonDoubleCheckedLocking {
        public SceneContainer() {
        }
    }
}