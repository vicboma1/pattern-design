package creational.abstractfactory.src.resources.type;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class HexaTileTest {

    @Test
    public void testCreate() throws Exception {
        final HexaTile hexaTile = new HexaTile();
        Assert.assertNotNull("Is null", hexaTile);
    }
}