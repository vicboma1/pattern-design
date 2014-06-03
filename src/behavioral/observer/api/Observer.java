package behavioral.observer.api;

/**
 * Created by vicboma on 03/06/14.
 */
public interface Observer {
    void set(Integer attack, Integer health);
    void update(Integer attack, Integer health, String name);
}

