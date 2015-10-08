package creational.lazyinitialization.src;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vicboma on 18/06/14.
 */
public class LazyInitialization {

    private static Map<Class<?>, Object> mapObjects = new ConcurrentHashMap();

    public static <T> T getObjectByClass(Class<? extends T> clazz) {
        T newObject = null;

        if (!mapObjects.containsKey(clazz)) {
            synchronized (mapObjects) {

                try {
                    newObject = clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    mapObjects.put(clazz, newObject);
                }
            }
        } else
            newObject = (T) mapObjects.get(clazz);

        return newObject;
    }
}
