package creational.factorymethod.src.enemy;

import creational.simplefactory.api.ActorEnemy;

/**
 * Created by vicboma on 04/06/14.
 */
public class UltraEnemy implements ActorEnemy {
    public static UltraEnemy create() {
        return new UltraEnemy();
    }

    UltraEnemy() {
    }
}
