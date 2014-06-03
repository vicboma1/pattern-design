package behavioral.observer.src.model.enemy;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.DisplayElement;
import behavioral.observer.src.model.Properties;

/**
 * Created by vicboma on 03/06/14.
 */
public class Enemy implements Observer{
    private Properties properties;
    private StatusData<Observer> statusData;
    private View view;

    public static Enemy create(Properties properties, StatusData<Observer> statusData, View view) {
        return new EnemyBuilder<Observer>(properties,statusData,view).createEnemy();
    }

    Enemy(Properties properties, StatusData statusData, View view)
    {
    	this.view = view;
        this.properties = properties;
        this.statusData = statusData;
        this.statusData.add(this);
    }

    @Override
    public void update(Integer attack, Integer health, String name) {
    	if(this.properties.name().equals(name))
    		return ;
    	
    	final boolean isDead = (health <= 0);
    	this.view.display(isDead,attack,health,name,this.properties.name());
    }
    
    @Override
    public void set(Integer attack, Integer health){
        setProperties(attack, health);
        setStatus();
    }

    private void setProperties(Integer attack, Integer health) {
        this.properties.set(attack, health);
    }

    private void setStatus() {
        this.statusData.set(this.properties.attack(), this.properties.health(),this.properties.name());
    }
}
