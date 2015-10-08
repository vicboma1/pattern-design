package creational.prototype.src.model;

import creational.prototype.api.Projectile;

import java.awt.geom.Point2D;

/**
 * Created by vicboma on 13/06/14.
 */
public class ProjectileImpl implements Projectile, Cloneable {

    private String ref;
    private Integer damage;
    private Point2D.Double position;

    public ProjectileImpl() {

    }

    public ProjectileImpl(String ref, Integer damage, Point2D.Double position) {
        this.configure(ref, damage, position);
    }

    @Override
    public Projectile configure(String ref, Integer damage, Point2D.Double position) {
        this.ref = ref;
        this.damage = damage;
        this.position = position;
        return this;
    }

    @Override
    public String ref() {
        return ref;
    }

    @Override
    public Integer damage() {
        return damage;
    }

    @Override
    public Point2D.Double position() {
        return position;
    }

    @Override
    public void update(Point2D.Double position) {
        for (double x = 0; x < 1280; x++) {
            this.position.setLocation(position.x + x, position.y);
        }
    }

    /**
     * Only clone the global object, no clone the fields.
     * The position is the same to all.
     *
     * @return
     */
    @Override
    public Projectile clone() {
        Projectile projectile = null;
        try {
            projectile = (Projectile) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            return projectile;
        }
    }


}
