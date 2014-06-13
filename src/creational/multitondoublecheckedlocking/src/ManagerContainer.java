package creational.multitondoublecheckedlocking.src;

import creational.multitondoublecheckedlocking.api.MultitonDoubleCheckedLocking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vicboma on 13/06/14.
 */
public class ManagerContainer {

    private static final Map<Class<? extends MultitonDoubleCheckedLocking>, MultitonDoubleCheckedLocking> instancesMap = new ConcurrentHashMap();

    private ManagerContainer() {
        super();
    }

    /**
     * Classic Multiton with reflection.
     *
     * @param key Object
     * @return
     */
    public static <T extends Class<? extends MultitonDoubleCheckedLocking>> MultitonDoubleCheckedLocking getInstance(T key) {
        MultitonDoubleCheckedLocking instance = null;
        if ((instance = instancesMap.get(key)) == null) {
            synchronized (instancesMap) {
                if ((instance = instancesMap.get(key)) == null) {
                    try {
                        instance = key.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Create and register new instance " + instance.getClass() + " " + instance.toString());
                    instancesMap.put(key, instance);
                }
            }
        }
        return instance;
    }
}

