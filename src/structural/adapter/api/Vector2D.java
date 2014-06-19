package structural.adapter.api;

import structural.adapter.src.Vector2DImpl;

import java.io.Serializable;

/**
 * Created by vicboma on 13/06/14.
 */
public interface Vector2D extends Cloneable, Serializable {

    static Vector2D ZERO() {
        return new Vector2DImpl(0.0, 0.0);
    }

    Double x();

    Double y();

    void set(Double x, Double y);

    Double radius();

    Double theta();

    Vector2D plus(Vector2D rhs);

    Vector2D minus(Vector2D rhs);

    Vector2D dot(Vector2D vector2D);

    Boolean equals(Vector2D rhs);

    Vector2D times(Double scalar);

    Double length();

    Vector2D toPolar();

    Vector2D toRect();

    String toString();
}
