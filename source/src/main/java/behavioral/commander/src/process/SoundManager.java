package behavioral.commander.src.process;

import behavioral.commander.api.TaskGame;

/**
 * Created by vicboma on 06/06/14.
 */
public class SoundManager implements TaskGame {

    public static final String EXECUTE_SOUND_MANAGER = "Execute SoundManager";

    @Override
    public <T> T execute() {
        return (T) EXECUTE_SOUND_MANAGER;
    }
}
