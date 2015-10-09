package creational.abstractfactory.src.resources.type;

import creational.abstractfactory.src.level.type.Level3D;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class ModelTest {

    @Test
    public void testCreate() throws Exception {
        final Model model = new Model();
        Assert.assertNotNull("Is null", model);
    }
}