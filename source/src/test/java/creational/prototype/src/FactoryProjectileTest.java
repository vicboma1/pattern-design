package creational.prototype.src;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vicboma on 09/10/15.
 */
public class FactoryProjectileTest {

    private FactoryProjectile factoryProjectile;

    @Test
    public void testCreate() throws Exception {
        factoryProjectile = new FactoryProjectile();
        Assert.assertNotNull(factoryProjectile);
    }
}