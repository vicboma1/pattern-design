package creational.factorymethod.src;

import creational.factorymethod.src.enemy.type.EnemyType;
import creational.simplefactory.api.ActorEnemy;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class FactoryMethodEnemyTest {


    @Test
    public void testCreateActor() throws Exception {
        final int expected = 100;
        Set<ActorEnemy> players = new HashSet<ActorEnemy>();
        IntStream stream = IntStream.range(0, expected);
        stream.sequential().forEach(e -> {
            final EnemyType enemyType = getType(e);
            final ActorEnemy actor = FactoryMethodEnemy.createActor(enemyType);
            System.out.println("ActorEnemy instance "+actor.toString());
            players.add(actor);
        });

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