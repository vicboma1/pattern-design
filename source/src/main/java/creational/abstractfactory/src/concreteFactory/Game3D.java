package creational.abstractfactory.src.concreteFactory;

import creational.abstractfactory.src.FactoryGame;
import creational.abstractfactory.src.level.Level;
import creational.abstractfactory.src.level.type.Level3D;
import creational.abstractfactory.src.resources.Resource;
import creational.abstractfactory.src.resources.type.Model;

/**
 * Created by vicboma on 05/06/14.
 */
public class Game3D extends FactoryGame {

    @Override
    public Level createLevel() {
        return new Level3D();
    }

    @Override
    public Resource createResource() {
        return new Model();
    }
}
