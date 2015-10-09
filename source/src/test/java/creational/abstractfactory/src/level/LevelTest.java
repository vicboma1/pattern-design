package creational.abstractfactory.src.level;

import creational.abstractfactory.src.level.type.Level2D;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class LevelTest {

    @Test
    public void testCreateLeve2d() throws Exception {
        final Level level2D = new Level2D();
        Assert.assertNotNull("Is null", level2D);
    }

    @Test
    public void testCreateLevel3d() throws Exception {
        final Level level2D = new Level2D();
        Assert.assertNotNull("Is null", level2D);
    }

}