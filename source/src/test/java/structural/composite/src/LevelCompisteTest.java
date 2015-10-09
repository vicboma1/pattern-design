package structural.composite.src;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structural.composite.api.Context;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by vicboma on 09/10/15.
 */
public class LevelCompisteTest {

    public static final String WORLD_1 = "World1";
    private structural.composite.src.Level level;

    @Before
    public void setUp() throws Exception {
        level = new structural.composite.src.Level(WORLD_1);
    }

    @After
    public void tearDown() throws Exception {
        level = null;
    }

    @Test
    public void create() throws Exception{
        structural.composite.src.Level _spy = spy(level);
        _spy.create();
        verify(_spy).create();
    }

    @Test
    public void _toString() throws Exception{
        final String actual = "Level{" + "name='" + WORLD_1 + '\'' + '}';
        Assert.assertEquals(level.toString(), actual);
    }

    @Test
    public void testInstance() throws Exception {
        Context context = new structural.composite.src.Level(WORLD_1);
        Assert.assertNotNull(context);
    }
}