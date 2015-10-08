package creational.objectpool.src.model;

import creational.objectpool.api.Disposable;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by vicboma on 17/06/14.
 */
public class Particle implements Disposable {

    private GraphicsDevice gd;
    private Point2D.Double axis;
    private Point2D.Double vel;

    public static Particle create(Point2D.Double axis, Point2D.Double vel) {
        return new Particle(axis, vel);
    }

    Particle(Point2D.Double axis, Point2D.Double vel) {
        this.axis = axis;
        this.vel = vel;
        this.gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    public void animate() {
        final double x = this.axis.x + this.vel.getX();
        final int height = gd.getDisplayMode().getHeight();
        final double y = Math.sin(this.axis.y) + ((height / 2) - (this.axis.getY() / 2));
        this.axis.setLocation(x, y);
    }

    public Boolean isAlive() {
        final int width = gd.getDisplayMode().getWidth();
        return (this.axis.getX() < width);
    }

    @Override
    public void dispose() {
        this.axis = null;
        this.vel = null;
        this.gd = null;
        //System.gc();
    }
}
