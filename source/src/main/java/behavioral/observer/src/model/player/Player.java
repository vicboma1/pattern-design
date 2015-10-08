package behavioral.observer.src.model.player;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Properties;

/**
 * Created by vicboma on 03/06/14.
 */
public class Player implements Observer {
    private Properties properties;
    private StatusData<Observer> statusData;
    private View view;

    public static Player create(Properties properties, StatusData<Observer> statusData, View view) {
        return new PlayerBuilder<Observer>(properties, statusData, view).createPlayer();
    }

    public Player() {
    }

    Player(Properties properties, StatusData statusData, View view) {
        this.view = view;
        this.properties = properties;
        this.statusData = statusData;
        this.statusData.add(this);
    }

    @Override
    public Boolean update(Integer attack, Integer health, String name) {
        final boolean isDead = (health <= 0);
        return this.view.display(isDead, attack, health, name, this.properties.name());
    }

    @Override
    public void set(Integer attack, Integer health) {
        setProperties(attack, health);
        setStatus();
    }

    private void setProperties(Integer attack, Integer health) {
        this.properties.set(attack, health);
    }

    private void setStatus() {
        this.statusData.set(this.properties.attack(), this.properties.health(), this.properties.name());
    }
}
