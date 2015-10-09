package creational.prototype.src;

import creational.prototype.api.Projectile;
import creational.prototype.src.model.BulletImpl;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class GunTest {
    private Gun<Projectile> gun;
    private List<Projectile> projectileList;

    @Before
    public void setUp() throws Exception {
        projectileList = new ArrayList<Projectile>();
        prepareBullet(5000);
        gun = new Gun<Projectile>("Magnum", true, projectileList, 7000);
    }

    private void prepareBullet(Integer bulletSize) {
        final Projectile projectile = new BulletImpl(".357", 50, new Point2D.Double(0.0, 0.0));
        IntStream stream = IntStream.range(0, bulletSize);
        stream.sequential().forEach(e -> {
            projectileList.add(projectile.clone());
        });
    }

    @Test
    public void testShootResolved() throws Exception {
        final Boolean shoot = this.gun.shoot(new Point2D.Double(150.0, 200.0));
        assertTrue("Rejected shoot", shoot);
    }

    @Test
    public void testShootRejected() throws Exception {
        this.projectileList.clear();
        final Boolean shoot = this.gun.shoot(new Point2D.Double(150.0, 200.0));
        assertFalse("Resolved shoot", shoot);
    }

    @Test
    public void testName() throws Exception {
        final String expected = "Magnum";
        assertEquals("fail name", expected, gun.name());
    }

    @Test
    public void testIsActive() throws Exception {
        final Boolean expected = true;
        assertTrue("fail active", gun.isActive());
        this.projectileList.clear();
        assertFalse("fail active", gun.isActive());
    }

    @Test
    public void testAvailableBullets() throws Exception {
        final Integer expectedBullets = 5000;
        assertEquals("fail bullets", expectedBullets, this.gun.availableBullets());
    }


    @Test
    public void testFactoryProjectile() throws Exception {
        Projectile bullet1 = FactoryProjectile.make("Bullet", ".37", 45, new Point2D.Double(0.0, 0.0));
        Projectile bullet2 = FactoryProjectile.make("Bullet", ".75", 80, new Point2D.Double(0.0, 0.0));
        Projectile bullet3 = FactoryProjectile.make("Bullet", ".66", 70, new Point2D.Double(0.0, 0.0));
        Projectile bullet4 = FactoryProjectile.make("Bullet", ".90", 100, new Point2D.Double(0.0, 0.0));

        Projectile missile1 = FactoryProjectile.make("Missile", "AA-1 Alkali", 95, new Point2D.Double(0.0, 0.0));
        Projectile missile2 = FactoryProjectile.make("Missile", "ADM-141 TALD", 100, new Point2D.Double(0.0, 0.0));
        Projectile missile3 = FactoryProjectile.make("Missile", "AGM-12 Bullpup", 150, new Point2D.Double(0.0, 0.0));
        Projectile missile4 = FactoryProjectile.make("Missile", "AIR-2 Genie", 500, new Point2D.Double(0.0, 0.0));

        assertNotEquals("fail bullet", bullet1, bullet2);
        assertNotEquals("fail bullet", bullet1, bullet3);
        assertNotEquals("fail bullet", bullet1, bullet4);
        assertNotEquals("fail bullet", bullet2, bullet3);
        assertNotEquals("fail bullet", bullet2, bullet4);
        assertNotEquals("fail bullet", bullet3, bullet4);

        assertNotEquals("fail missile", missile1, missile2);
        assertNotEquals("fail missile", missile1, missile3);
        assertNotEquals("fail missile", missile1, missile4);
        assertNotEquals("fail missile", missile2, missile3);
        assertNotEquals("fail missile", missile2, missile4);
        assertNotEquals("fail missile", missile3, missile4);
    }

    @Test
    public void testCharger() throws Exception {
        final int _charger = 100;
        final Gun<Projectile> spy = spy(gun);
        spy.charger(_charger);
        verify(spy).charger(_charger);
    }
}
