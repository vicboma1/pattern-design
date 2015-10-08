package creational.singletonthreadsafe.src;

import creational.singletonthreadsafe.api.SceneManager;
import java.util.concurrent.*;

/**
 * Created by vicboma on 06/06/14.
 */
public class SingletonThreadSafeImpl {

    private static volatile SceneManager SCENE_MANAGER = null;
    //Asegura el asignamiento de la variale completada antes de que se pueda acceder a ella.
    private static Object syncRoot = new Object();

    public SingletonThreadSafeImpl() {
        super();
    }

    /**
     * Thread Safe and pattern double-check locking
     * @return
     */
    public static <K,V> SceneManager<K,V> sceneManager()
    {
        if(SingletonThreadSafeImpl.SCENE_MANAGER == null )
        {
            synchronized (syncRoot)
            {
                if(SingletonThreadSafeImpl.SCENE_MANAGER == null)
                {
                    return createSceneManager();
                }
            }
        }

        return SCENE_MANAGER;
    }

    private static <K, V> SceneManager<K, V> createSceneManager() {
        return SCENE_MANAGER = new SceneManagerImpl(createConcurrentHashMap());
    }

    private static ConcurrentHashMap createConcurrentHashMap() {
        return new ConcurrentHashMap();
    }
}
