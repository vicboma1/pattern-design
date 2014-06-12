package creational.prototype;

import creational.prototype.api.Bullet;
import creational.prototype.src.BulletImpl;
import creational.prototype.src.Gun;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class GunTest {
    private Gun<Bullet> gun;
    private List<Bullet> bulletList;

    @Before
    public void setUp() throws Exception {
        bulletList = new ArrayList<Bullet>();
        prepareBullet(5000);
        gun = new Gun<Bullet>("Magnum",true,bulletList,7000);
    }

    private void prepareBullet(Integer bulletSize)
    {
       Bullet bullet = new BulletImpl(".357", 50, new Point2D.Double(0.0, 0.0));
       System.out.println(" Bullet bullet = new BulletImpl(\".357\", 50, new Point2D.Double(0.0, 0.0)); "+bullet.toString());

        for(int i = 0; i< bulletSize ; i++)
       {
           bullet = bullet.clone();
           System.out.println("bullet.clone() "+bullet.clone().toString());
           bulletList.add(i, bullet);
       }
    }

    @Test
    public void testShootResolved() throws Exception {
        final Boolean shoot = this.gun.shoot(new Point2D.Double(150.0, 200.0));
        assertTrue("Rejected shoot", shoot);
    }

    @Test
    public void testShootRejected() throws Exception {
        this.bulletList.clear();
        final Boolean shoot = this.gun.shoot(new Point2D.Double(150.0, 200.0));
        assertFalse("Resolved shoot", shoot);
    }

    @Test
    public void testName() throws Exception {
        final String expected = "Magnum";
        assertEquals("fail name",expected,gun.name());
    }

    @Test
    public void testIsActive() throws Exception {
        final Boolean expected = true;
        assertTrue("fail active", gun.isActive());
        this.bulletList.clear();
        assertFalse("fail active", gun.isActive());
    }

    @Test
    public void testAvailableBullets() throws Exception {
        final Integer expectedBullets = 5000;
        assertEquals("fail bullets", expectedBullets, this.gun.availableBullets());
    }
}
