package creational.abstractfactory.src.concreteFactory;

import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.level.type.Level3D;
import creational.abstractfactory.src.resources.Resource;
import creational.abstractfactory.src.resources.type.Model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game3DTest {

    private Game3D game3D;

    @Before
    public void setUp() throws Exception {
        game3D = new Game3D();
    }

    @Test
    public void testCreateLevel() throws Exception {
        final Level3D expected = new Level3D();
        final Level level3D = game3D.createLevel();
        assertEquals("Not create level", expected.getClass(), level3D.getClass());
    }

    @Test
    public void testCreateResource() throws Exception {
        final Model expected = new Model();
        final Resource resource = game3D.createResource();
        assertEquals("Not create resource", expected.getClass(), resource.getClass());
    }

}