package structural.adapter.src;

import structural.adapter.api.Vector2D;

import java.awt.geom.Point2D;

/**
 * Created by vicboma on 13/06/14.
 */
public class Vector2DImpl implements Vector2D {

    protected Point2D.Double point2d;

    public Vector2DImpl() {
        point2d = new Point2D.Double();
    }

    public Vector2DImpl(Point2D.Double point2d) {
        this();
        this.point2d = point2d;
    }

    public Vector2DImpl(Vector2D vector2D) {
        this();
        this.point2d.x = vector2D.x();
        this.point2d.y = vector2D.y();
    }

    public Vector2DImpl(Double x, Double y) {
        this.point2d = new Point2D.Double(x, y);
    }

    public Vector2DImpl(Double x) {
        this.point2d = new Point2D.Double(x, x);
    }


    @Override
    public void set(Double x, Double y) {
        this.point2d.setLocation(x, y);
    }

    @Override
    public Double x() {
        return this.point2d.x;
    }

    @Override
    public Double y() {
        return this.point2d.y;
    }

    @Override
    public Double radius() {
        final double x = this.point2d.x;
        final double y = this.point2d.y;
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public Double theta() {
        return Math.atan2(this.point2d.y, this.point2d.x);
    }

    @Override
    public Vector2D plus(Vector2D vector2D) {
        final double x = this.point2d.x + vector2D.x();
        final double y = this.point2d.y + vector2D.y();
        return new Vector2DImpl(x, y);
    }

    @Override
    public Vector2D minus(Vector2D vector2D) {
        final double x = this.point2d.x - vector2D.x();
        final double y = this.point2d.y - vector2D.y();
        return new Vector2DImpl(x, y);
    }

    @Override
    public Vector2D dot(Vector2D vector2D) {
        final double x = this.point2d.x * vector2D.x();
        final double y = this.point2d.y * vector2D.y();
        return new Vector2DImpl(x, y);
    }


    @Override
    public Vector2D times(Double scalar) {
        final double x = this.point2d.x * scalar;
        final double y = this.point2d.y * scalar;
        return new Vector2DImpl(x, y);
    }

    @Override
    public Double length() {
        return radius();
    }

    @Override
    public Vector2D toPolar() {
        final double radius = radius();
        final double theta = theta();
        return new Vector2DImpl(radius, theta);
    }

    @Override
    public Vector2D toRect() {
        final double x = this.point2d.x * Math.cos(this.point2d.x);
        final double y = this.point2d.x * Math.sin(this.point2d.x);
        return new Vector2DImpl(x, y);
    }

    @Override
    public Boolean equals(Vector2D vector2D) {
        final boolean x = this.point2d.x == vector2D.x();
        final boolean y = this.point2d.y == vector2D.y();
        return (x && y);
    }

    @Override
    public String toString() {
        return "[" + this.point2d.x + "," + this.point2d.y + "]";
    }
}
