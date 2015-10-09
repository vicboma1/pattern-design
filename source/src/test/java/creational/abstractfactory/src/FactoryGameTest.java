package creational.abstractfactory.src;

import creational.abstractfactory.src.concreteFactory.Game2D;
import creational.abstractfactory.src.concreteFactory.Game3D;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 09/10/15.
 */
public class FactoryGameTest {


    @Test
    public void testCreateLevelGame3D() throws Exception {
        FactoryGame factoryGame = new Game3D();
        FactoryGame gameSpy = spy(factoryGame);
        gameSpy.createLevel();
        verify(gameSpy).createLevel();
    }

    @Test
    public void testCreateResourceGame3D() throws Exception {
        FactoryGame factoryGame = new Game3D();
        FactoryGame gameSpy = spy(factoryGame);
        gameSpy.createResource();
        verify(gameSpy).createResource();
    }


    @Test
    public void testCreateLevelGame2D() throws Exception {
        FactoryGame factoryGame = new Game2D();
        FactoryGame gameSpy = spy(factoryGame);
        gameSpy.createLevel();
        verify(gameSpy).createLevel();
    }

    @Test
    public void testCreateResourceGame2D() throws Exception {
        FactoryGame factoryGame = new Game2D();
        FactoryGame gameSpy = spy(factoryGame);
        gameSpy.createResource();
        verify(gameSpy).createResource();
    }

}