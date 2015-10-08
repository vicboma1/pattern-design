package creational.simplefactory.src;

import behavioral.observer.src.model.player.Player;
import creational.simplefactory.api.SimpleFactoryPlayer;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SimpleFactoryPlayerImplTest {

    @Test
    public void testCreate() throws Exception {
        final int expected = 100;
        final SimpleFactoryPlayer simpleFactoryPlayer = new SimpleFactoryPlayerImpl();
        Set<Player> players = new HashSet<Player>();

        IntStream stream = IntStream.range(0, expected);
        stream.sequential().forEach(e -> {
            final Player player = simpleFactoryPlayer.create();
            System.out.println("Player instance " + player.toString());
            players.add(player);
        });

        assertEquals("The object is duplicate!!!!", expected, players.size());
    }

}