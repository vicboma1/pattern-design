package behavioral.commander.src.process;

import behavioral.commander.api.TaskGame;

/**
 * Created by vicboma on 06/06/14.
 */
public class LevelManager implements TaskGame {

    public static final String EXECUTE_LEVEL_MANAGER = "Execute LevelManager";

    @Override
    public <T> T execute() {
        return (T) EXECUTE_LEVEL_MANAGER;
    }
}
