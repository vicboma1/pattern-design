package creational.simplefactory.src;

import behavioral.observer.src.model.player.Player;
import creational.simplefactory.api.SimpleFactoryPlayer;

/**
 * Created by vicboma on 04/06/14.
 */
public class SimpleFactoryPlayerImpl implements SimpleFactoryPlayer {
    @Override
    public Player create() {
        return new Player();
    }
}
