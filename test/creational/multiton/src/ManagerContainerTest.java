package creational.multiton.src;

import creational.multiton.api.Multiton;
import creational.multiton.src.model.AudioContainer;
import creational.multiton.src.model.MenuContainer;
import creational.multiton.src.model.SceneContainer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}