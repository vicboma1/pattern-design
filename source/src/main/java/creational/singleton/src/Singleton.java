package creational.singleton.src;

import creational.singleton.api.SceneManager;
import java.util.*;

/**
 * Created by vicboma on 06/06/14.
 */
public class Singleton {

    private static SceneManager SCENE_MANAGER;

    /**
     * First version - not thread-safe
     * @return
     */
    public static <K,V>  SceneManager<K,V> sceneManager()
    {
        if (SCENE_MANAGER == null)
        {
            SCENE_MANAGER = new SceneManagerImpl<K, V>(new Hashtable<K,V>());
        }
        return SCENE_MANAGER;
    }
}
