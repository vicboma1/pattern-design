package creational.singletonthreadsafe.src;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SceneTestThreadSafe {

    private static final String INTRO = "Intro";
    private static final String GAME_OVER = "Game_Over";
    private static final Integer RESOURCE = new Integer(1000);
    private Scene scene;

    @Before
    public void setUp() throws Exception {
        scene = new Scene(INTRO, RESOURCE);
    }

    @Test
    public void testGetName() throws Exception {
        final String expected = INTRO;
        assertEquals("Not same name", expected, scene.getName());
    }

    @Test
    public void testGetResource() throws Exception {
        final Integer expected = RESOURCE;
        assertEquals("Not same resource", expected,scene.getResource());
    }

    @Test
    public void testSetName() throws Exception {
        final String expected = GAME_OVER;
        assertEquals("Not same name", INTRO, scene.getName());
        scene.setName(GAME_OVER);
        assertEquals("Not same name", expected, scene.getName());

    }
}
