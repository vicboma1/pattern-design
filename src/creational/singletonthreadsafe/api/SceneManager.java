package creational.singletonthreadsafe.api;

/**
 * Created by vicboma on 06/06/14.
 */
public interface SceneManager<K,V> {

    V put(K key, V scene);
    V remove(K key);
    V goTo(K key);
    Integer size();
    void destroy();

}
