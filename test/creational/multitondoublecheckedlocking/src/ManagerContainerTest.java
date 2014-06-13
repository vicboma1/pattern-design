package creational.multitondoublecheckedlocking.src;

import creational.multitondoublecheckedlocking.api.MultitonDoubleCheckedLocking;
import creational.multitondoublecheckedlocking.src.model.AudioContainer;
import creational.multitondoublecheckedlocking.src.model.MenuContainer;
import creational.multitondoublecheckedlocking.src.model.SceneContainer;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.Assert.assertEquals;

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

        for (int i = 0; i < 100; i++) {
            final int index = i;
            Timer timer = new Timer("Timer_" + index);
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
        }
    }
}