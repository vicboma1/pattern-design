package creational.factorymethod.src;

import creational.factorymethod.src.enemy.BossEnemy;
import creational.factorymethod.src.enemy.SuperEnemy;
import creational.factorymethod.src.enemy.UltraEnemy;
import creational.factorymethod.src.enemy.type.EnemyType;
import creational.simplefactory.api.ActorEnemy;

import java.util.Hashtable;

/**
 * Created by vicboma on 04/06/14.
 */
public class FactoryMethodEnemy{

    public static ActorEnemy createActor(EnemyType enemyType){
        return newActor(enemyType);
    }

    private static ActorEnemy newActor(EnemyType enemyType) {
        return new Hashtable<EnemyType,ActorEnemy>()
        {
            {
                put(EnemyType.BOSSENEMY, BossEnemy.create());
                put(EnemyType.ULTRAENEMY, UltraEnemy.create());
                put(EnemyType.SUPERENEMY, SuperEnemy.create());
            }
        }.get(enemyType);
    }
}
