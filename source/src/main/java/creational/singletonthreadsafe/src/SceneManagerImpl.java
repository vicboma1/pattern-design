package creational.singletonthreadsafe.src;

import creational.singletonthreadsafe.api.SceneManager;

import java.util.Map;

/**
 * Created by vicboma on 06/06/14.
 */
public class SceneManagerImpl<K,V> implements SceneManager<K,V> {

    private Map<K,V> mapScene;

    public SceneManagerImpl(Map<K, V> mapScene) {
        this.mapScene = mapScene;
    }

    @Override
    public V put(K key, V scene) {
        return mapScene.put(key,scene);
    }

    @Override
    public V remove(K key) {
        return mapScene.remove(key);
    }

    @Override
    public V goTo(K key) {
        return mapScene.get(key);
    }

    @Override
    public Integer size() {
        return mapScene.size();
    }

    @Override
    public void destroy() {
        mapScene.clear();
        mapScene = null;
    }
}
