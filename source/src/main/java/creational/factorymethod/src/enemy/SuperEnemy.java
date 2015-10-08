package creational.factorymethod.src.enemy;

import creational.simplefactory.api.ActorEnemy;

/**
 * Created by vicboma on 04/06/14.
 */
public class SuperEnemy implements ActorEnemy {
    public static SuperEnemy create() {
        return new SuperEnemy();
    }

    SuperEnemy() {
    }
}
