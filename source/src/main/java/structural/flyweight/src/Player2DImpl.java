package structural.flyweight.src;

import structural.adapter.api.Vector2D;
import structural.flyweight.api.Player2D;

/**
 * Created by vicboma on 19/06/14.
 */
public class Player2DImpl implements Player2D {

    private Actor actor;
    /* Extrinsic */
    private Vector2D position;

    public static Player2D create(Actor actor) {
        return new Player2DImpl(actor);
    }

    public Player2DImpl(Actor actor) {
        this.actor = actor;
        this.position = Vector2D.ZERO();
    }

    @Override
    public void update(Vector2D newPosition, Vector2D velocity) {
        final Vector2D dot = newPosition.dot(velocity); // * GameTime.ElapsedGameTime.TotalSeconds
        this.position = this.position.plus(dot);
    }

    @Override
    public Vector2D position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        Player2DImpl player2D = (Player2DImpl) o;
        return this.actor.equals(player2D.actor);
    }

    @Override
    public String toString() {
        final String str = "Player: " + this.actor.getName() + " Color: " + this.actor.getColor() + " Position: " + position.toString();
        return str;
    }
}
