package structural.flyweight.src.model;

import structural.adapter.api.Vector2D;
import structural.flyweight.api.ComponentPlayer2D;
import structural.flyweight.api.Player2D;

/**
 * Created by vicboma on 19/06/14.
 */
public class SuperMario implements ComponentPlayer2D {
    private Player2D player2D;

    public SuperMario(Player2D player2D) {
        this.player2D = player2D;
    }

    public void update(Vector2D newPosition, Vector2D velocity) {
        this.player2D.update(newPosition, velocity);
    }

    public Vector2D position() {
        return this.player2D.position();
    }

    @Override
    public String toString() {
        return "Component{" + "player2D=" + player2D + '}';
    }
}
