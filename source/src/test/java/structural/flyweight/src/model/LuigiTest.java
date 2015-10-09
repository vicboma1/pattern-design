package structural.flyweight.src.model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import structural.adapter.api.Vector2D;
import structural.adapter.src.Vector2DImpl;
import structural.flyweight.api.Player2D;
import structural.flyweight.src.Actor;
import structural.flyweight.src.Player2DImpl;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 09/10/15.
 */
public class LuigiTest {

    public static final Color BLACK = Color.BLACK;
    public static final String ACTOR = "Actor";
    private Actor actor;
    private Player2D player;
    private Luigi luigi;

    @Before
    public void setUp() throws Exception {
        actor = new Actor(BLACK, ACTOR);
        player = Player2DImpl.create(actor);
        luigi = new Luigi(player);
    }

    @After
    public void tearDown() throws Exception {
        luigi = null;
        player = null;
        actor = null;
    }

    @Test
    public void testUpdate() throws Exception {
        final Luigi spy = spy(luigi);
        final Point2D.Double point2d = new Point2D.Double(2.0, 100.0);
        final Vector2DImpl newPosition = new Vector2DImpl(point2d);
        spy.update(newPosition, newPosition);
        verify(spy).update(newPosition, newPosition);
    }

    @Test
    public void testPosition() throws Exception {
        final Point2D.Double point2d = new Point2D.Double(2.0, 100.0);
        final Vector2D newPosition = new Vector2DImpl(point2d);
        luigi.update(newPosition, newPosition);
        Assert.assertTrue((double)luigi.position().x() == 4.0);
        Assert.assertTrue((double)luigi.position().y() == 10000.0);

    }

    @Test
    public void testToString() throws Exception {
        final String expected = "Component{" + "player2D=" + player + '}';
        Assert.assertTrue(luigi.toString().equals(expected));
    }
}