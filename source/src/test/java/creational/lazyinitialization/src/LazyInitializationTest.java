package creational.lazyinitialization.src;

import creational.abstractfactory.src.concreteFactory.Game2D;
import creational.abstractfactory.src.concreteFactory.Game3D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LazyInitializationTest {

    @Test
    public void testGetObjectByClass() throws Exception {
        final Class<String> stringClass = String.class;
        final String newString = LazyInitialization.getObjectByClass(stringClass);
        assertEquals("fail creation", stringClass, newString.getClass());

        final Class<Game2D> game2DClass = Game2D.class;
        final Game2D newGame2D = LazyInitialization.getObjectByClass(game2DClass);
        assertEquals("fail creation", game2DClass, newGame2D.getClass());

        final Class<String> stringClass2 = String.class;
        final String newString2 = LazyInitialization.getObjectByClass(stringClass2);
        assertEquals("fail creation", stringClass2, newString2.getClass());

        final Class<Game2D> game2DClass2 = Game2D.class;
        final Game2D newGame2D2 = LazyInitialization.getObjectByClass(game2DClass2);
        assertEquals("fail creation", game2DClass2, newGame2D2.getClass());

        final Class<Game3D> game3DClass = Game3D.class;
        final Game3D newGame3D = LazyInitialization.getObjectByClass(game3DClass);
        assertEquals("fail creation", game3DClass, newGame3D.getClass());

        final Class<Game3D> game3DClass2 = Game3D.class;
        final Game3D newGame3D2 = LazyInitialization.getObjectByClass(game3DClass2);
        assertEquals("fail creation", game3DClass2, newGame3D2.getClass());
    }

    @Test
    public void testInstantiationException() throws Exception {
        final Number number = null;
        try{
            LazyInitialization.getObjectByClass(Number.class);
        }catch(InstantiationException e){
            assertNull("Creation instace", number);
        }
    }


}