package behavioral.observer.src.model.enemy;

import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Properties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EnemyTest {

    private Enemy enemy;
    private Properties properties;
    private StatusData statusData;
    private View view;

    @Before
    public void setUp() throws Exception {

        properties = mock(Properties.class);
        statusData = mock(StatusData.class);
        view = mock(View.class);

        enemy = Enemy.create(properties, statusData, view);
    }

    @Test
    public void testUpdateResolved() throws Exception {
        final boolean expected = true;
        final int attack = 50;
        final int health = 100;
        final String joe = "Joe";
        final String cannibal = "Cannibal";
        final boolean isDead = false;

        when(this.properties.name()).thenReturn(cannibal);
        when(this.view.display(isDead,attack,health,joe,cannibal)).thenReturn(expected);
        final boolean isUpdate = enemy.update(attack, health, joe);

        assertEquals("Not update", expected, isUpdate);
    }

    @Test
    public void testUpdateRejected() throws Exception {
        final boolean expected = false;
        final int attack = 50;
        final int health = 100;
        final String joe = "Joe";
        final String joe2 = "Joe";

        when(this.properties.name()).thenReturn(joe2);
        final boolean isUpdate = enemy.update(attack, health, joe);

        assertEquals("Not update", expected, isUpdate);
    }

    @Test
    public void testSet() throws Exception {
        Enemy enemySpy = spy(enemy);
        final int attack = 10;
        final int health = 100;

        enemySpy.set(attack, health);

        verify(enemySpy).set(attack,health);
    }
}