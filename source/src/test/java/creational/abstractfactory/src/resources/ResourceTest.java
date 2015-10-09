package creational.abstractfactory.src.resources;

import creational.abstractfactory.src.resources.type.HexaTile;
import creational.abstractfactory.src.resources.type.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class ResourceTest {

    @Test
    public void testCreateHexaTile() throws Exception {
        final Resource hexaTile = new HexaTile();
        Assert.assertNotNull("Is null", hexaTile);
    }

    @Test
    public void testCreateModel() throws Exception {
        final Resource model = new Model();
        Assert.assertNotNull("Is null", model);
    }
}