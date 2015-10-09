package creational.prototype.src;

import creational.prototype.api.Projectile;
import creational.prototype.src.model.BulletImpl;
import creational.prototype.src.model.MissileImpl;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vicboma on 13/06/14.
 */
public class FactoryProjectile {
    public FactoryProjectile() {
    }

    private static Map<String, Projectile> prototypes = new HashMap() {
        {
            put("Missile", new MissileImpl());
            put("Bullet", new BulletImpl());
        }
    };

    public static Projectile make(String key, String ref, Integer damage, Point2D.Double position) {
        final Projectile configure = prototypes.get(key).configure(ref, damage, position);
        final Projectile clone = configure.clone();
        return clone;
    }
}
