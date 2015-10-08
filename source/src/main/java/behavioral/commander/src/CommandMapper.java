package behavioral.commander.src;

import behavioral.commander.api.ComnandGame;
import behavioral.commander.api.TaskGame;

import java.util.Map;

/**
 * Created by vicboma on 06/06/14.
 */
public class CommandMapper<K,V extends TaskGame> implements ComnandGame<K,V> {
    private Map<K,V> map;

    /**
     * Factory Method
     */
    public static <K,V extends TaskGame> CommandMapper<K,V> create(Map<K, V> map)
    {
        return new CommandMapper<K, V>(map);
    }

    CommandMapper(Map<K, V> map) {
        this.map = map;
    }

    public ComnandGame<K,V> register(K key, V value){
        this.map.put(key, value);
        return this;
    }

    public <T> T execute(K type)
    {
        final V taskGame = this.map.get(type);
        T result = taskGame.<T>execute();
        return result;
    }

    public Integer size()
    {
        return this.map.size();
    }
}
