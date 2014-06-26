package structural.bridge.src.motor;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class GasolineTest {

    private Gasoline gasoline;

    @Before
    public void setUp() throws Exception {
        gasoline = Gasoline.create(Stroke.FOUR);
    }

    @org.junit.Test
    public void testStart() throws Exception {
        Gasoline gasolineSpy = spy(gasoline);
        gasolineSpy.start();
        verify(gasolineSpy).start();
    }

    @org.junit.Test
    public void testInject() throws Exception {
        final double combustion = 45.0;
        Gasoline gasolineSpy = spy(gasoline);
        gasolineSpy.start();
        gasolineSpy.inject(combustion);
        verify(gasolineSpy).inject(combustion);
    }

    @org.junit.Test
    public void testStop() throws Exception {
        Gasoline gasolineSpy = spy(gasoline);
        gasolineSpy.stop();
        verify(gasolineSpy).stop();
    }

    @org.junit.Test
    public void testIsStartRejected() throws Exception {
        this.gasoline.stop();
        assertFalse("fail isStart", this.gasoline.isStart());
    }

    @org.junit.Test
    public void testIsStartResolved() throws Exception {
        this.gasoline.start();
        assertTrue("fail isStart", this.gasoline.isStart());
    }
}
