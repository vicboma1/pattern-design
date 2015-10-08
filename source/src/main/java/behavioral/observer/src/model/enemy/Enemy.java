package behavioral.observer.src.model.enemy;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Properties;
import creational.simplefactory.api.ActorEnemy;

/**
 * Created by vicboma on 03/06/14.
 */
public class Enemy implements Observer, ActorEnemy {
    private Properties properties;
    private StatusData<Observer> statusData;
    private View view;

    public static Enemy create(Properties properties, StatusData<Observer> statusData, View view) {
        return new EnemyBuilder<Observer>(properties, statusData, view).createEnemy();
    }

    public static Enemy create() {
        return new Enemy();
    }

    public Enemy() {
    }

    Enemy(Properties properties, StatusData statusData, View view) {
        this.view = view;
        this.properties = properties;
        this.statusData = statusData;
        this.statusData.add(this);
    }

    @Override
    public Boolean update(Integer attack, Integer health, String name) {
        Boolean result = false;
        if (this.properties.name().equals(name))
            return result;

        final boolean isDead = (health <= 0);
        result = this.view.display(isDead, attack, health, name, this.properties.name());

        return result;

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
