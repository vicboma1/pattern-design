package structural.composite.src;

import structural.composite.api.Context;

import java.util.List;

/**
 * Created by vicboma on 26/06/14.
 */
public class World implements Context {
    private List<Context> contextList;
    private String name;

    public World(List<Context> contextList, String name) {
        this.contextList = contextList;
        this.name = name;
    }

    public void add(Context context) {
        this.contextList.add(context);
    }

    public void remove(Context context) {
        this.contextList.remove(context);
    }

    @Override
    public void create() {
        this.contextList.stream().sequential().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "World{" +
                "contextList=" + contextList +
                ", name='" + name + '\'' +
                '}';
    }
}
