package creational.abstractfactory.src.level.type;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class Level2DTest {

    @Test
    public void testCreate() throws Exception {
        final Level2D level2D = new Level2D();
        Assert.assertNotNull("Is null", level2D);
    }
}