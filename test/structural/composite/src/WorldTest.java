package structural.composite.src;

import org.junit.Before;
import org.junit.Test;
import structural.composite.api.Context;

import java.util.ArrayList;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class WorldTest {

    private World worldCreator;
    private World worl1;
    private World worl2;
    private Level level1_0;
    private Level level1_1;
    private Level level1_2;
    private Level level2_0;
    private Level level2_1;
    private Level level3_2;

    @Before
    public void setUp() throws Exception {
        worldCreator = new World(new ArrayList<Context>(), "World Creator");

        final World world1 = new World(new ArrayList<Context>(), "World-1");
        world1.add(new Level("Level1_1"));
        world1.add(new Level("Level1_2"));
        worldCreator.add(world1);

        final World world2 = new World(new ArrayList<Context>(), "World-2");
        world2.add(new Level("Level2_1"));
        world2.add(new Level("Level2_2"));
        world2.add(new Level("Level2_3"));
        worldCreator.add(world2);

        final World world3 = new World(new ArrayList<Context>(), "World-3");
        world3.add(new Level("Level3_1"));
        worldCreator.add(world3);

        final World world4 = new World(new ArrayList<Context>(), "World-4");
        world4.add(new Level("Level4_1"));
        world4.add(new Level("Level4_2"));
        world4.add(new Level("Level4_3"));
        world4.add(new Level("Level4_4"));
        worldCreator.add(world4);
    }

    @Test
    public void testAdd() throws Exception {
        World worldSpy = spy(worldCreator);
        final World context = new World(new ArrayList<Context>(), "World-1");
        worldSpy.add(context);
        verify(worldSpy).add(context);
    }

    @Test
    public void testRemove() throws Exception {
        final World context = new World(new ArrayList<Context>(), "World-1");
        World worldSpy = spy(worldCreator);
        worldSpy.add(context);
        worldSpy.remove(context);
        verify(worldSpy).remove(context);
    }

    @Test
    public void testCreate() throws Exception {
        World worldSpy = spy(worldCreator);
        worldSpy.create();
        verify(worldSpy).create();
    }


}