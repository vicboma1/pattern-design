package creational.factorymethod.src.enemy;

import creational.simplefactory.api.ActorEnemy;

/**
 * Created by vicboma on 04/06/14.
 */
public class BossEnemy implements ActorEnemy {

    public static BossEnemy create() {
        return new BossEnemy();
    }

    BossEnemy() {
    }

}
