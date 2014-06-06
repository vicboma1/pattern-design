[Command pattern](http://en.wikipedia.org/wiki/Command_pattern)
=================

* Is used to represent and encapsulate all the information needed to call a method at a later time.

```
Register Task: GAME_OVER     -> Value: behavioral.commander.src.process.GameOver
Register Task: MENU          -> Value: behavioral.commander.src.process.Menu
Register Task: LEVEL_MANAGER -> Value: behavioral.commander.src.process.LevelManager
Register Task: SOUND         -> Value: behavioral.commander.src.process.SoundManager

Execute Task: GAME_OVER      -> Result: Execute GameOver
Execute Task: SOUND          -> Result: Execute SoundManager
Execute Task: MENU           -> Result: Execute Menu
Execute Task: LEVEL_MANAGER  -> Result: Execute LevelManager

```
