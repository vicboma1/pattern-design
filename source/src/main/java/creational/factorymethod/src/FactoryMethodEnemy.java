package creational.factorymethod.src;

import creational.factorymethod.src.enemy.BossEnemy;
import creational.factorymethod.src.enemy.SuperEnemy;
import creational.factorymethod.src.enemy.UltraEnemy;
import creational.factorymethod.src.enemy.type.EnemyType;
import creational.simplefactory.api.ActorEnemy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vicboma on 04/06/14.
 */
public class FactoryMethodEnemy{

    public FactoryMethodEnemy() {
    }

    public static ActorEnemy createActor(EnemyType enemyType){
        return newActor(enemyType);
    }

    private static ActorEnemy newActor(EnemyType enemyType) {
        return getHashtable().get(enemyType);
    }

    private static Map<EnemyType, ActorEnemy> getHashtable() {
        return new HashMap()
        {
            {
                put(EnemyType.BOSSENEMY, BossEnemy.create());
                put(EnemyType.ULTRAENEMY, UltraEnemy.create());
                put(EnemyType.SUPERENEMY, SuperEnemy.create());
            }
        };
    }
}
