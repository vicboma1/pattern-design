package structural.frontcontroller.src;

import structural.frontcontroller.api.Commander;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by vicboma on 27/06/14.
 */
public class Dispatcher {
    private Map<Integer, Commander> commanderMap;

    public static Dispatcher create() {
        return new Dispatcher(new Hashtable<>());
    }

    Dispatcher(Map<Integer, Commander> commanderMap) {
        this.commanderMap = commanderMap;
    }

    public Dispatcher register(Integer index, Commander command) {
        this.commanderMap.put(index, command);
        return this;
    }

    public void dispatch(Integer index) {
        final Commander commander = this.commanderMap.get(index);
        commander.execute();
    }

    public Integer size() {
        return this.commanderMap.size();
    }
}
