package structural.flyweight.api;

import structural.adapter.api.Vector2D;

/**
 * Created by vicboma on 19/06/14.
 */
public interface Player2D {
    void update(Vector2D newPosition, Vector2D velocity);

    Vector2D position();
}
