package creational.objectpool.src;

import creational.objectpool.api.ObjectPool;
import creational.objectpool.src.model.Particle;

import java.awt.geom.Point2D;

/**
 * Created by vicboma on 17/06/14.
 */
public class ParticlePool extends ObjectPoolImpl<Particle> {
    private static volatile ParticlePool INSTANCE_POOL = null;
    private static Object syncRoot = new Object();

    /**
     * Thread Safe and pattern double-check locking
     *
     * @return
     */
    public static ParticlePool getInstance() {
        if (ParticlePool.INSTANCE_POOL == null) {
            synchronized (syncRoot) {
                if (ParticlePool.INSTANCE_POOL == null) {
                    return createParticlePool();
                }
            }
        }
        return INSTANCE_POOL;
    }

    private static ParticlePool createParticlePool() {
        return INSTANCE_POOL = new ParticlePool(ObjectPool.EXPIRATION_TIME, ObjectPool.MAX_PARTICLES);
    }

    public ParticlePool(Long expiratetime, Integer maxObjects) {
        super();
        this.expirationTime = expiratetime;
        this.maxObjects = maxObjects;
    }

    @Override
    public Particle create() {
        final double velX = new Double(Math.random());
        final double velY = new Double(Math.random());
        final Particle particle = Particle.create(new Point2D.Double(0.5, 0.5), new Point2D.Double(velX, velY));
        return particle;
    }

    @Override
    public Boolean isAlive(Particle particle) {
        final boolean isAlive = particle.isAlive();
        return isAlive;
    }

    @Override
    public void remove(Particle particle) {
        particle.dispose();
        particle = null;
    }
}
