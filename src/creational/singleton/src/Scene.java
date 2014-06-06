package creational.singleton.src;

/**
 * Created by vicboma on 06/06/14.
 */
public class Scene<T> {
    private String name;
    private T resource;

    public Scene(String name, T resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public T getResource() {
        return resource;
    }

    public String toString(){
        return "Scene "+name;
    }
}
