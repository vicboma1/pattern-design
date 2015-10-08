package behavioral.commander.api;

/**
 * Created by vicboma on 06/06/14.
 */
public interface ComnandGame<K,V> {

    /**
     * @param key -> ID
     * @param value -> Interface -> Polymorphism
     * Channeable Method
     * @return
     */
    ComnandGame<K,V> register(K key, V value);

    /**
     * Executes the object registered
     * @param type
     * @param <T>
     * @return
     */
    <T> T execute(K type);

    /**
     * Number of the elements registered
     * @return
     */
    Integer size();
}
