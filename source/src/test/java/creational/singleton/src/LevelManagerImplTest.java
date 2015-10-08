package creational.singleton.src;

import creational.singleton.api.SceneManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class LevelManagerImplTest {

    private SceneManager<Integer,Scene> sceneManager;

    @Before
    public void setUp() throws Exception {
        sceneManager = Singleton.sceneManager();
    }

    @After
    public void tearDown() throws Exception {
        sceneManager = null;
    }

    @Test
    public void testPut() throws Exception {
        final Scene expectedIntro = new Scene("Intro", null);
        final Scene expectedGameOver = new Scene("GameOver", null);

        final Scene scenePut = sceneManager.put(1, expectedIntro);
        final Scene introScene = sceneManager.put(1, expectedGameOver);

        assertNull("fail intro replace", scenePut);
        assertEquals("fail intro", expectedIntro.getName(), introScene.getName());
    }

    @Test
    public void testRemove() throws Exception {
        final Scene expectedIntro = new Scene("Intro", null);
        sceneManager.put(1, expectedIntro);

        final Scene remove = sceneManager.remove(1);

        assertEquals("fail remove", expectedIntro, remove);
    }

    @Test
    public void testGoTo() throws Exception {
        final Scene expectedIntro = new Scene("Intro", null);
        final Scene expectedGameOver = new Scene("GameOver", null);

        sceneManager.put(1, expectedIntro);
        sceneManager.put(2, expectedGameOver);

        final Scene gotoIntro = sceneManager.goTo(1);
        assertEquals("fail goto", expectedIntro.getName(), gotoIntro.getName());

        final Scene gotoGameOver = sceneManager.goTo(2);
        assertEquals("fail goto", expectedGameOver.getName(), gotoGameOver.getName());
    }

  /*  @Test
    public void testSize() throws Exception {
        final Scene expectedIntro = new Scene("Intro", null);

        sceneManager.put(1, expectedIntro);
        final int size = sceneManager.size();
        assertEquals("fail size", size, 1);

        sceneManager.put(2, expectedIntro);
        sceneManager.put(3, expectedIntro);
        assertEquals("fail size", sceneManager.size(), 3);

        sceneManager.remove(2);
        assertEquals("fail size", sceneManager.size(), 2);
    }*/

    @Test
    public void testDestroy() throws Exception {
        SceneManager<Integer,Scene> sceneManagerSpy = spy(sceneManager);
        sceneManagerSpy.destroy();
        verify(sceneManagerSpy).destroy();
    }
}