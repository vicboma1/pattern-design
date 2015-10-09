package structural.composite.src;

import structural.composite.api.Context;

/**
 * Created by vicboma on 26/06/14.
 */
public class Level implements Context {
    private String name;


    public Level(String name) {
        this.name = name;
    }

    @Override
    public void create() {
        final String str = toString();
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                '}';
    }
}
