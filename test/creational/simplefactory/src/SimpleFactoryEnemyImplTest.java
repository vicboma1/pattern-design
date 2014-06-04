package creational.simplefactory.src;

import behavioral.observer.src.model.enemy.Enemy;
import creational.simplefactory.api.SimpleFactoryEnemy;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SimpleFactoryEnemyImplTest {

    @Test
    public void testCreate() throws Exception {
        final int expected = 100;
        final SimpleFactoryEnemy simpleFactoryEnemy = new SimpleFactoryEnemyImpl();
        Set<Enemy> enemies = new HashSet<Enemy>();

        final int endIterator = expected;
        for (int i = 0; i < endIterator; i++) {
            final Enemy enemy = simpleFactoryEnemy.create();
            System.out.println("Enemy instance "+enemy.toString());
            enemies.add(enemy);
        }

        assertEquals("The object is duplicate!!!!", expected, enemies.size());
    }
}