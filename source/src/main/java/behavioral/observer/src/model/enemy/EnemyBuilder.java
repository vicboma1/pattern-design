package behavioral.observer.src.model.enemy;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Builder;
import behavioral.observer.src.model.Properties;

public class EnemyBuilder<E extends Observer> extends Builder {
    public EnemyBuilder(Properties properties, StatusData<E> statusData, View view) {
        super(properties, statusData, view);
    }

    public Enemy createEnemy() {
        return new Enemy(this.properties, this.statusData, this.view);
    }
}