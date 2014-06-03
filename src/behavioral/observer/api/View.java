package behavioral.observer.api;

/**
 * Created by vicboma on 03/06/14.
 */
public interface View {
    void display(Boolean isDead, Integer attack, Integer health, String name, String nameNotify);
}
