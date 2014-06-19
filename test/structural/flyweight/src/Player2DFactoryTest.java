package structural.flyweight.src;

import org.junit.Before;
import org.junit.Test;
import structural.adapter.api.Vector2D;
import structural.adapter.src.Vector2DImpl;
import structural.flyweight.api.ComponentPlayer2D;
import structural.flyweight.api.Player2D;
import structural.flyweight.src.model.Luigi;
import structural.flyweight.src.model.Mario;
import structural.flyweight.src.model.SuperMario;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Player2DFactoryTest {

    private Vector2D velocity;
    private List<ComponentPlayer2D> componentsPlayer;

    @Before
    public void setUp() throws Exception {
        velocity = new Vector2DImpl(2.0);
        componentsPlayer = new ArrayList();
    }

    @Test
    public void testGetPlayer2D() throws Exception {
        final Actor mario1 = new Actor(Color.RED, "Mario");
        final Actor luigi1 = new Actor(Color.GREEN, "Luigi");
        final Actor superMario1 = new Actor(Color.white, "Mario");

        final Player2D mario = Player2DFactory.getPlayer2D(mario1);
        final Player2D luigi = Player2DFactory.getPlayer2D(luigi1);
        assertNotEquals("fail create", mario, luigi);
        final Player2D superMario = Player2DFactory.getPlayer2D(superMario1);
        assertEquals("fail create", mario, superMario);
    }

    @Test
    public void testGetPlayer2DPosition() throws Exception {
        final Actor mario1 = new Actor(Color.RED, "Mario");
        final Actor luigi1 = new Actor(Color.GREEN, "Luigi");
        final Actor superMario1 = new Actor(Color.white, "SuperMario");

        final Mario mario = new Mario((Player2DFactory.getPlayer2D(mario1)));
        componentsPlayer.add(mario);
        final Luigi luigi = new Luigi(Player2DFactory.getPlayer2D(luigi1));
        componentsPlayer.add(luigi);
        final SuperMario superMario = new SuperMario(Player2DFactory.getPlayer2D(superMario1));
        componentsPlayer.add(superMario);

        for (double x = 1.0; x < 200.0; x++) {
            componentsPlayer.get(2).update(new Vector2DImpl(x), velocity);
        }

        assertNotEquals("fail position", mario, superMario);
        assertNotEquals("fail position", luigi, superMario);
    }

    @Test
    public void testGetPlayer2DSamePosition() throws Exception {
        final Actor mario1 = new Actor(Color.RED, "Mario");
        final Actor luigi1 = new Actor(Color.GREEN, "Luigi");
        final Actor superMario1 = new Actor(Color.white, "Mario");

        final Mario mario = new Mario((Player2DFactory.getPlayer2D(mario1)));
        componentsPlayer.add(mario);
        final Luigi luigi = new Luigi(Player2DFactory.getPlayer2D(luigi1));
        componentsPlayer.add(luigi);
        final SuperMario superMario = new SuperMario(Player2DFactory.getPlayer2D(superMario1));
        componentsPlayer.add(superMario);

        for (double x = 1.0; x < 200.0; x++) {
            componentsPlayer.get(2).update(new Vector2DImpl(x), velocity);
        }

        assertEquals("fail position", mario1, superMario1);
        assertNotEquals("fail position", luigi1, superMario1);
    }


}