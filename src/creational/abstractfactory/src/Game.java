package creational.abstractfactory.src;

import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.resources.Resource;

/**
 * Created by vicboma on 05/06/14.
 */
public class Game {
    private Resource resource;
    private Level level;

    // Constructor
    public Game(FactoryGame factoryGame)
    {
        resource = factoryGame.createResource();
        level = factoryGame.createLevel();
    }

    public Resource abstractResource() {
        return resource;
    }

    public Level abstractLevel() {
        return level;
    }
}
