package creational.objectpool.src;

import creational.objectpool.api.ObjectPool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vicboma on 17/06/14.
 */
public abstract class ObjectPoolImpl<T> implements ObjectPool<T> {
    protected Integer maxObjects;
    protected Long expirationTime;
    private Map<T, Long> locked, unlocked;

    public ObjectPoolImpl() {
        this.locked = new ConcurrentHashMap();
        this.unlocked = new ConcurrentHashMap();
    }

    @Override
    public T checkOut() {
        synchronized (this) {
            final long initTime = System.currentTimeMillis();
            T element = null;
            Long time;
            if (!unlocked.isEmpty()) {
                for (Map.Entry<T, Long> entry : unlocked.entrySet()) {
                    element = entry.getKey();
                    time = entry.getValue();
                    final long resultTime = initTime - time;
                    if (resultTime > expirationTime)
                        delete(element);
                    else {
                        if (isAlive(element)) {
                            unlocked.remove(element);
                            locked.put(element, initTime);
                            return (element);
                        } else
                            delete(element);
                    }
                }
            }
            if (locked.size() < this.maxObjects) {
                element = create();
                System.out.println("Create [" + locked.size() + "] " + element.toString());
                locked.put(element, initTime);
            }

            return element;
        }
    }

    private void delete(T element) {
        unlocked.remove(element);
        remove(element);
        System.out.println("Delete [" + unlocked.size() + "] " + element.toString());
    }

    @Override
    public void checkIn(T t) {
        synchronized (this) {
            if(locked.containsKey(t))
                locked.remove(t);

            unlocked.put(t, System.currentTimeMillis());
        }

    }
}