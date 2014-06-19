package structural.flyweight.src;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ActorTest {

    private Actor actor;

    @Before
    public void setUp() throws Exception {
        actor = new Actor(Color.RED, "Mario");
    }

    @Test
    public void testGetColor() throws Exception {
        final Color expected = Color.RED;
        assertEquals("fail color", expected, actor.getColor());
    }

    @Test
    public void testGetName() throws Exception {
        final String expected = "Mario";
        assertEquals("fail color", expected, actor.getName());
    }

    @Test
    public void testEquals() throws Exception {
        Actor expected = new Actor(Color.RED, "Mario");
        assertEquals("fail equals", expected, actor);
    }

}