package creational.objectpool.src;

import creational.objectpool.src.model.Particle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class ObjectPoolImplTest {

    private ParticlePool particlePool;

    @Before
    public void setUp() throws Exception {
        particlePool = ParticlePool.getInstance();
    }

    @Test
    public void testCheckOut() throws Exception {
        final Particle particle1 = particlePool.checkOut();
        final Particle particle2 = particlePool.checkOut();

        assertNotEquals("fail checkOut", particle1, particle2);
    }

   /* @Test
    public void testCheckIn() throws Exception {
        final ParticlePool particlePoolSpy = spy(particlePool);

        final Particle particle1 = particlePoolSpy.checkOut();
        particlePoolSpy.checkIn(particle1);

        verify(particlePoolSpy).checkIn(particle1);
    }*/

    @Test
    public void testCreation() throws Exception {
        List<Particle> particleList = new ArrayList();
        IntStream stream = IntStream.range(0, 100);
        stream.sequential().forEach(x -> {
            assertNotNull("creation fail", particleList.add(particlePool.checkOut()));
        });
        stream = IntStream.range(0, 10);
        stream.sequential().forEach(x -> {
            assertNull("creation fail", particlePool.checkOut());
        });
        stream = IntStream.range(0, 10);
        stream.sequential().forEach(x -> {
            particlePool.checkIn(particleList.get(x));
        });
        stream = IntStream.range(0, 10);
        stream.sequential().forEach(x -> {
            assertNotNull("creation fail", particlePool.checkOut());
        });
    }

}