package behavioral.observer.src;

import behavioral.observer.api.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisplayElementTest {

    private View displayElement;

    @Before
    public void setUp() throws Exception {
        displayElement = DisplayElement.create();
    }

    @Test
    public void testDisplay() throws Exception {
        final boolean expected = true;
        final int attack = 50;
        final int health = 100;
        final String joe = "Joe";
        final String cannibal = "Cannibal";
        final boolean isDead = false;

        assertEquals("Not display", expected, displayElement.display(isDead, attack, health, joe, cannibal));
    }


}