package creational.objectpool.api;

/**
 * Created by vicboma on 18/06/14.
 */
public interface ObjectPool<T> {
    Long EXPIRATION_TIME = 2000L;
    Integer MAX_PARTICLES = 100;

    T checkOut();

    void checkIn(T t);

    abstract T create();

    abstract Boolean isAlive(T o);

    abstract void remove(T o);
}
