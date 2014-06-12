package structural.adapter.api;

import java.io.Serializable;

/**
 * Created by vicboma on 13/06/14.
 */
public interface Vector2D extends Cloneable, Serializable {

    Double x();

    Double y();

    void set(Double x, Double y);

    Double radius();

    Double theta();

    Vector2D plus(Vector2D rhs);

    Vector2D minus(Vector2D rhs);

    Boolean equals(Vector2D rhs);

    Vector2D times(Double scalar);

    Double length();

    Vector2D toPolar();

    Vector2D toRect();

    String toString();
}
