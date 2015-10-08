package creational.objectpool.src.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ParticleTest {

    private Particle particle;

    @Before
    public void setUp() throws Exception {
        final double velX = new Double(Math.random());
        final double velY = new Double(Math.random());
        particle = Particle.create(new Point2D.Double(0.5, 0.5), new Point2D.Double(velX, velY));
    }

    @Test
    public void testAnimate() throws Exception {
        final Particle particleSpy = spy(particle);
        particleSpy.animate();
        verify(particleSpy).animate();
    }

    @Test
    public void testIsAlive() throws Exception {
        final boolean isAlive = particle.isAlive();
        assertTrue("fail is alive", isAlive);
    }

    @Test
    public void testIsNotAlive() throws Exception {
        IntStream stream = IntStream.range(0, 20000);
        stream.sequential().forEach(x -> {
            particle.animate();
        });
        final boolean isAlive = particle.isAlive();
        TestCase.assertFalse("fail is alive", isAlive);
    }

    @Test
    public void testDispose() throws Exception {
        final Particle particleSpy = spy(particle);
        particleSpy.dispose();
        verify(particleSpy).dispose();
    }
}