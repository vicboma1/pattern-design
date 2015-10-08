package structural.flyweight.src;

import java.awt.*;

/**
 * Created by vicboma on 19/06/14.
 */
public class Actor {
    private Color color;
    /* Intrinsic */
    private String name;

    public Actor(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Actor actor = (Actor) o;
        return name.equals(actor.getName());
    }

    @Override
    public int hashCode() {
        return (31 * (name != null ? name.hashCode() : 0));
    }
}
