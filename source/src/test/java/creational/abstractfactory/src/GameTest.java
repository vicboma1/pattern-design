package creational.abstractfactory.src;

import creational.abstractfactory.src.concreteFactory.Game2D;
import creational.abstractfactory.src.concreteFactory.Game3D;
import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.level.type.Level2D;
import creational.abstractfactory.src.level.type.Level3D;
import creational.abstractfactory.src.resources.Resource;
import creational.abstractfactory.src.resources.type.HexaTile;
import creational.abstractfactory.src.resources.type.Model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Test
    public void testGame2D() throws Exception {
        final Level2D expectedLevel = new Level2D();
        final HexaTile expectedTile = new HexaTile();

        FactoryGame game2D = new Game2D();
        game = new Game(game2D);

        final Level level = game.abstractLevel();
        final Resource resource = game.abstractResource();

        assertEquals("Not level 2D", expectedLevel.getClass(), level.getClass());
        assertEquals("Not Hexa Tile", expectedTile.getClass(), resource.getClass());
    }

    @Test
    public void testGame3D() throws Exception {
        final Level3D expectedLevel = new Level3D();
        final Model expectedModel = new Model();

        FactoryGame game3D = new Game3D();
        game = new Game(game3D);

        final Level level = game.abstractLevel();
        final Resource resource = game.abstractResource();

        assertEquals("Not level 3D", expectedLevel.getClass(), level.getClass());
        assertEquals("Not Model", expectedModel.getClass(), resource.getClass());
    }

}