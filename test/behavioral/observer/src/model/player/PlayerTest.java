package behavioral.observer.src.model.player;

import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Properties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player player;
    private Properties properties;
    private StatusData statusData;
    private View view;

    @Before
    public void setUp() throws Exception {

        properties = mock(Properties.class);
        statusData = mock(StatusData.class);
        view = mock(View.class);

        player = Player.create(properties, statusData, view);
    }

    @Test
    public void testUpdateResolved() throws Exception {
        final boolean expected = true;
        final int attack = 50;
        final int health = 100;
        final String joe = "Mac";
        final String cannibal = "Cannibal";
        final boolean isDead = false;

        when(this.properties.name()).thenReturn(cannibal);
        when(this.view.display(isDead, attack, health, joe, cannibal)).thenReturn(expected);
        final boolean isUpdate = player.update(attack, health, joe);

        assertEquals("Not update", expected, isUpdate);
    }

    @Test
    public void testSet() throws Exception {
        Player playerSpy = spy(player);
        final int attack = 10;
        final int health = 100;

        playerSpy.set(attack, health);

        verify(playerSpy).set(attack, health);
    }
}
