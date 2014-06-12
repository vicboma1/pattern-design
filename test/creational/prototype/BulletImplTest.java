package creational.prototype;

import creational.prototype.api.Bullet;
import creational.prototype.src.BulletImpl;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class BulletImplTest {

    private Bullet militar;

    @Before
    public void setUp() throws Exception {
        militar = new BulletImpl(".45", 5, new Point2D.Double(500.0,123.0));
    }

    @Test
    public void testRef() throws Exception {
        final String expected = ".45";
        assertEquals("fail ref", expected, militar.ref());
    }

    @Test
    public void testDamage() throws Exception {
        final Integer expected = 5;
        assertEquals("fail Damage", expected, militar.damage());
    }

    @Test
    public void testPosition() throws Exception {
        final Point2D.Double expected = new Point2D.Double(500.0,123.0);
        assertEquals("fail position",expected, militar.position());
    }

    @Test
    public void testClone() throws Exception {
       final Bullet bulletClone = militar.clone();
        assertNotSame("fail clone", bulletClone, militar);
    }
}
