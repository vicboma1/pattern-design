package behavioral.commander.src;

import behavioral.commander.api.ComnandGame;
import behavioral.commander.api.TaskGame;
import behavioral.commander.src.process.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CommandMapperTest {

    private ComnandGame<ProcessType, TaskGame> commandGame;
    private Map<ProcessType,String> responseMap;

    @Before
    public void testUp() throws Exception {
        commandGame = CommandMapper.create(new Hashtable<ProcessType, TaskGame>());
    }

    @Test
    public void testRegister() throws Exception {
        final Integer expected = 4;

        registeredTaskGame();

        assertEquals("registered fail", expected, commandGame.size());
    }

    @Test
    public void testExecute() throws Exception {

        prepareProcessType();
        registeredTaskGame();

        for (Map.Entry<ProcessType, String> entry : responseMap.entrySet())
        {
            final ProcessType processType = entry.getKey();
            final String expected = entry.getValue();

            final String response = commandGame.<String>execute(processType);

            assertEquals("execute fail", expected,response);
        }
    }

    private void prepareProcessType()
    {
        responseMap = new Hashtable()
        {
            {
                put(ProcessType.GAME_OVER, GameOver.EXECUTE_GAME_OVER);
                put(ProcessType.MENU, Menu.EXECUTE_MENU);
                put(ProcessType.LEVEL_MANAGER, LevelManager.EXECUTE_LEVEL_MANAGER);
                put(ProcessType.SOUND, SoundManager.EXECUTE_SOUND_MANAGER);

            }
        };
    }

    private void registeredTaskGame() {
        commandGame
                .register(ProcessType.GAME_OVER, new GameOver())
                .register(ProcessType.MENU, new Menu())
                .register(ProcessType.LEVEL_MANAGER, new LevelManager())
                .register(ProcessType.SOUND, new SoundManager());
    }
}