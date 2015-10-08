package creational.prototype.src.model;

import creational.prototype.api.Projectile;

import java.awt.geom.Point2D;

/**
 * Created by vicboma on 13/06/14.
 */
public class MissileImpl implements Projectile {

    private ProjectileImpl projectile;

    public MissileImpl() {
    }

    public MissileImpl(String ref, Integer damage, Point2D.Double position) {
        this.configure(ref, damage, position);
    }

    @Override
    public Projectile configure(String ref, Integer damage, Point2D.Double position) {
        this.projectile = new ProjectileImpl(ref, damage, position);
        return this;
    }

    @Override
    public String ref() {
        final String ref = projectile.ref();
        return ref;
    }

    @Override
    public Integer damage() {
        final Integer damage = projectile.damage();
        return damage;
    }

    @Override
    public Point2D.Double position() {
        final Point2D.Double position = projectile.position();
        return position;
    }

    @Override
    public void update(Point2D.Double position) {
        for (double x = 0; x < 1280; x++) {
            final Point2D.Double position1 = this.projectile.position();
            position1.setLocation(position.x + x, position.y);
        }

    }

    @Override
    public Projectile clone() {
        return this.projectile.clone();
    }
}
