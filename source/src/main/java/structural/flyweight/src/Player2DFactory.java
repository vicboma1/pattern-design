package structural.flyweight.src;

import structural.flyweight.api.Player2D;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by vicboma on 19/06/14.
 */
public class Player2DFactory {
    private static Map<Actor, Player2D> mapPlayers = new Hashtable<Actor, Player2D>();

    public static Player2D getPlayer2D(Actor actor) {
        Player2D player2D = null;
        if (!mapPlayers.containsKey(actor)) {
            player2D = Player2DImpl.create(actor);
            mapPlayers.put(actor, player2D);
        } else {
            player2D = mapPlayers.get(actor);
        }

        return player2D;
    }
}
