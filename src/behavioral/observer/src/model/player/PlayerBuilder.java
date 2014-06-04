package behavioral.observer.src.model.player;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;
import behavioral.observer.src.model.Builder;
import behavioral.observer.src.model.Properties;

public class PlayerBuilder<E extends Observer> extends Builder<E> {

    public PlayerBuilder(Properties properties, StatusData<E> statusData, View view) {
        super(properties, statusData, view);
    }

    public Player createPlayer() {
        return new Player(this.properties, this.statusData, this.view);
    }
}