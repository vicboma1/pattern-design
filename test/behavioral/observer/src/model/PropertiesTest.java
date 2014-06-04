package behavioral.observer.src.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropertiesTest {

    private Properties properties;

    @Before
    public void setUp() throws Exception {
        final String joe = "Joe";
        properties = Properties.create(joe);
    }

    @Test
    public void testName() throws Exception {
        final String expected = "Joe";
        assertEquals("Not same name", expected, properties.name());
    }

    @Test
    public void testAttack() throws Exception {
        Integer expected = Properties.INIT_ATTACK;
        assertEquals("Not same name", expected, properties.attack());
    }

    @Test
    public void testHealth() throws Exception {
        Integer expected = Properties.INIT_HEALTH;
        assertEquals("Not same name", expected, properties.health());
    }
}