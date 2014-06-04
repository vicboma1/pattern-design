package creational.factorymethod.src;

import creational.factorymethod.src.enemy.type.EnemyType;
import creational.simplefactory.api.ActorEnemy;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FactoryMethodEnemyTest {


    @Test
    public void testCreateActor() throws Exception {
        final int expected = 100;
        Set<ActorEnemy> players = new HashSet<ActorEnemy>();

        final int endIterator = expected;
        for (int i = 0; i < endIterator; i++) {
            final EnemyType enemyType = getType(i);
            final ActorEnemy actor = FactoryMethodEnemy.createActor(enemyType);
            System.out.println("ActorEnemy instance "+actor.toString());
            players.add(actor);
        }

        assertEquals("The object is duplicate!!!!", expected, players.size());
    }

    private EnemyType getType(Integer i) {
        final int mod = i % 3;
        switch(mod)
        {
            case 0: return EnemyType.BOSSENEMY;
            case 1: return EnemyType.SUPERENEMY;
            case 2: return EnemyType.ULTRAENEMY;
            default: return null;
        }
    }
}