package creational.abstractfactory.src.level.type;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class Level3DTest {

    @Test
    public void testCreate() throws Exception {
        final Level3D level3D = new Level3D();
        Assert.assertNotNull("Is null", level3D);
    }
}