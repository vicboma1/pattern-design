package creational.multiton.src;

import creational.multiton.api.Multiton;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerContainerTest {

    @Test
    public void testGetInstance() throws Exception {
        final Multiton audioContainer = ManagerContainer.getInstance(AudioContainer.class);
        final Multiton menuContainer = ManagerContainer.getInstance(MenuContainer.class);
        final Multiton sceneContainer = ManagerContainer.getInstance(SceneContainer.class);

        assertEquals("fail instance", AudioContainer.class, audioContainer.getClass());
        assertEquals("fail instance", MenuContainer.class, menuContainer.getClass());
        assertEquals("fail instance", SceneContainer.class, sceneContainer.getClass());

        final Multiton getAudioContainer = ManagerContainer.getInstance(AudioContainer.class);
        final Multiton getMenuContainer = ManagerContainer.getInstance(MenuContainer.class);
        final Multiton getSceneContainer = ManagerContainer.getInstance(SceneContainer.class);

        assertEquals("fail instance", audioContainer, getAudioContainer);
        assertEquals("fail instance", menuContainer, getMenuContainer);
        assertEquals("fail instance", sceneContainer, getSceneContainer);

    }

    @Test
      public void testGetNotNull() throws Exception {
        final Multiton getAudioContainer = ManagerContainer.getInstance(AudioContainer.class);
        assertNotNull("Create instance", getAudioContainer);
    }

    @Test
    public void testGetInstantiationException() throws Exception {
         Multiton getAudioContainer = null;
        try {
           getAudioContainer = ManagerContainer.getInstance(MultitionAbstract.class);
        }
        catch(InstantiationException e){
            assertNull("Create instance", getAudioContainer);
        }

    }

    @Test
    public void testCreate() throws Exception {
        ManagerContainer managerContainer = new ManagerContainer();
        assertNotNull(managerContainer);
    }

    public abstract class MultitionAbstract implements Multiton { }
    public class AudioContainer implements Multiton {
        public AudioContainer() {
        }
    }
    public class MenuContainer implements Multiton {
        public MenuContainer() {
        }
    }
    public class SceneContainer implements Multiton {
        public SceneContainer() {
        }
    }

}