package behavioral.observer.src;

import behavioral.observer.api.Observer;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class StatusDataTest {

    @Test
    public void testSet() throws Exception {
        final StatusData<Observer> observerStatusData = StatusData.<Observer>create();
        final StatusData<Observer> statusSpy = spy(observerStatusData);

        final int attack = 50;
        final int health = 100;
        final String joe = "Joe";
        statusSpy.set(attack, health, joe);

        verify(statusSpy).set(attack, health, joe);
    }
}