package creational.objectpool.src;

import creational.objectpool.src.model.Particle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ParticlePoolTest {

    private ParticlePool particlePool;

    @Before
    public void setUp() throws Exception {
        particlePool = ParticlePool.getInstance();
    }

    @Test
    public void testCreate() throws Exception {
        final Particle particle1 = particlePool.create();
        final Particle particle2 = particlePool.create();

        assertNotEquals("fail creation", particle1, particle2);
    }

    @Test
    public void testIsAlive() throws Exception {
        final Particle particle = particlePool.create();
        final boolean isAlive = particlePool.isAlive(particle);
        assertTrue("fail is alive", isAlive);
    }

    @Test
    public void testRemove() throws Exception {
        final ParticlePool particlePoolSpy = spy(particlePool);
        final Particle particle = particlePoolSpy.create();
        particlePoolSpy.remove(particle);

        verify(particlePoolSpy).remove(particle);
    }
}