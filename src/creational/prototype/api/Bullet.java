package creational.prototype.api;

import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
public interface Bullet extends Serializable
{
    String ref();
    Integer damage();
    Point2D.Double position();
    void update(Point2D.Double position);
    Bullet clone();
}
