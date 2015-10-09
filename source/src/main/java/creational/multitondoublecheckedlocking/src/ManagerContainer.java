package creational.multitondoublecheckedlocking.src;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vicboma on 13/06/14.
 */
public class ManagerContainer {

    private static final Map<Class, Object> instancesMap = new ConcurrentHashMap();

    private ManagerContainer() {
        super();
    }

    /**
     * Classic Multiton with reflection.
     *
     * @param key Object
     * @return
     */
    public static <T> T getInstance(final Class<T> key) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object instance = null;
        if ((instance = instancesMap.get(key)) == null) {
            synchronized (instancesMap) {
                if ((instance = instancesMap.get(key)) == null) {
                    instance = _getInstance(key);
                    System.out.println("Create and register new instance " + instance.getClass() + " " + instance.toString());
                    instancesMap.put(key, instance);

                }
            }
        }
        return (T)instance;
    }

    private static <T> Object _getInstance(final Class<T> key) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            Object instance = instancesMap.get(key);
            if (instance == null) {
                Class< ? > enclosingClass = key.getEnclosingClass();
                if (enclosingClass != null) {
                    instance = findIntance(key, instance, enclosingClass);
                } else
                    instance = key.newInstance();

                instancesMap.put(key,instance);
            }
            return (T) instance;
    }

    private static <T> Object findIntance(Class<T> key, Object instance, Class<?> enclosingClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object instanceOfEnclosingClass = getInstance(enclosingClass);
        Constructor<T> ctor = null;
        try {
            ctor = key.getConstructor(enclosingClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (ctor != null)
            instance = ctor.newInstance(instanceOfEnclosingClass);

        return instance;
    }
}

