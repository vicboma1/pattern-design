package structural.adapter.src;

import org.junit.Before;
import org.junit.Test;
import structural.adapter.api.Vector2D;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class Vector2DImplTest {

    public static final double X = 100.0;
    private Vector2D vector2D;

    @Before
    public void setUp() throws Exception {
        vector2D = new Vector2DImpl(X, X);
    }

    @Test
    public void testSet() throws Exception {
        final double x = -1.0;
        final double y = 101.0;

        final Vector2D vector2DSpy = spy(vector2D);
        vector2DSpy.set(x, y);

        verify(vector2DSpy).set(x, y);
    }

    @Test
    public void testX() throws Exception {
        Double x = 100.0;
        assertEquals("fail set x", x, vector2D.x());
    }

    @Test
    public void testY() throws Exception {
        Double y = 100.0;
        assertEquals("fail set y", y, vector2D.y());
    }

    @Test
    public void testRadius() throws Exception {
        final Double expected = 141.4213562373095;
        final Double radius = this.vector2D.radius();
        assertEquals("fail radius", expected, radius);
    }

    @Test
    public void testTheta() throws Exception {
        final Double expected = 0.7853981633974483;
        final Double result = this.vector2D.theta();
        assertEquals("fail Theta", expected, result);
    }

    @Test
    public void testPlus() throws Exception {
        final String expected = new Vector2DImpl(200.0, 200.0).toString();
        final Vector2D vector2Dplus = new Vector2DImpl(100.0, 100.0);
        final String result = this.vector2D.plus(vector2Dplus).toString();
        assertEquals("fail Plus", expected, result);
    }

    @Test
    public void testMinus() throws Exception {
        final String expected = new Vector2DImpl(0.0, 0.0).toString();
        final Vector2D vector2Dmin = new Vector2DImpl(100.0, 100.0);
        final String result = this.vector2D.minus(vector2Dmin).toString();
        assertEquals("fail Minus", expected, result);
    }

    @Test
    public void testTimes() throws Exception {
        final String expected = new Vector2DImpl(500.0, 500.0).toString();
        final String result = this.vector2D.times(5.0).toString();
        assertEquals("fail times", expected, result);
    }

    @Test
    public void testLength() throws Exception {
        final Double expected = 141.4213562373095;
        final Double length = this.vector2D.length();
        assertEquals("fail length", expected, length);
    }

    @Test
    public void testToPolar() throws Exception {
        final String expected = new Vector2DImpl(141.4213562373095, 0.7853981633974483).toString();
        final String result = this.vector2D.toPolar().toString();
        assertEquals("fail toPolar", expected, result);
    }


    @Test
    public void testToRect() throws Exception {
        final Double expected = 141.4213562373095;
        final Double length = this.vector2D.length();
        assertEquals("fail length", expected, length);
    }

    @Test
    public void testEquals() throws Exception {
        final boolean result = this.vector2D.equals(new Vector2DImpl(100.0, 100.0));
        assertTrue("fail Equals", result);
    }

    @Test
    public void testToString() throws Exception {
        final String expected = "[100.0,100.0]";
        final String str = this.vector2D.toString();
        assertEquals("fail toString", expected, str);
    }

    @Test
    public void testCreate() throws Exception {
        final Vector2D vector2D = new Vector2DImpl();
        assertNotNull("null value", vector2D);

    }

    @Test
    public void testCreate2() throws Exception {
        final Vector2D vector2D = new Vector2DImpl(X,X);
        assertNotNull("null value",vector2D);

    }

    @Test
    public void testCreate3() throws Exception {
        final Vector2D vector2D = new Vector2DImpl(X);
        assertNotNull("null value",vector2D);

    }
    @Test
    public void testCreate4() throws Exception {
        final Vector2D v = new Vector2DImpl(X);
        final Vector2D vector2D = new Vector2DImpl(v);
        assertNotNull("null value",vector2D);

    }
    @Test
    public void testCreate5() throws Exception {
        Point2D.Double pdouble = new Point2D.Double(X,X);
        final Vector2D vector2D = new Vector2DImpl(pdouble);
        assertNotNull("null value", vector2D);
    }

    @Test
    public void testDot() throws Exception {
        Vector2DImpl vector2D = new Vector2DImpl();
        final Vector2D dot = vector2D.dot(vector2D);
        assertEquals(dot.x().intValue(), 0);
        assertEquals(dot.y().intValue(), 0);
    }


}