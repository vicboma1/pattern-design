package creational.prototype.src.model;

import creational.prototype.api.Projectile;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 09/10/15.
 */
public class ProjectileImplTest {

    private Projectile projectile;
    private final String ref = "ref";
    private final int damage = 10;
    private final Point2D.Double position = new Point2D.Double(35, 54);

    @Before
    public void setUp() throws Exception {
        projectile = new ProjectileImpl();
    }

    @Test
    public void testConfigure() throws Exception {
        final Projectile configure = projectile.configure(ref, damage, position);
        Assert.assertEquals(configure, projectile);
    }

    @Test
    public void testRef() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals(ref, projectile.ref());
    }

    @Test
    public void testDamage() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals("not same", (int) damage, (int) projectile.damage());
    }

    @Test
    public void testPosition() throws Exception {
        projectile.configure(ref, damage, position);
        Assert.assertEquals("No Position", position, projectile.position());
    }

    @Test
    public void testUpdate() throws Exception {
        projectile.configure(ref, damage, position);
        Projectile missile = spy(projectile);
        missile.update(position);
        verify(missile).update(position);
    }

    @Test
    public void testClone() throws Exception {
        projectile.configure(ref, damage, position);
        final Projectile clone = projectile.clone();
        final String expected = "creational.prototype.src.model.ProjectileImpl";
        Assert.assertSame(clone.getClass().getName(), expected);
    }
}