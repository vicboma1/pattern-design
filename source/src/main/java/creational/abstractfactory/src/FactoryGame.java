package creational.abstractfactory.src;

import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.resources.Resource;

/**
 * Created by vicboma on 04/06/14.
 */
public abstract class FactoryGame {
    public FactoryGame() {
    }

    public abstract Level createLevel();
    public abstract Resource createResource();
}
