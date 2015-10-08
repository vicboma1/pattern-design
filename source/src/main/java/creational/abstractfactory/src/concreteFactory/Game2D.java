package creational.abstractfactory.src.concreteFactory;

import creational.abstractfactory.src.FactoryGame;
import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.level.type.Level2D;
import creational.abstractfactory.src.resources.Resource;
import creational.abstractfactory.src.resources.type.HexaTile;

/**
 * Created by vicboma on 05/06/14.
 */
public class Game2D extends FactoryGame {

    @Override
    public Level createLevel() {
        return new Level2D();
    }

    @Override
    public Resource createResource() {
        return new HexaTile();
    }
}
