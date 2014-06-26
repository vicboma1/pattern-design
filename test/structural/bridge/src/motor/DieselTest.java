package structural.bridge.src.motor;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DieselTest {

    private Diesel diesel;

    @Before
    public void setUp() throws Exception {
        diesel = Diesel.create(Stroke.TWO);
    }

    @org.junit.Test
    public void testStart() throws Exception {
        Diesel dieselSpy = spy(diesel);
        dieselSpy.start();
        verify(dieselSpy).start();
    }

    @org.junit.Test
    public void testInject() throws Exception {
        final double combustion = 32.0;
        Diesel dieselSpy = spy(diesel);
        dieselSpy.start();
        dieselSpy.inject(combustion);
        verify(dieselSpy).inject(combustion);
    }

    @org.junit.Test
    public void testStop() throws Exception {
        Diesel dieselSpy = spy(diesel);
        dieselSpy.stop();
        verify(dieselSpy).stop();
    }

    @org.junit.Test
    public void testIsStartRejected() throws Exception {
        this.diesel.stop();
        assertFalse("fail isStart", this.diesel.isStart());
    }

    @org.junit.Test
    public void testIsStartResolved() throws Exception {
        this.diesel.start();
        assertTrue("fail isStart", this.diesel.isStart());
    }
}