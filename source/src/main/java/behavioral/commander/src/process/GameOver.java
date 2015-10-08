package behavioral.commander.src.process;

import behavioral.commander.api.TaskGame;

/**
 * Created by vicboma on 06/06/14.
 */
public class GameOver implements TaskGame {

    public static final String EXECUTE_GAME_OVER = "Execute GameOver";

    @Override
    public <T> T execute() {
        return (T) EXECUTE_GAME_OVER;
    }
}
