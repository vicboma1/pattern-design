package creational.abstractfactory.src.concreteFactory;

import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.level.type.Level2D;
import creational.abstractfactory.src.resources.Resource;
import creational.abstractfactory.src.resources.type.HexaTile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game2DTest {

    private Game2D game2D;

    @Before
    public void setUp() throws Exception {
        game2D = new Game2D();
    }

    @Test
    public void testCreateLevel() throws Exception {
        final Level2D expected = new Level2D();
        final Level level2D = game2D.createLevel();
        assertEquals("Not create level", expected.getClass(), level2D.getClass());
    }

    @Test
    public void testCreateResource() throws Exception {
        final HexaTile expected = new HexaTile();
        final Resource resource = game2D.createResource();
        assertEquals("Not create resource", expected.getClass(), resource.getClass());
    }
}