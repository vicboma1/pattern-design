package creational.prototype.src;

import creational.prototype.api.Bullet;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public class BulletImpl implements Bullet, Cloneable {

    private String ref;
    private Integer damage;
    private Point2D.Double position;

    public BulletImpl(String ref, Integer damage, Point2D.Double position) {
        this.ref = ref;
        this.damage = damage;
        this.position = position;
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
        for(double x = 0; x < 1280; x++)
        {
            this.position.setLocation(position.x+x, position.y);
        }
    }

    /**
     * Only clone the global object, no clone the fields.
     * The position is the same to all.
     *
     * @return
     */
    @Override
    public Bullet clone() {
        Bullet bullet = null;
        try {
            bullet = (Bullet)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finally {
            return bullet;
        }
    }
}
