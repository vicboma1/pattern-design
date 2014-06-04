package creational.simplefactory.src;

import behavioral.observer.src.model.enemy.Enemy;
import creational.simplefactory.api.SimpleFactoryEnemy;

/**
 * Created by vicboma on 04/06/14.
 */
public class SimpleFactoryEnemyImpl implements SimpleFactoryEnemy {
    @Override
    public Enemy create() {
        return new Enemy();
    }
}
