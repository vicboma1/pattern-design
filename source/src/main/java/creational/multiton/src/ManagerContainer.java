package creational.multiton.src;

import creational.multiton.api.Multiton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vicboma on 13/06/14.
 */
public class ManagerContainer {

    private static final Map<Class<? extends Multiton>, Multiton> instancesMap = new HashMap();

    private ManagerContainer() {
        super();
    }

    /**
     * Classic Multiton with reflection.
     *
     * @param key Object
     * @return
     */
    public static <T extends Class<? extends Multiton>> Multiton getInstance(T key) {
        synchronized (instancesMap) {
            Multiton instance = instancesMap.get(key);
            if (instance == null) {
                try {
                    instance = key.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    instancesMap.put(key, instance);
                }
            }
            return instance;
        }
    }
}
