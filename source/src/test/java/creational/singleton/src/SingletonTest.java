package creational.singleton.src;

import creational.singleton.api.SceneManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

    @Test
    public void testSceneManager() throws Exception {
        final SceneManager<String,Scene> expected = Singleton.sceneManager();
        final SceneManager<String,Scene> sceneManager = Singleton.sceneManager();
        assertEquals("Not same instance",expected, sceneManager);
    }
}