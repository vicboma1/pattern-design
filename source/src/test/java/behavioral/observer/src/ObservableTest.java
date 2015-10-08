package behavioral.observer.src;

import behavioral.observer.api.Observer;
import behavioral.observer.src.model.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class ObservableTest {

    private Observable<Observer> observable;

    @Before
    public void setUp() throws Exception {
        observable = StatusData.<Observer>create();
    }

    @Test
    public void testAdd() throws Exception {
        final boolean expected = true;

        final Player mock = mock(Player.class);
        final boolean isAdd = observable.add(mock);

        assertEquals("Not add", expected, isAdd);
    }

    @Test
    public void testRemove() throws Exception {
        final boolean expected = true;

        final Player mockPlayer = mock(Player.class);
        observable.add(mockPlayer);
        final boolean isRemove = observable.add(mockPlayer);

        assertEquals("Not add", expected, isRemove);
    }

    @Test
    public void testNotification() throws Exception {
        final Observable<Observer> observableSpy = spy(this.observable);

        final int attack = 50;
        final int health = 100;
        final String joe = "Joe";
        observableSpy.notification(attack,health,joe);

        verify(observableSpy).notification(attack,health,joe);
    }
}